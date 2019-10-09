package com.app.threads;

import com.app.model.Administrator;
import com.app.model.Rink;
import com.app.view.SkatingUI;

/**
 * Created by prulov on 26.11.2016.
 */
public class VacantRunningThread extends Thread {

    private Administrator admin;
    private SkatingUI skUI;
    private volatile boolean isRunning = true;

    public VacantRunningThread(Administrator admin, SkatingUI skUI) {
        this.admin = admin;
        this.skUI = skUI;
    }

    public void stopRunning() {
        isRunning = false;
    }

    @Override
    public void run(){
        while (isRunning) {
            String str = String.valueOf(Rink.getN() - admin.howManySkaters());
            skUI.setVacantPlaces(str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        if(isRunning == false) System.out.println("VRT-thread stopped!!!");
    }
}

