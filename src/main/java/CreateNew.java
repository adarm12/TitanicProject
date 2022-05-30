import javax.swing.*;
import java.awt.*;

public class CreateNew {

    public static JLabel newLabel(String text, int x, int y, int width, int height) {
        Font myFont = new Font("Gisha", Font.BOLD, 18);
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(myFont);
        return label;
    }

    public static JTextField newTextField(int x, int y, int width, int height) {
        Font myFont = new Font("Gisha", Font.BOLD, 18);
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(myFont);
        return textField;
    }


    public static JButton newButton(String text, int x, int y) {
        Font myFont = new Font("Gisha", Font.BOLD, 18);
        JButton button = new JButton(text);
        button.setBounds(x, y, 250, 70);
        button.setFont(myFont);
        button.setFocusable(false);
        return button;
    }

}