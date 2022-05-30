import javax.swing.*;
import java.awt.*;

public class createNew {


    public  static JTextField newTextField(int x, int y, int width, int height) {
        Font myFont = new Font("Gisha", Font.BOLD, 18);
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(myFont);
        return textField;
    }
}