package com.heigvd.mcr.carbridge.vehicule.phare;

/**
 * Created by gallouche on 26/05/17.
 */
public class PhareLED implements Phare {
    private final int DISTANCEECLAIRAGE = 300;
    private final int CONSOMATION = 8;
    private int energie;
    private boolean allume;

    public PhareLED() {
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
