package com.mygdx.game.phare;

/**
 * Created by gallouche on 26/05/17.
 */
public class PhareHalogene implements Phare {
    private final int DISTANCEECLAIRAGE = 250;
    private final int CONSOMATION = 5;
    private int energie;
    private boolean allume;

    public PhareHalogene() {
        energie = 0;
        allume = false;
    }

    @Override
    public void donnerEnergie(int energie) {
        this.energie += energie;
    }

    @Override
    public int getDistanceEclairage() {
        return DISTANCEECLAIRAGE;
    }

    @Override
    public void allumer() {
        allume = true;
    }

    @Override
    public void eteindre() {
        allume = false;
    }

    @Override
    public int getConsommation() {
        if(!allume)
            return 0;
        else{
            return CONSOMATION;
        }
    }
}
