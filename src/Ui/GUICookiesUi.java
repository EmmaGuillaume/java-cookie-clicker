package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICookiesInterface implements CookiesInterface {
    private JTextField inputField;
    private JButton submitButton;

    public static void main(String[] args) {


        JFrame frame = new JFrame("Cookie clicker");
        JTextField textField;

        Icon icon = new ImageIcon("/Users/emma/Code/test-java/src/assets/cookie.png");
        JButton button = new JButton(icon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(40, 80, 70, 69);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        textField = new JTextField(10);
//        textField.setBounds(10, 100, 200, 40);

        JLabel label = new JLabel();
        label.setBounds(10, 150, 300, 40);
        frame.add(label);
        int counterValue;

        // ActionListener pour le bouton
        button.addActionListener(new ActionListener() {
            int counterValue;

            public void actionPerformed(ActionEvent e) {

                counterValue = counterValue + 1;
                label.setText("Tes cookies : " + counterValue);

            }
        });


        // Set layout to null for manual positioning
        frame.setLayout(null);

//        frame.add(textField);
        frame.add(button);

        // Set frame size and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);

        System.out.println("Hello world!");

//        Scanner mScanner = new Scanner(System.in);
//        int first = mScanner.nextInt();
//        int second = mScanner.nextInt();
//        System.out.println(first + second);
//
//        mScanner.close();
    }
}
