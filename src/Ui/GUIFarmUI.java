package Ui;

import Core.CookiesGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFarmUI {

    private JButton farmButton;
    private JLabel farmLabel;

    public GUIFarmUI(CookiesGame game) {
        String farmIconPath = "/assets/farm.png";
        ImageIcon farmIcon = new ImageIcon(getClass().getResource(farmIconPath));

        if (farmIcon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
            System.err.println("Error: farm icon not found at " + farmIconPath);
            return;
        }


        farmButton = new JButton(farmIcon);
        farmButton.setOpaque(false);
        farmButton.setContentAreaFilled(false);
        farmButton.setBorderPainted(false);
        farmButton.setBounds(120, 300, 57, 57);
        farmButton.setFocusPainted(false);

        farmLabel = new JLabel("" + game.getGrannies());
        farmLabel.setBounds(140, 350, 300, 40);

        // ActionListener pour le bouton farm
        farmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.buildFarm();
                farmLabel.setText("" + game.getFarms());
            }
        });
    }

    public JButton getFarmButton() {
        return farmButton;
    }

    public JLabel getFarmLabel() {
        return farmLabel;
    }
}
