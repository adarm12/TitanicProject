import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPassengers {

    private List<Passenger> passengers;
    private JButton searchButton;
    private JLabel messageForUser;
    private List<Passenger> survivedPassengers;

    public FilterPassengers(List<Passenger> passengers, JComboBox pClassComboBox, JTextField passengerIdRangeTextFieldMin,
                            JTextField passengerIdRangeTextFieldMax, JTextField passengerNameTextFiled, JComboBox sexComboBox,
                            JTextField passengerSibSpNumberTextFiled, JTextField passengerParchSpNumberTextFiled, JTextField ticketNumberTextFiled
            , JTextField fareTextField1, JTextField fareTextField2, JTextField cabinNumberTextFiled,
                            JComboBox embarkedCoboBox) {

        this.passengers = passengers;
        this.searchButton = CreateNew.newButton("search", Constants.SEARCH_BUTTON_X, Constants.SEARCH_BUTTON_Y);
        this.searchButton.addActionListener((e) -> {
            this.passengers = rangePassengerId(passengerIdRangeTextFieldMin.getText(),
                    passengerIdRangeTextFieldMax.getText(), this.passengers);

            if (pClassComboBox.getSelectedIndex() != 0) {
                this.passengers = byPclass(this.passengers, pClassComboBox.getSelectedIndex());
            }

            if (!passengerNameTextFiled.getText().equals(""))
                this.passengers = byName(this.passengers, passengerNameTextFiled.getText());

            if (sexComboBox.getSelectedIndex() != 0) {
                this.passengers = bySex(this.passengers, (String) sexComboBox.getSelectedItem());
            }

            if (!passengerSibSpNumberTextFiled.getText().equals(""))
                this.passengers = bySibSpNumber(this.passengers, Integer.parseInt(passengerSibSpNumberTextFiled.getText()));

            if (!passengerParchSpNumberTextFiled.getText().equals(""))
                this.passengers = byParchNumber(this.passengers, Integer.parseInt(passengerParchSpNumberTextFiled.getText()));

            if (!ticketNumberTextFiled.getText().equals(""))
                this.passengers = byTicket(this.passengers, ticketNumberTextFiled.getText());
//
//            if (!fareTextField1.equals("") && !fareTextField2.equals(""))
//            this.passengers = rangeTicketPrice(fareTextField1.getText(),
//                    fareTextField2.getText(), this.passengers);

            if (!cabinNumberTextFiled.getText().equals(""))
                this.passengers = byCabinNumber(this.passengers, cabinNumberTextFiled.getText());

            if (embarkedCoboBox.getSelectedIndex() != 0) {
                this.passengers = byEmbarked(this.passengers, (String) embarkedCoboBox.getSelectedItem());
            }
            this.messageForUser = CreateNew.newLabel("", 100, 700, Constants.LABEL_WIDTH, 80);
            this.survivedPassengers = this.passengers.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            this.messageForUser.setText("passengers: " + this.passengers.size() + " (survived: " + this.survivedPassengers.size()+ ")");
            System.out.println(this.messageForUser.getText());
        });
    }

    private List<Passenger> rangePassengerId(String startFrom, String limitTo, List<Passenger> passengers) {
        if (startFrom.equals(""))
            startFrom = Constants.PASSENGER_RANGE_ID_MIN;
        if (limitTo.equals(""))
            limitTo = Constants.PASSENGER_RANGE_ID_MAX;
        if (isValidRange(startFrom, limitTo)) {
            return this.passengers.stream().limit(Integer.parseInt(limitTo)).skip(Integer.parseInt(startFrom) - 1).collect(Collectors.toList());
        }
        return passengers;
    }

    private boolean isValidRange(String min, String max) {
        boolean isValid = false;
        if (isOnlyNumbers(min) && isOnlyNumbers(max)) {
            int minNumber = Integer.parseInt(min);
            int maxNumber = Integer.parseInt(max);
            if (minNumber > 0 && maxNumber > 0 && maxNumber > minNumber)
                isValid = true;
        }
        return isValid;
    }

    private boolean isOnlyNumbers(String number) {
        boolean only = false;
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i)))
                counter++;
        }
        if (counter == number.length())
            only = true;
        return only;
    }

    private List<Passenger> byName(List<Passenger> list, String name) {
        List<Passenger> passengers = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains((name)))
                passengers.add(list.get(i));
        }
        return passengers;
    }

    private List<Passenger> byPclass(List<Passenger> list, int pClass) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getpClass(), pClass)).collect(Collectors.toList());
    }

    private List<Passenger> bySex(List<Passenger> list, String sex) {
        return list.stream().filter(passengers -> selectedString(passengers.getSex(), sex)).collect(Collectors.toList());
    }

    private List<Passenger> bySibSpNumber(List<Passenger> list, int sibSp) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getSibSp(), sibSp)).collect(Collectors.toList());
    }

    private List<Passenger> byParchNumber(List<Passenger> list, int parch) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getParch(), parch)).collect(Collectors.toList());
    }

    private List<Passenger> byTicket(List<Passenger> list, String ticket) {
        return list.stream().filter(passengers -> selectedString(passengers.getTicket(), ticket)).collect(Collectors.toList());
    }

//    private List<Passenger> rangeTicketPrice(String startFrom, String limitTo, List<Passenger> passengers) {
//        if (isValidRange(startFrom, limitTo)) {
//            return passengers.stream().filter( -> selectedString(passengers.getCabin(), cabin)).collect(Collectors.toList());
//        }
//        return passengers;
//    }

    private List<Passenger> byCabinNumber(List<Passenger> list, String cabin) {
        return list.stream().filter(passengers -> selectedString(passengers.getCabin(), cabin)).collect(Collectors.toList());
    }

    private List<Passenger> byEmbarked(List<Passenger> list, String embarked) {
        return list.stream().filter(passengers -> selectedChar(passengers.getEmbarked(), embarked)).collect(Collectors.toList());
    }


    private boolean isValidValue(int valueToCheck) {
        boolean isValid = false;
        if (valueToCheck > 0) {
            isValid = true;
        }
        return isValid;
    }

    private boolean selectedNumber(int origin, int valueToCheck) {
        boolean isSame = false;

        if (isValidValue(valueToCheck)) {
            if (origin == valueToCheck) {
                isSame = true;
            }
        }
        return isSame;
    }

    private boolean selectedString(String origin, String stringToCheck) {
        boolean isSame = false;
        if (origin.equals(stringToCheck)) {
            isSame = true;
        }
        return isSame;
    }

    private boolean selectedChar(char origin, String charToCheck) {
        boolean isSame = false;
        if (origin == charToCheck.charAt(0)) {
            isSame = true;
        }
        return isSame;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JLabel getMessageForUser() {
        return messageForUser;
    }

    public void setMessageForUser(JLabel messageForUser) {
        this.messageForUser = messageForUser;
    }

    public List<Passenger> getSurvivedPassengers() {
        return survivedPassengers;
    }

    public void setSurvivedPassengers(List<Passenger> survivedPassengers) {
        this.survivedPassengers = survivedPassengers;
    }
}
