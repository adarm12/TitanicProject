import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPassengers {

    private List<Passenger> passengers;
    private JButton searchButton;

    public FilterPassengers(List<Passenger> passengers, JComboBox survivedComboBox, JTextField passengerIdRangeTextFieldMin,
                            JTextField passengerIdRangeTextFieldMax, JTextField passengerNameTextFiled, JComboBox sexComboBox,
                            JTextField passengerSibSpNumberTextFiled, JTextField passengerParchSpNumberTextFiled, JTextField ticketNumberTextFiled
            , JTextField fareTextField1, JTextField fareTextField2, JTextField cabinNumberTextFiled,
                            JComboBox embarkedCoboBox, JTextField ageTextFiled) {

        this.passengers = passengers;

        this.searchButton = CreateNew.newButton("search", Constants.SEARCH_BUTTON_X, Constants.SEARCH_BUTTON_Y);
        this.searchButton.addActionListener((e) -> {
            List<Passenger> p = rangePassengerId(passengerIdRangeTextFieldMin.getText(),
                    passengerIdRangeTextFieldMax.getText(), this.passengers);
            System.out.println("p1: " + p.size());

            //byName(passengers, passengerNameTextFiled.getText());
//                    this.passengers;
//                    rangePassengerId(filter.getPassengerIdRangeTextFieldMin().getText(),
//                    filter.getPassengerIdRangeTextFieldMax().getText(), this.passengers);
//            System.out.println(p.size());

            if (!passengerNameTextFiled.getText().equals(""))
                p = byName(p, passengerNameTextFiled.getText());
            System.out.println("p2: " + p.size());

//            if (!ticketNumberTextFiled.equals(""))
//                p = byTicket(p, ticketNumberTextFiled.getText());
//            System.out.println("p3: " + p.size());
//
//            if (!passengerSibSpNumberTextFiled.getText().equals(""))
//                p = bySibSpNumber(p, Integer.parseInt(passengerSibSpNumberTextFiled.getText()));
//
//            System.out.println("p4: " + p.size());

            if (!passengerParchSpNumberTextFiled.getText().equals(""))
                p = byParchNumber(p, Integer.parseInt(passengerParchSpNumberTextFiled.getText()));

            if (!cabinNumberTextFiled.getText().equals(""))
                p = byCabinNumber(p, cabinNumberTextFiled.getText());

            if (!ageTextFiled.getText().equals(""))
                p = byAge(p, Integer.parseInt(ageTextFiled.getText()));


            System.out.println(p.size());
        });
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
        return list.stream().filter(passengers -> selectedString(passengers.getSex(), sex)).collect(Collectors.toList());
    }

    private List<Passenger> byTicket(List<Passenger> list, String ticket) {
        return list.stream().filter(passengers -> selectedString(passengers.getTicket(), ticket)).collect(Collectors.toList());
    }

    private List<Passenger> bySibSpNumber(List<Passenger> list, int sibSp) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getSibSp(), sibSp)).collect(Collectors.toList());
    }


    private List<Passenger> byParchNumber(List<Passenger> list, int parch) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getParch(), parch)).collect(Collectors.toList());
    }


    private List<Passenger> byCabinNumber(List<Passenger> list, String cabin) {
        return list.stream().filter(passengers -> selectedString(passengers.getCabin(), cabin)).collect(Collectors.toList());
    }

    private List<Passenger> byAge(List<Passenger> list, int age) {
        return list.stream().filter(passengers -> selectedNumber(passengers.getAge(), age)).collect(Collectors.toList());
    }


    public boolean isValidValue(double valueToCheck) {
        boolean isValid = false;
        if (valueToCheck > 0) {
            isValid = true;
        }
        return isValid;
    }

    public boolean selectedNumber(double origin, double valueToCheck) {
        boolean isSame = false;
        if (isValidValue(valueToCheck)) {
            if (origin == valueToCheck) {
                isSame = true;
            }
        }
        return isSame;
    }

    public boolean selectedString(String origin, String stringToCheck) {
        boolean isSame = false;
        if (origin.equals(stringToCheck)) {
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

}
