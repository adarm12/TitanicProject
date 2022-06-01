import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

//    private JLabel survivedLabel;
//    private JComboBox survivedComboBox;
//    private JLabel passengerIdRangeLabel;
//    private JTextField passengerIdRangeTextFieldMin;
//    private JTextField passengerIdRangeTextFieldMax;
//    private JLabel passengerNameLabel;
//    private JTextField passengerNameTextFiled;
//    private JLabel sexLabel;
//    private JComboBox sexComboBox;
//    private JLabel passengerSibSpNumberLabel;
//    private JTextField passengerSibSpNumberTextFiled;
//    private JLabel passengerParchNumberLabel;
//    private JTextField passengerParchSpNumberTextFiled;
//    private JLabel ticketNumberLabel;
//    private JTextField ticketNumberTextFiled;
//    private JLabel fareLabel;
//    private JTextField fareTextField1;
//    private JTextField fareTextField2;
//    private JLabel cabinNumberLabel;
//    private JTextField cabinNumberTextFiled;
//    private JLabel embarkedLabel;
//    private JComboBox embarkedCoboBox;
//    private JButton button;
//    private JLabel ageLabel;
//    private JTextField ageTextFiled;

    private List<Passenger> passengers;

    public Filter(int x, int y, List<Passenger> passengers, JPanel mainPanel) {

//        this.passengerIdRangeLabel = CreateNew.newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT,
//                y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 60, Constants.LABEL_HEIGHT);
//        this.passengerIdRangeTextFieldMin = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
//                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//        this.passengerIdRangeTextFieldMax = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 75,
//                passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//
//        this.survivedLabel = CreateNew.newLabel("Survived status:  ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
//        this.survivedComboBox = CreateNew.newComboBox(Constants.PASSENGER_CLASS_OPTIONS,
//                passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
//                passengerIdRangeLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
//        this.survivedComboBox.addActionListener((e) -> {
//            System.out.println("hi");
//        });
//
//        this.passengerNameLabel = CreateNew.newLabel("Passenger name: ", x + Constants.MARGIN_FROM_LEFT,
//                y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
//                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.passengerNameTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1,
//                passengerIdRangeLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP,
//                Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
//
//        this.sexLabel = CreateNew.newLabel("Sex:  ", x + Constants.MARGIN_FROM_LEFT,
//                y + Constants.MARGIN_FROM_TOP + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP,
//                Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.sexComboBox = new JComboBox(Constants.PASSENGER_SEX_OPTIONS);
//        this.sexComboBox.setBounds(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + Constants.TWELVE_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
////        this.sexComboBox.addActionListener((e) -> {
////            if (e.getSource() == this.sexComboBox) {
////                if (this.sexComboBox.getSelectedIndex() != 0) {
////                    System.out.println(this.sexComboBox.getSelectedItem());
////
////                }
////            }
////        });
//
//
//        this.passengerSibSpNumberLabel = CreateNew.newLabel("Sibsp number: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.passengerSibSpNumberTextFiled = CreateNew.newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//
//        this.passengerParchNumberLabel = CreateNew.newLabel("Parch number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.passengerParchSpNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//
//        this.ticketNumberLabel = CreateNew.newLabel("Ticket number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.ticketNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
//
//        this.fareLabel = CreateNew.newLabel("Ticket price: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.fareTextField1 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//        this.fareTextField2 = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 75, passengerParchNumberLabel.getY() + Constants.EIGHT_TIMES * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//
//        this.cabinNumberLabel = CreateNew.newLabel("Cabin number: ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 12 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.cabinNumberTextFiled = CreateNew.newTextField(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 12 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
//
//        this.embarkedLabel = CreateNew.newLabel("Embarked:  ", x + Constants.MARGIN_FROM_LEFT + Constants.ANOTHER_MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 16 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.embarkedCoboBox = new JComboBox(Constants.PASSENGER_EMBARKED_OPTIONS);
//        this.embarkedCoboBox.setBounds(passengerParchNumberLabel.getX() + passengerParchNumberLabel.getWidth() + 1, passengerParchNumberLabel.getY() + 16 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
//        this.embarkedCoboBox.addActionListener((e) -> {
//            //do whatever you want on change
//        });
//
//        this.ageLabel = CreateNew.newLabel("Age: ", x + Constants.ANOTHER_MARGIN_FROM_LEFT * 2, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
//        this.ageTextFiled = CreateNew.newTextField(ageLabel.getX() + Constants.MARGIN_FROM_LEFT * 3, passengerParchNumberLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

    }


}