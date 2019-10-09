package com.app.threads;

import com.app.model.Administrator;
import com.app.view.SkatingUI;

/**
 * Created by prulov on 26.11.2016.
 */
public class SkatersNumberThread extends Thread {

    private Administrator admin;
    private SkatingUI skUI;

    public SkatersNumberThread(Administrator admin, SkatingUI skUI) {
        this.admin = admin;
        this.skUI = skUI;
    }

    @Override
    public void run(){
        while (!Thread.interrupted()) {
            String str = String.valueOf(admin.howManySkaters());
            skUI.setSkatersQuant(str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("SNT-thread interrupted");
    }
}
