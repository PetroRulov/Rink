package com.app.view;

import com.app.threads.SkatersNumberThread;
import com.app.view.panels.MainPanel;
import com.app.view.panels.VacantPanel;
import com.app.view.tables.SkatersTable;
import com.app.model.Administrator;
import com.app.threads.TablePanelThread;
import com.app.threads.UIThread;
import com.app.threads.VacantRunningThread;
import com.app.view.panels.RoundedPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 26.11.2016.
 */
public class SkatingUI {
    private Administrator admin;
    private JFrame frame;
    private final String head = "* SKATING - \"WINTERHALL\" - SKATING *";

    //Jcomponents
    private MainPanel mp;
    private VacantPanel vp;

    private JPanel tablePanel;
    private JTable table;

    //threads
    private UIThread uit;
    private SkatersNumberThread snt;
    private VacantRunningThread vrt;
    private TablePanelThread tpt;

    public SkatingUI(Administrator admin) {

        this.admin = admin;
        mp = new MainPanel(admin);
        vp = new VacantPanel(admin);

        frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(head);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(680, 350));
        //frame.setMinimumSize(new Dimension(1360, 725));
        frame.setLocation(0, 0);
        frame.setLayout(null);

        mp.getRinkPanel().setBounds(0, 0, 300, 150);
        vp.getRinkPanel().setBounds(0, 150, 300, 150);

        frame.getContentPane().add(mp.getRinkPanel(), 0);
        frame.getContentPane().add(vp.getRinkPanel(), 1);

        uit = new UIThread(this);
        snt = new SkatersNumberThread(admin, this);
        vrt = new VacantRunningThread(admin, this);
        tpt= new TablePanelThread(this);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setSkatersQuant(String str) {
        mp.setTFSkatersQuant(str);
    }

    public void setVacantPlaces(String str) {
        vp.setTFVacantPlaces(str);
    }

    public void setTablePanel() {
        tablePanel = new RoundedPanel();
        table = new SkatersTable(admin).createTable();
        tablePanel.setLayout(null);
        tablePanel.setBackground(new Color(0, 150, 200));
        JScrollPane tableContainer = new JScrollPane(table);
        tableContainer.setBounds(30, 25, 300, 250);
        tablePanel.add(tableContainer, BorderLayout.CENTER);
        tablePanel.setBounds(300, 0, 360, 300);
        frame.getContentPane().add(tablePanel, 2);
        tablePanel.repaint();
    }

    public UIThread getUit() {
        return uit;
    }

    public SkatersNumberThread getSnt() {
        return snt;
    }

    public VacantRunningThread getVrt() {
        return vrt;
    }

    public TablePanelThread getTpt() {
        return tpt;
    }
}
