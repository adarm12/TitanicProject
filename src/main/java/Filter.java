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

        this.button = newButton("search", 150, 750);
        this.passengers = passengers;

        this.passengerIdRangeLabel = newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 60, Constants.LABEL_HEIGHT);
        this.passengerIdRangeTextFieldMin = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.passengerIdRangeTextFieldMax = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 75, passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.survivedLabel = newLabel("Survived status:  ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.survivedComboBox = new JComboBox(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox.addActionListener((e) -> {
            System.out.println("hi");
        });
        this.button.addActionListener((e) -> {
            if (this.passengerIdRangeTextFieldMin.getText() != "" && this.passengerIdRangeTextFieldMax.getText() != "") {
                this.passengers = rangePassengerId(this.passengerIdRangeTextFieldMin.getText(),
                        this.passengerIdRangeTextFieldMax.getText()
                        , this.passengers);
            }
            if (this.passengerNameTextFiled.getText() != "")
                this.passengers = byName(this.passengers, this.passengerNameTextFiled.getText());
            System.out.println(this.passengers);
        });

        this.passengerNameLabel = newLabel("Passenger name: : ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 8 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.passengerNameTextFiled = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 8 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);

        this.sexLabel = newLabel("Sex:  ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 12 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.sexComboBox = new JComboBox(Constants.PASSENGER_CLASS_OPTIONS);
        this.sexComboBox.setBounds(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 12 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.sexComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

        this.passengerSibSpNumberLabel = newLabel("Sibsp number : ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.passengerSibSpNumberTextFiled = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.passengerParchNumberLabel = newLabel("Parch number : ", x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.passengerParchSpNumberTextFiled = newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.ticketNumberLabel = newLabel("Ticket number : ", x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.ticketNumberTextFiled = newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.fareLabel = newLabel("Ticket price : ", x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.MARGIN_FROM_TOP + 8 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.fareTextField1 = newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 8 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.fareTextField2 = newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 75, passengerParchNumberLabel.getY() + 8 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.cabinNumberLabel = newLabel("Cabin number : ", x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.MARGIN_FROM_TOP + 12 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.cabinNumberTextFiled = newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 12 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.embarkedLabel = newLabel("Embarked:  ", x + Constants.MARGIN_FROM_LEFT + 400, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.embarkedCoboBox = new JComboBox(Constants.PASSENGER_CLASS_OPTIONS);
        this.embarkedCoboBox.setBounds(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.embarkedCoboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

    }

    public List<Passenger> rangePassengerId(String startFrom, String limitTo, List<Passenger> passengers) {
        if (startFrom.equals("")) {
            startFrom = "1";
        }
        if (limitTo.equals("")) {
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
//        return passengers;
    }
//            int start = 0;
//            int limit = passengers.size();
//            if (startFrom != "")
//                start = Integer.parseInt(startFrom);
//            if (limitTo != "")
//                limit = Integer.parseInt(limitTo);
//
//            while (start + limit != 0) {
//                if (start == 0)
//                    start++;
//                if (limit >= start)
//                    return this.passengers.stream().limit(limit).skip(start - 1).collect(Collectors.toList());
//                else if (limit == 0) {
//                    return passengers.stream().skip(start).collect(Collectors.toList());
//                }
//            }


    private List<Passenger> byName(List<Passenger> passengers, String name) {
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getName().contains((name)))
                this.passengers.add(this.passengers.get(i));
        }
        return passengers;
        // return this.passengers.stream().filter().collect(Collectors.toList());
    }


    public JTextField newTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(myFont);
        return textField;
    }

    public JLabel newLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(myFont);
        return label;
    }

    public JButton newButton(String text, int x, int y) {
        button = new JButton(text);
        button.setBounds(x, y, 250, 70);
        button.setFont(myFont);
        button.setFocusable(false);
        return button;
    }


    public JComboBox getSurvivedComboBox() {
        return survivedComboBox;
    }

    public void setSurvivedComboBox(JComboBox survivedComboBox) {
        this.survivedComboBox = survivedComboBox;
    }


    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }


    public JLabel getSurvivedLabel() {
        return survivedLabel;
    }

    public void setSurvivedLabel(JLabel survivedLabel) {
        this.survivedLabel = survivedLabel;
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

    public JLabel getPassengerIdRangeLabel() {
        return passengerIdRangeLabel;
    }

    public void setPassengerIdRangeLabel(JLabel passengerIdRangeLabel) {
        this.passengerIdRangeLabel = passengerIdRangeLabel;
    }

    public JTextField getPassengerNameTextFiled() {
        return passengerNameTextFiled;
    }

    public void setPassengerNameTextFiled(JTextField passengerNameTextFiled) {
        this.passengerNameTextFiled = passengerNameTextFiled;
    }

    public JLabel getPassengerNameLabel() {
        return passengerNameLabel;
    }

    public void setPassengerNameLabel(JLabel passengerNameLabel) {
        this.passengerNameLabel = passengerNameLabel;
    }

    public JComboBox getSexComboBox() {
        return sexComboBox;
    }

    public void setSexComboBox(JComboBox sexComboBox) {
        this.sexComboBox = sexComboBox;
    }

    public JLabel getSexLabel() {
        return sexLabel;
    }

    public void setSexLabel(JLabel sexLabel) {
        this.sexLabel = sexLabel;
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

    public JLabel getFareLabelLabel() {
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
}


