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
public class VacantPanel {

    private Administrator administrator;
    private JPanel rinkPanel;

    private JTextField tfVacantPlaces;

    public VacantPanel(Administrator administrator){
        this.administrator = administrator;
        this.rinkPanel = createRinkPanel();
    }

    private JPanel createRinkPanel() {

        rinkPanel = new RoundedPanel();
        rinkPanel.setLayout(new GridBagLayout());
        rinkPanel.setBackground(new Color(70, 170, 180));
        rinkPanel.setFont(new Font("Garamond", Font.BOLD, 20));

        Border matte = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border titled = BorderFactory.createTitledBorder(empty, "NUMBER OF VACANT PLACES", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 15), new Color(50, 150, 0));
        rinkPanel.setBorder(titled);

        URL imageURL = getClass().getClassLoader().getResource("rinkout.png");
        ImageIcon icon = new ImageIcon(imageURL);
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        rinkPanel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

//        JLabel skatersQuantity = new JLabel("NUMBER OF SKATERS AT THE MOMENT: ");

//        JLabel skatersQuantity = new JLabel("VACANT PLACES AT THE MOMENT: ");
//        skatersQuantity.setFont(new Font("Garamond", Font.BOLD, 20));
//        skatersQuantity.setForeground(Color.GREEN);
//        rinkPanel.add(skatersQuantity, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfVacantPlaces = new JTextField();
        tfVacantPlaces.setFont(new Font("Garamond", Font.BOLD, 36));
        tfVacantPlaces.setBackground(new Color(20, 150, 100));
        tfVacantPlaces.setForeground(new Color(0, 255, 0));
        tfVacantPlaces.setColumns(2);
        tfVacantPlaces.setBorder(new SubtleSquareBorder(true));
        tfVacantPlaces.setHorizontalAlignment(JTextField.CENTER);
        tfVacantPlaces.setText(String.valueOf(administrator.howManySkaters()));
        tfVacantPlaces.setEditable(false);
        rinkPanel.add(tfVacantPlaces, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        return rinkPanel;
    }

    public JPanel getRinkPanel() {
        return rinkPanel;
    }

    private JTextField getTfVacantPlaces() {
        return tfVacantPlaces;
    }

    public void setTFVacantPlaces(String str) {
        getTfVacantPlaces().setText(str);
    }

}

