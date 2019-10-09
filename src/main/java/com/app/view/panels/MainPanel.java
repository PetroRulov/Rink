package com.app.view.panels;

import com.app.model.Administrator;
import com.app.view.borders.SubtleSquareBorder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.URL;

/**
 * Created by prulov on 26.11.2016.
 */
public class MainPanel {

    private Administrator administrator;
    private JPanel rinkPanel;

    private JTextField tfSkatersQuant;

    public MainPanel(Administrator administrator){
        this.administrator = administrator;
        this.rinkPanel = createRinkPanel();
    }

    private JPanel createRinkPanel() {

        rinkPanel = new RoundedPanel();
        rinkPanel.setLayout(new GridBagLayout());
        rinkPanel.setBackground(new Color(200, 150, 100));
        rinkPanel.setFont(new Font("Garamond", Font.BOLD, 20));

        Border matte = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.ORANGE);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border titled = BorderFactory.createTitledBorder(empty, "NUMBER OF SKATERS", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 18), Color.RED);
        rinkPanel.setBorder(titled);

        URL imageURL = getClass().getClassLoader().getResource("rinkin.png");
        ImageIcon icon = new ImageIcon(imageURL);
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        rinkPanel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

//        JLabel skatersQuantity = new JLabel("NUMBER OF SKATERS AT THE MOMENT: ");
//        skatersQuantity.setFont(new Font("Garamond", Font.BOLD, 20));
//        skatersQuantity.setForeground(Color.RED);
//        rinkPanel.add(skatersQuantity, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSkatersQuant = new JTextField();
        tfSkatersQuant.setFont(new Font("Garamond", Font.BOLD, 36));
        tfSkatersQuant.setBackground(new Color(170, 150, 150));
        tfSkatersQuant.setForeground(new Color(255, 0, 0));
        tfSkatersQuant.setColumns(2);
        tfSkatersQuant.setBorder(new SubtleSquareBorder(true));
        tfSkatersQuant.setHorizontalAlignment(JTextField.CENTER);
        tfSkatersQuant.setText(String.valueOf(administrator.howManySkaters()));
        tfSkatersQuant.setEditable(false);
        rinkPanel.add(tfSkatersQuant, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        return rinkPanel;
    }

    public JPanel getRinkPanel() {
        return rinkPanel;
    }

    private JTextField getTfSkatersQuant() {
        return tfSkatersQuant;
    }

    public void setTFSkatersQuant(String str) {
        getTfSkatersQuant().setText(str);
    }

}
