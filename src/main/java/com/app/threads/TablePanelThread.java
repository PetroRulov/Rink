package com.app.threads;

import com.app.view.SkatingUI;

/**
 * Created by prulov on 26.11.2016.
 */
public class TablePanelThread extends Thread {

    private SkatingUI skUI;

    public TablePanelThread(SkatingUI skUI) {
        this.skUI = skUI;
    }

    @Override
    public void run(){
        while (!Thread.interrupted()) {
            skUI.setTablePanel();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("TPT-thread interrupted");
    }
}
