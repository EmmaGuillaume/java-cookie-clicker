package Ui;

import Core.CookiesGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGrannyUI {

    private JButton grannyButton;
    private JLabel grannyLabel;

    public GUIGrannyUI(CookiesGame game) {
        String grannyIconPath = "/Users/emma/Code/test-java/src/assets/granny.png";
        ImageIcon grannyIcon = new ImageIcon(grannyIconPath);

        if (grannyIcon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
            System.err.println("Error: Granny icon not found at " + grannyIconPath);
            return;
        }

        grannyButton = new JButton(grannyIcon);
        grannyButton.setOpaque(false);
        grannyButton.setContentAreaFilled(false);
        grannyButton.setBorderPainted(false);
        grannyButton.setBounds(40, 300, 57, 57);
        grannyButton.setFocusPainted(false);

        grannyLabel = new JLabel("" + game.getGrannies());
        grannyLabel.setBounds(50, 350, 300, 40);

        // ActionListener pour le bouton granny
        grannyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.hireGranny();
                grannyLabel.setText("" + game.getGrannies());
            }
        });
    }

    public JButton getGrannyButton() {
        return grannyButton;
    }

    public JLabel getGrannyLabel() {
        return grannyLabel;
    }
}
