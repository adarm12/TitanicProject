import javax.swing.*;
import java.awt.*;

public class Filter {

    Font myFont = new Font("Gisha", Font.BOLD, 16);
    Font textFiledFont = new Font("Gisha", Font.BOLD, 16);

    private JComboBox survivedComboBox;
    private JLabel survivedLabel;
    private JTextField passengerIdRangeTextField1;
    private JTextField passengerIdRangeTextField2;
    private JLabel passengerIdRangeLabel;

    public Filter(int x, int y) {
        this.survivedLabel = newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.passengerIdRangeTextField1 = newTextField(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.passengerIdRangeTextField2 = newTextField(survivedLabel.getX() + survivedLabel.getWidth() + 75, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox = new JComboBox(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox.addActionListener((e) -> {
            //do whatever you want on change
        });

    }


    public JTextField newTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(textFiledFont);
        return textField;
    }

    public JLabel newLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(myFont);
        return label;
    }

    public JComboBox getSurvivedComboBox() {
        return survivedComboBox;
    }

    public void setSurvivedComboBox(JComboBox survivedComboBox) {
        this.survivedComboBox = survivedComboBox;
    }

    public JLabel getSurvivedLabel() {
        return survivedLabel;
    }

    public void setSurvivedLabel(JLabel survivedLabel) {
        this.survivedLabel = survivedLabel;
    }

    public JTextField getPassengerIdRangeTextField1() {
        return passengerIdRangeTextField1;
    }

    public void setPassengerIdRangeTextField1(JTextField passengerIdRangeTextField1) {
        this.passengerIdRangeTextField1 = passengerIdRangeTextField1;
    }

    public JTextField getPassengerIdRangeTextField2() {
        return passengerIdRangeTextField2;
    }

    public void setPassengerIdRangeTextField2(JTextField passengerIdRangeTextField2) {
        this.passengerIdRangeTextField2 = passengerIdRangeTextField2;
    }

    public JLabel getPassengerIdRangeLabel() {
        return passengerIdRangeLabel;
    }

    public void setPassengerIdRangeLabel(JLabel passengerIdRangeLabel) {
        this.passengerIdRangeLabel = passengerIdRangeLabel;
    }
}


