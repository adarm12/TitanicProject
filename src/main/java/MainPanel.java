import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainPanel extends JPanel {
    private List<Passenger> passengers;
    private ImageIcon background;

    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.background = new ImageIcon("ספינה.png");

        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.passengers = readFromFile(file);
        System.out.println(this.passengers.get(3));

        Filter combo = new Filter(30,50);
        this.add(combo.getPassengerIdRangeLabel());
        this.add(combo.getPassengerIdRangeTextField1());
        this.add(combo.getPassengerIdRangeTextField2());
        this.add(combo.getSurvivedLabel());
        this.add(combo.getSurvivedComboBox());
        this.add(combo.getPassengerNameLabel());
        this.add(combo.getPassengerNameTextFiled());
        this.add(combo.getSexLabel());
        this.add(combo.getSexComboBox());
        this.add(combo.getPassengerSibSpNumberLabel());
        this.add(combo.getPassengerSibSpNumberTextFiled());
        this.add(combo.getPassengerParchNumberLabel());
        this.add(combo.getPassengerParchSpNumberTextFiled());
        this.add(combo.getFareLabelLabel());
        this.add(combo.getFareTextField1());
        this.add(combo.getFareTextField2());
        this.add(combo.getTicketNumberLabel());
        this.add(combo.getTicketNumberTextFiled());
        this.add(combo.getCabinNumberLabel());
        this.add(combo.getCabinNumberTextFiled());
        this.add(combo.getEmbarkedLabel());
        this.add(combo.getEmbarkedCoboBox());


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

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(this.background.getImage(), 0, 0,
                Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT, null);
    }

}
