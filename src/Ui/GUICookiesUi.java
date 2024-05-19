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

        String cookieIconPath = "/Users/emma/Code/test-java/src/assets/cookie.png";
        ImageIcon icon = new ImageIcon(cookieIconPath);

        if (icon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
            System.err.println("Error: Cookie icon not found at " + cookieIconPath);
            return;
        }

        JButton button = new JButton(icon);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(40, 80, 70, 69);
        button.setFocusPainted(false);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setBounds(10, 150, 300, 40);
        frame.add(label);

        // Initialiser le composant Granny
        GUIGrannyUI grannyComponent = new GUIGrannyUI(game);

        if (grannyComponent.getGrannyButton() == null || grannyComponent.getGrannyLabel() == null) {
            System.err.println("Error: Granny component not initialized correctly.");
            return;
        }

        frame.add(grannyComponent.getGrannyButton());
        frame.add(grannyComponent.getGrannyLabel());

        // ActionListener pour le bouton cookie
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.click();
                label.setText("Your cookies : " + game.getCookies());
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

        // frame size
        frame.setSize(500, 450);
        frame.setVisible(true);
    }
}
