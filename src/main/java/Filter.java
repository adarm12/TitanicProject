import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    Font myFont = new Font("Gisha", Font.BOLD, 18);

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

    public Filter(int x, int y, List<Passenger> passengers) {

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

//        this.button.addActionListener((e) -> {
//            List<Passenger> p = rangePassengerId(this.passengerIdRangeTextFieldMin.getText(),
//                    this.passengerIdRangeTextFieldMax.getText()
//                    , this.passengers);
//            if (this.passengerNameTextFiled.getText() != "")
//                p = byName(p, this.passengerNameTextFiled.getText());

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
        this.sexComboBox.addActionListener((e) -> {
            System.out.println(this.sexComboBox.getSelectedIndex());
//            List<Passenger> p2 = bySex(this.passengers,this.sexComboBox.ge);
//            if (this.passengerNameTextFiled.getText() != "")
//                p = byName(p, this.passengerNameTextFiled.getText());
//            System.out.println(p);
        });

        this.passengerSibSpNumberLabel = CreateNew.newLabel("Sibsp number: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerSibSpNumberTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.passengerParchNumberLabel = CreateNew.newLabel("Parch number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerParchSpNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.ticketNumberLabel = CreateNew.newLabel("Ticket number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.ticketNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.fareLabel = CreateNew.newLabel("Ticket price: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.fareTextField1 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.fareTextField2 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 75, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.cabinNumberLabel = CreateNew.newLabel("Cabin number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 12 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.cabinNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 12 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.embarkedLabel = CreateNew.newLabel("Embarked:  ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.embarkedCoboBox = new JComboBox(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embarkedCoboBox.setBounds(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + Constants.SIXTEEN_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.embarkedCoboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

        this.button = newButton("search", Constants.SEARCH_BUTTON_X, Constants.SEARCH_BUTTON_Y);
        this.passengers = passengers;

    }

    public List<Passenger> rangePassengerId(String startFrom, String limitTo, List<Passenger> passengers) {
        if (startFrom.equals("") || startFrom.contains("-")) {
            startFrom = "1";
        }
        if (limitTo.equals("") || limitTo.contains("-")) {
            limitTo = "891";
        }
        int min = Integer.parseInt(startFrom);
        int max = Integer.parseInt(limitTo);
        if (min > max && max != 0) {
            System.out.println("not vailied");
            return this.passengers.stream().skip(passengers.size()).collect(Collectors.toList());
        } else {
            return this.passengers.stream().limit(max).skip(min - 1).collect(Collectors.toList());
        }
    }

    public List<Passenger> byName(List<Passenger> list, String name) {
        List<Passenger> passengers = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains((name)))
                passengers.add(list.get(i));
        }
        return passengers;
        //  return this.passengers.stream().filter().collect(Collectors.toList());
    }

    private List<Passenger> bySex(List<Passenger> list, String sex) {
        List<Passenger> passengers = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSex().equals(sex)) {
                passengers.add(list.get(i));
            } else {
                passengers = this.passengers;
            }
        }
        return passengers;
    }

    public JButton newButton(String text, int x, int y) {
        button = new JButton(text);
        button.setBounds(x, y, 250, 70);
        button.setFont(myFont);
        button.setFocusable(false);
        return button;
    }


    public Font getMyFont() {
        return myFont;
    }

    public void setMyFont(Font myFont) {
        this.myFont = myFont;
    }

    public JLabel getSurvivedLabel() {
        return survivedLabel;
    }

    public void setSurvivedLabel(JLabel survivedLabel) {
        this.survivedLabel = survivedLabel;
    }

    public JComboBox getSurvivedComboBox() {
        return survivedComboBox;
    }

    public void setSurvivedComboBox(JComboBox survivedComboBox) {
        this.survivedComboBox = survivedComboBox;
    }

    public JLabel getPassengerIdRangeLabel() {
        return passengerIdRangeLabel;
    }

    public void setPassengerIdRangeLabel(JLabel passengerIdRangeLabel) {
        this.passengerIdRangeLabel = passengerIdRangeLabel;
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

    public JLabel getPassengerNameLabel() {
        return passengerNameLabel;
    }

    public void setPassengerNameLabel(JLabel passengerNameLabel) {
        this.passengerNameLabel = passengerNameLabel;
    }

    public JTextField getPassengerNameTextFiled() {
        return passengerNameTextFiled;
    }

    public void setPassengerNameTextFiled(JTextField passengerNameTextFiled) {
        this.passengerNameTextFiled = passengerNameTextFiled;
    }

    public JLabel getSexLabel() {
        return sexLabel;
    }

    public void setSexLabel(JLabel sexLabel) {
        this.sexLabel = sexLabel;
    }

    public JComboBox getSexComboBox() {
        return sexComboBox;
    }

    public void setSexComboBox(JComboBox sexComboBox) {
        this.sexComboBox = sexComboBox;
    }

    public JLabel getPassengerSibSpNumberLabel() {
        return passengerSibSpNumberLabel;
    }

    public void setPassengerSibSpNumberLabel(JLabel passengerSibSpNumberLabel) {
        this.passengerSibSpNumberLabel = passengerSibSpNumberLabel;
    }

    public JTextField getPassengerSibSpNumberTextFiled() {
        return passengerSibSpNumberTextFiled;
    }

    public void setPassengerSibSpNumberTextFiled(JTextField passengerSibSpNumberTextFiled) {
        this.passengerSibSpNumberTextFiled = passengerSibSpNumberTextFiled;
    }

    public JLabel getPassengerParchNumberLabel() {
        return passengerParchNumberLabel;
    }

    public void setPassengerParchNumberLabel(JLabel passengerParchNumberLabel) {
        this.passengerParchNumberLabel = passengerParchNumberLabel;
    }

    public JTextField getPassengerParchSpNumberTextFiled() {
        return passengerParchSpNumberTextFiled;
    }

    public void setPassengerParchSpNumberTextFiled(JTextField passengerParchSpNumberTextFiled) {
        this.passengerParchSpNumberTextFiled = passengerParchSpNumberTextFiled;
    }

    public JLabel getTicketNumberLabel() {
        return ticketNumberLabel;
    }

    public void setTicketNumberLabel(JLabel ticketNumberLabel) {
        this.ticketNumberLabel = ticketNumberLabel;
    }

    public JTextField getTicketNumberTextFiled() {
        return ticketNumberTextFiled;
    }

    public void setTicketNumberTextFiled(JTextField ticketNumberTextFiled) {
        this.ticketNumberTextFiled = ticketNumberTextFiled;
    }

    public JLabel getFareLabel() {
        return fareLabel;
    }

    public void setFareLabel(JLabel fareLabel) {
        this.fareLabel = fareLabel;
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

    public JLabel getCabinNumberLabel() {
        return cabinNumberLabel;
    }

    public void setCabinNumberLabel(JLabel cabinNumberLabel) {
        this.cabinNumberLabel = cabinNumberLabel;
    }

    public JTextField getCabinNumberTextFiled() {
        return cabinNumberTextFiled;
    }

    public void setCabinNumberTextFiled(JTextField cabinNumberTextFiled) {
        this.cabinNumberTextFiled = cabinNumberTextFiled;
    }

    public JLabel getEmbarkedLabel() {
        return embarkedLabel;
    }

    public void setEmbarkedLabel(JLabel embarkedLabel) {
        this.embarkedLabel = embarkedLabel;
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
}