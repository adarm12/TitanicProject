import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MainPanel extends JPanel {
    List<Passenger> passengers;
    private JComboBox<String> survivedComboBox;


    public MainPanel(int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);

        this.passengers = readFromFile(Constants.PATH_TO_DATA_FILE);


        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);

        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1,
                survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);

        this.survivedComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });
    }


    public List<Passenger> readFromFile(String path) {

        List<Passenger> passengers = new ArrayList<>();
        try {

            Scanner sc = new Scanner(new File(path));
            //parsing a CSV file into the constructor of Scanner class
            sc.useDelimiter(",");
            //setting comma as delimiter pattern
            while (sc.hasNext()) {
                sc.next();
            }
            sc.close();
        }catch (FileNotFoundException e)
        {
            e.fillInStackTrace();
        }

        return passengers;

    }

}
