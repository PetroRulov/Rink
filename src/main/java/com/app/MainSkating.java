package com.app;

import com.app.model.Skater;
import com.app.model.Administrator;
import com.app.model.Rink;
import com.app.view.SkatingUI;

import java.util.*;

/**
 * Created by prulov on 26.11.2016.
 */
public class MainSkating {

    public static void main(String[] args) throws InterruptedException {

        List<Skater> skaters = new ArrayList<>();
        Rink rink = new Rink(skaters);
        Administrator admin = new Administrator(rink);
        SkatingUI skUI = new SkatingUI(admin);

        /* anonymous Runnable-class for thread1 */
//        Thread thread1 = new Thread(new Runnable() {
//            private volatile boolean isRunning = true;
//            public void stopRunning() {
//                isRunning = false;
//            }
//
//            @Override
//            public void run(){
//                while (!Thread.interrupted() && isRunning) {
//                    skUI.getFrame().setVisible(true);
//                    skUI.getFrame().pack();
//                    skUI.getFrame().repaint();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
//        });
//        thread1.start();

        Thread thread1 = new Thread(skUI.getUit());
        thread1.start();
        skUI.getSnt().start();
        skUI.getVrt().start();
        skUI.getTpt().start();

        /* eternal loop */
        int n;
        while(true && !thread1.isInterrupted()) {
            n = inOutCommers();
            if (n == 1) {
                admin.outSkater();
                Thread.sleep(1000);
            } else {
                admin.enterSkater();
                Thread.sleep(1000);
            }

            /* how we can interrupt the threads */
//            int quantity = admin.howManySkaters();
//            if(quantity > 2) skUI.getSnt().interrupt();
//            if(quantity > 3) skUI.getTpt().interrupt();
//            if(quantity > 4) skUI.getVrt().stopRunning();
//            if(admin.howManySkaters() == 5) {
//                thread1.interrupt();
//            }
        }
    }

    public static int inOutCommers() {
        Random random = new Random();
        int i = random.nextInt(2);
        return i;
    }
}
