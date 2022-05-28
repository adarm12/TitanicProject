import javax.swing.*;
import java.awt.*;

public class Filter {

    Font myFont = new Font("Gisha", Font.BOLD, 18);
    Font textFiledFont = new Font("Gisha", Font.BOLD, 18);

    private JLabel survivedLabel;
    private JComboBox survivedComboBox;
    private JLabel passengerIdRangeLabel;
    private JTextField passengerIdRangeTextField1;
    private JTextField passengerIdRangeTextField2;
    private JLabel passengerNameLabel;
    private JTextField passengerNameTextFiled;
    private JLabel sexLabel;
    private JComboBox sexComboBox;
    private JLabel passengerSibSpNumberLabel;
    private JTextField passengerSibSpNumberTextFiled;

    public Filter(int x, int y) {
        this.passengerIdRangeLabel = newLabel("Passenger ID rang: ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 60, Constants.LABEL_HEIGHT);
        this.passengerIdRangeTextField1 = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);
        this.passengerIdRangeTextField2 = newTextField(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 75, passengerIdRangeLabel.getY(), Constants.COMBO_BOX_WIDTH / 2, Constants.COMBO_BOX_HEIGHT);

        this.survivedLabel = newLabel("Survived status:  ", x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP + 4 * Constants.MARGIN_FROM_TOP, Constants.LABEL_WIDTH + 20, Constants.LABEL_HEIGHT);
        this.survivedComboBox = new JComboBox(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(passengerIdRangeLabel.getX() + passengerIdRangeLabel.getWidth() + 1, passengerIdRangeLabel.getY() + 4 * Constants.MARGIN_FROM_TOP, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.survivedComboBox.addActionListener((e) -> {
            //do whatever you want on change
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
}


