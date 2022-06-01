import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainPanel extends JPanel {

    private JLabel survivedLabel;
    private JComboBox survivedComboBox;
    private JLabel passengerIdRangeLabel;
    private JTextField passengerIdRangeTextFieldMin;
    private JTextField passengerIdRangeTextFieldMax;
    private JLabel passengerNameLabel;
    private JTextField passengerNameTextFiled;
    private JLabel sexLabel;
    private JComboBox sexComboBox;
    private JLabel passengerSibSpNumberLabel;
    private JTextField passengerSibSpNumberTextFiled;
    private JLabel passengerParchNumberLabel;
    private JTextField passengerParchSpNumberTextFiled;
    private JLabel ticketNumberLabel;
    private JTextField ticketNumberTextFiled;
    private JLabel fareLabel;
    private JTextField fareTextField1;
    private JTextField fareTextField2;
    private JLabel cabinNumberLabel;
    private JTextField cabinNumberTextFiled;
    private JLabel embarkedLabel;
    private JComboBox embarkedCoboBox;
    private JButton button;
    private JLabel ageLabel;
    private JTextField ageTextFiled;


    private List<Passenger> passengers;
    private List<Passenger> afterSearchListPassengers;
    private ImageIcon background;


    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.background = new ImageIcon("ספינה.png");

        this.passengerIdRangeLabel = CreateNew.newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT,
                y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 60, Constants.LABEL_HEIGHT);
        this.passengerIdRangeTextFieldMin = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.passengerIdRangeTextFieldMax = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 75,
                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.survivedLabel = CreateNew.newLabel("Survived status:  ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.survivedComboBox = CreateNew.newComboBox(Constants.PASSENGER_CLASS_OPTIONS,
                passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
                passengerIdRangeLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox.addActionListener((e) -> {
            System.out.println("hi");
        });

        this.passengerNameLabel = CreateNew.newLabel("Passenger name: ", x + Constants.MARGIN_FROM_LEFT,
                y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerNameTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
                passengerIdRangeLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.sexLabel = CreateNew.newLabel("Sex:  ", x + Constants.MARGIN_FROM_LEFT,
                y + Constants.MARGIN_FROM_TOP + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.sexComboBox = new JComboBox(Constants.PASSENGER_SEX_OPTIONS);
        this.sexComboBox.setBounds(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
//        this.sexComboBox.addActionListener((e) -> {
//            if (e.getSource() == this.sexComboBox) {
//                if (this.sexComboBox.getSelectedIndex() != 0) {
//                    System.out.println(this.sexComboBox.getSelectedItem());
//
//                }
//            }
//        });


        this.passengerSibSpNumberLabel = CreateNew.newLabel("Sibsp number: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerSibSpNumberTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.passengerParchNumberLabel = CreateNew.newLabel("Parch number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerParchSpNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.ticketNumberLabel = CreateNew.newLabel("Ticket number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.ticketNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.fareLabel = CreateNew.newLabel("Ticket price: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.fareTextField1 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.fareTextField2 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 75, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.cabinNumberLabel = CreateNew.newLabel("Cabin number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 12 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.cabinNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 12 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.embarkedLabel = CreateNew.newLabel("Embarked:  ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.embarkedCoboBox = new JComboBox(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedCoboBox.setBounds(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.embarkedCoboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

        this.ageLabel = CreateNew.newLabel("Age: ", x + Constants.ANOTHER_MARGIN_FROM_LEFT * 2, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.ageTextFiled = CreateNew.newTextField(ageLabel.getX() + Constants.MARGIN_FROM_LEFT * 3, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);


        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.passengers = readFromFile(file);

        FilterPassengers filterP = new FilterPassengers(this.passengers, survivedComboBox, passengerIdRangeTextFieldMin,
                passengerIdRangeTextFieldMax, passengerNameTextFiled, sexComboBox,
                passengerSibSpNumberTextFiled, passengerParchSpNumberTextFiled, ticketNumberTextFiled
                , fareTextField1, fareTextField2, cabinNumberTextFiled,
                embarkedCoboBox, ageTextFiled);

        this.add(filterP.getSearchButton());
        this.add(passengerIdRangeLabel);
        this.add(passengerIdRangeTextFieldMin);
        this.add(passengerIdRangeTextFieldMax);
        this.add(survivedLabel);
        this.add(survivedComboBox);
        this.add(passengerNameLabel);
        this.add(passengerNameTextFiled);
        this.add(sexLabel);
        this.add(sexComboBox);
        this.add(passengerSibSpNumberLabel);
        this.add(passengerSibSpNumberTextFiled);
        this.add(passengerParchNumberLabel);
        this.add(passengerParchSpNumberTextFiled);
        this.add(fareLabel);
        this.add(fareTextField1);
        this.add(fareTextField2);
        this.add(ticketNumberLabel);
        this.add(ticketNumberTextFiled);
        this.add(cabinNumberLabel);
        this.add(cabinNumberTextFiled);
        this.add(embarkedLabel);
        this.add(embarkedCoboBox);
        this.add(ageLabel);
        this.add(ageTextFiled);
    }


    public List<Passenger> readFromFile(File file) {
        List<Passenger> passengers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String passenger = scanner.nextLine();
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


    public JComboBox getSurvivedComboBox() {
        return survivedComboBox;
    }

    public void setSurvivedComboBox(JComboBox survivedComboBox) {
        this.survivedComboBox = survivedComboBox;
    }

    public JTextField getPassengerIdRangeTextFieldMin() {
        return passengerIdRangeTextFieldMin;
    }

    public void setPassengerIdRangeTextFieldMin(JTextField passengerIdRangeTextFieldMin) {
        this.passengerIdRangeTextFieldMin = passengerIdRangeTextFieldMin;
    }

    public JTextField getPassengerIdRangeTextFieldMax() {
        return passengerIdRangeTextFieldMax;
    }

    public void setPassengerIdRangeTextFieldMax(JTextField passengerIdRangeTextFieldMax) {
        this.passengerIdRangeTextFieldMax = passengerIdRangeTextFieldMax;
    }

    public JTextField getPassengerNameTextFiled() {
        return passengerNameTextFiled;
    }

    public void setPassengerNameTextFiled(JTextField passengerNameTextFiled) {
        this.passengerNameTextFiled = passengerNameTextFiled;
    }

    public JComboBox getSexComboBox() {
        return sexComboBox;
    }

    public void setSexComboBox(JComboBox sexComboBox) {
        this.sexComboBox = sexComboBox;
    }

    public JTextField getPassengerSibSpNumberTextFiled() {
        return passengerSibSpNumberTextFiled;
    }

    public void setPassengerSibSpNumberTextFiled(JTextField passengerSibSpNumberTextFiled) {
        this.passengerSibSpNumberTextFiled = passengerSibSpNumberTextFiled;
    }

    public JTextField getPassengerParchSpNumberTextFiled() {
        return passengerParchSpNumberTextFiled;
    }

    public void setPassengerParchSpNumberTextFiled(JTextField passengerParchSpNumberTextFiled) {
        this.passengerParchSpNumberTextFiled = passengerParchSpNumberTextFiled;
    }

    public JTextField getTicketNumberTextFiled() {
        return ticketNumberTextFiled;
    }

    public void setTicketNumberTextFiled(JTextField ticketNumberTextFiled) {
        this.ticketNumberTextFiled = ticketNumberTextFiled;
    }

    public JTextField getFareTextField1() {
        return fareTextField1;
    }

    public void setFareTextField1(JTextField fareTextField1) {
        this.fareTextField1 = fareTextField1;
    }

    public JTextField getFareTextField2() {
        return fareTextField2;
    }

    public void setFareTextField2(JTextField fareTextField2) {
        this.fareTextField2 = fareTextField2;
    }

    public JTextField getCabinNumberTextFiled() {
        return cabinNumberTextFiled;
    }

    public void setCabinNumberTextFiled(JTextField cabinNumberTextFiled) {
        this.cabinNumberTextFiled = cabinNumberTextFiled;
    }

    public JComboBox getEmbarkedCoboBox() {
        return embarkedCoboBox;
    }

    public void setEmbarkedCoboBox(JComboBox embarkedCoboBox) {
        this.embarkedCoboBox = embarkedCoboBox;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JTextField getAgeTextFiled() {
        return ageTextFiled;
    }

    public void setAgeTextFiled(JTextField ageTextFiled) {
        this.ageTextFiled = ageTextFiled;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setBackground(ImageIcon background) {
        this.background = background;
    }

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(this.background.getImage(), 0, 0,
                Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, null);
    }
}
