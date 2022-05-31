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
//        System.out.println(this.passengers.get(3));

        Filter filter = new Filter(30,50, this.passengers, this);
        this.add(filter.getButton());
        this.add(filter.getPassengerIdRangeLabel());
        this.add(filter.getPassengerIdRangeTextFieldMin());
        this.add(filter.getPassengerIdRangeTextFieldMax());
        this.add(filter.getSurvivedLabel());
        this.add(filter.getSurvivedComboBox());
        this.add(filter.getPassengerNameLabel());
        this.add(filter.getPassengerNameTextFiled());
        this.add(filter.getSexLabel());
        this.add(filter.getSexComboBox());
        this.add(filter.getPassengerSibSpNumberLabel());
        this.add(filter.getPassengerSibSpNumberTextFiled());
        this.add(filter.getPassengerParchNumberLabel());
        this.add(filter.getPassengerParchSpNumberTextFiled());
        this.add(filter.getFareLabel());
        this.add(filter.getFareTextField1());
        this.add(filter.getFareTextField2());
        this.add(filter.getTicketNumberLabel());
        this.add(filter.getTicketNumberTextFiled());
        this.add(filter.getCabinNumberLabel());
        this.add(filter.getCabinNumberTextFiled());
        this.add(filter.getEmbarkedLabel());
        this.add(filter.getEmbarkedCoboBox());
        this.add(filter.getAgeLabel());
        this.add(filter.getAgeTextFiled());


       // System.out.println(Filter.rangePassengerId(890,1,this.passengers));


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
