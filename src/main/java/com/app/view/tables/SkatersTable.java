package com.app.view.tables;

import com.app.model.Administrator;
import com.app.model.Skater;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by prulov on 26.11.2016.
 */
public class SkatersTable extends DefaultTableModel {

    private Administrator admin;
    private JTable table;
    private final int columns;

    public SkatersTable(Administrator admin){
        this.admin = admin;
        columns = 2;
        table = createTable();
        table.setFillsViewportHeight(true);
    }

    public JTable createTable() {
        Object[] colNames = fillColumns();
        Object[][] data = fillData();
        JTable tSkaters = new JTable(data, colNames);
        tSkaters.setAutoCreateRowSorter(true);

        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = tSkaters.getColumnModel().getColumn(i);
            if(i == 0) {
                column.setCellRenderer(new DefaultTableCellRenderer() {
                    public JComponent getTableCellRendererComponent(JTable table, Object value,
                                                                    boolean isSelected, boolean hasFocus, int row, int col) {
                        JLabel label =
                                (JLabel) super.getTableCellRendererComponent(table, value,
                                        isSelected, hasFocus, row, col);
                        label.setSize(10, 10);
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setBackground(new Color(200, 150, 100));
                        label.setForeground(new Color(0, 0, 0));
                        label.setFont(new Font("Garamond", Font.BOLD, 20));
                        return label;
                    }
                });
                column.setMaxWidth(30);
            } else {
                column.setCellRenderer(new DefaultTableCellRenderer() {
                    public JComponent getTableCellRendererComponent(JTable table, Object value,
                                                                    boolean isSelected, boolean hasFocus, int row, int col) {
                        JLabel label =
                                (JLabel) super.getTableCellRendererComponent(table, value,
                                        isSelected, hasFocus, row, col);
                        //label.setPreferredSize(new Dimension(150,10));
                        label.setSize(150,10);
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setBackground(new Color(170, 150, 150));
                        label.setForeground(new Color(255, 0, 0));
                        label.setFont(new Font("Garamond", Font.BOLD, 20));
                        return label;
                    }
                });
            }
        }
        return tSkaters;
    }

    private Object[] fillColumns(){
        String[] heads = new String[]{"#", "ID number"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

    private Object[][] fillData(){
        Object[][] data = new Object[admin.getRink().getSkaters().size()][columns];
        int j = 1, i = 0;
        for (Skater skater : admin.getRink().getSkaters()) {
            data[i] = new Object[] {
                    j++,
                    skater.toString()
            };
            i++;
        }
        return data;
    }
}
