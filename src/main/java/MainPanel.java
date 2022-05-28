import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainPanel extends JPanel {
    private List<Passenger> passengers;
    private JComboBox<String> survivedComboBox;

    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.passengers = readFromFile(file);
     //   System.out.println(this.passengers.get(2));

        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.survivedComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });
    }


    public List<Passenger> readFromFile(File file) {
        List<Passenger> passengers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String passenger = scanner.nextLine();
             //   System.out.println(passenger);
                if (i != 0) {
                    Passenger passengerObject = new Passenger(passenger);
                    passengers.add(passengerObject);
                }
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }


}
