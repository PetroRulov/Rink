package com.app.threads;

import com.app.view.SkatingUI;

/**
 * Created by prulov on 27.11.2016.
 */
public class UIThread implements Runnable {

    private SkatingUI skUI;

    public UIThread(SkatingUI skUI) {
        this.skUI = skUI;
    }

    @Override
    public void run(){
        while (!Thread.interrupted()) {
            skUI.getFrame().setVisible(true);
            skUI.getFrame().pack();
            skUI.getFrame().repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("UIThr-thread interrupted");
    }
}
