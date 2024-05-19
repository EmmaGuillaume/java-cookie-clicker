package Ui;

import Core.CookiesGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICookiesUi implements CookiesUi {

    private JTextField inputField;
    private JButton submitButton;

    private final CookiesGame game;

    public GUICookiesUi(CookiesGame receivedGame) {
        game = receivedGame;
        showCookiesDashboard();
    }

    public void showCookiesDashboard() {

        JFrame frame = new JFrame("Cookie clicker");
        JTextField textField;

        Icon icon = new ImageIcon("/Users/emma/Code/test-java/src/assets/cookie.png");
        JButton button = new JButton(icon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(40, 80, 70, 69);
        button.setFocusPainted(false);


        Icon grannyIcon = new ImageIcon("/Users/emma/Code/test-java/src/assets/granny.png");
        JButton grannyButton = new JButton(grannyIcon);
        grannyButton.setOpaque(false);
        grannyButton.setContentAreaFilled(false);
        grannyButton.setBorderPainted(false);
        grannyButton.setBounds(40, 300, 57, 57);
        grannyButton.setFocusPainted(false);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setBounds(10, 150, 300, 40);
        frame.add(label);

        JLabel grannyLabel = new JLabel();
        grannyLabel.setBounds(50, 350, 300, 40);
        frame.add(grannyLabel);

        // ActionListener pour le bouton
        button.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                game.click();
                label.setText("Your cookies : " + game.getCookies());


            }
        });

        grannyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                game.hireGranny();
                grannyLabel.setText("" + game.getGrannies());


            }
        });


        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Your cookies : " + game.getCookies());
            }
        });
        timer.start();

        // Set layout to null for manual positioning
        frame.setLayout(null);

        frame.add(button);
        frame.add(grannyButton);

        // frame size
        frame.setSize(500, 450);
        frame.setVisible(true);

    }
}
