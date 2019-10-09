package com.app.model;

import javax.swing.*;

/**
 * Created by prulov on 26.11.2016.
 */
public class Administrator {

    private Rink rink;

    public Administrator(Rink rink) {
        this.rink = rink;
    }

    public Rink getRink() {
        return rink;
    }

    public void enterSkater() {
        if(rink.getSkaters().size() < Rink.getN()) {
            synchronized (Rink.class) {
                if(rink.getSkaters().size() == 0){
                    rink.getSkaters().add(0, new Skater(1));
                } else {
                    rink.getSkaters().add(rink.getSkaters().size(), new Skater(rink.getSkaters().size() + 1));
                }
            }
        } else {
            JOptionPane.showConfirmDialog(null, "This Rink is full now \n There are no vacant places \n Try later, please.", "Overloading message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    public void outSkater() {
        if(rink.getSkaters().size() > 0) {
            synchronized (Rink.class) {
                rink.getSkaters().remove(rink.getSkaters().get(rink.getSkaters().size() - 1));
            }
        } else {
            JOptionPane.showConfirmDialog(null, "This Rink is empty \n There is nobody to out.", "Empty notice", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    public void resetRink() {
        if(rink.getSkaters().size() != 0) {
            rink.getSkaters().clear();
        } else {
            JOptionPane.showConfirmDialog(null, "Couldn't clear \n Rink is empty already", "Empty notice", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    public int howManySkaters() {
        return rink.getSkaters().size();
    }
}
