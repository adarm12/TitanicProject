import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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

    private List<Passenger> passengers;
    private ImageIcon background;
    public int counter;

    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.background = new ImageIcon("ספינה.png");

        this.passengerIdRangeLabel = CreateNew.newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT_ONE,
                y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + Constants.MARGIN_FROM_LEFT_THREE * Constants.THREE_TIMES, Constants.LABEL_HEIGHT);
        this.passengerIdRangeTextFieldMin = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.ADD_ONE,
                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);
        this.passengerIdRangeTextFieldMax = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.MARGIN_FROM_LEFT_ONE * Constants.THREE_TIMES,
                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);

        this.survivedLabel = CreateNew.newLabel("Pclass:  ", x + Constants.MARGIN_FROM_LEFT_ONE, y + Constants.MARGIN_FROM_TOP + Constants.FOUR_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + Constants.MARGIN_FROM_LEFT_THREE, Constants.LABEL_HEIGHT);
        this.survivedComboBox = CreateNew.newComboBox(Constants.PASSENGER_CLASS_OPTIONS,
                passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.ADD_ONE,
                passengerIdRangeLabel.getY() + Constants.FOUR_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.passengerNameLabel = CreateNew.newLabel("Passenger name: ", x + Constants.MARGIN_FROM_LEFT_ONE,
                y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerNameTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.ADD_ONE,
                passengerIdRangeLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.sexLabel = CreateNew.newLabel("Sex:  ", x + Constants.MARGIN_FROM_LEFT_ONE,
                y + Constants.MARGIN_FROM_TOP + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP,
                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.sexComboBox = CreateNew.newComboBox(Constants.PASSENGER_SEX_OPTIONS,
                passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.ADD_ONE,
                passengerIdRangeLabel.getY() + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.passengerSibSpNumberLabel = CreateNew.newLabel("Sibsp number: ", x + Constants.MARGIN_FROM_LEFT_ONE, y + Constants.MARGIN_FROM_TOP + Constants.SIXTEEN_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerSibSpNumberTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + Constants.ADD_ONE, passengerIdRangeLabel.getY() + Constants.SIXTEEN_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);

        this.passengerParchNumberLabel = CreateNew.newLabel("Parch number: ", x + Constants.MARGIN_FROM_LEFT_ONE + Constants.MARGIN_FROM_LEFT_TWO, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerParchSpNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.ADD_ONE, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);

        this.ticketNumberLabel = CreateNew.newLabel("Ticket number: ", x + Constants.MARGIN_FROM_LEFT_ONE + Constants.MARGIN_FROM_LEFT_TWO, y + Constants.MARGIN_FROM_TOP + Constants.FOUR_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.ticketNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.ADD_ONE, passengerParchNumberLabel.getY() + Constants.FOUR_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.fareLabel = CreateNew.newLabel("Ticket price: ", x + Constants.MARGIN_FROM_LEFT_ONE + Constants.MARGIN_FROM_LEFT_TWO, y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.fareTextField1 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.ADD_ONE, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);
        this.fareTextField2 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.MARGIN_FROM_LEFT_ONE * Constants.THREE_TIMES , passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);

        this.cabinNumberLabel = CreateNew.newLabel("Cabin number: ", x + Constants.MARGIN_FROM_LEFT_ONE + Constants.MARGIN_FROM_LEFT_TWO, y + Constants.MARGIN_FROM_TOP + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.cabinNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.ADD_ONE, passengerParchNumberLabel.getY() + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / Constants.PARTS_TWO, Constants.COMBO_BOX_HEIGHT);

        this.embarkedLabel = CreateNew.newLabel("Embarked:  ", x + Constants.MARGIN_FROM_LEFT_ONE + Constants.MARGIN_FROM_LEFT_TWO, y + Constants.MARGIN_FROM_TOP + Constants.SIXTEEN_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.embarkedCoboBox = CreateNew.newComboBox(Constants.PASSENGER_EMBARKED_OPTIONS, passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + Constants.ADD_ONE,
                passengerParchNumberLabel.getY() + Constants.SIXTEEN_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.passengers = readFromFile(file);

        this.counter = Constants.COUNTER;


        try {
            writeToNewFile(this.passengers, Constants.PATH_TO_NEW_FILE_SHANIT, this.counter);
            this.counter++;

        } catch (IOException e) {
            e.printStackTrace();
        }

        FilterPassengers filterP = new FilterPassengers(this.passengers, survivedComboBox, passengerIdRangeTextFieldMin,
                passengerIdRangeTextFieldMax, passengerNameTextFiled, sexComboBox,
                passengerSibSpNumberTextFiled, passengerParchSpNumberTextFiled, ticketNumberTextFiled
                , fareTextField1, fareTextField2, cabinNumberTextFiled,
                embarkedCoboBox);

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

    public void writeToNewFile(List<Passenger> passengerList, String path, int counter) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(Constants.PATH_TO_NEW_FILE_SHANIT + counter + ".csv");
            fileWriter.write("\n");

            int i = 0;
            while (i < passengerList.size()) {
                fileWriter.write("\n");
                i++;
            }
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
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
