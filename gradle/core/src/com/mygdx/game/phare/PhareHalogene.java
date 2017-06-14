package com.mygdx.game.phare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by gallouche on 26/05/17.
 */
public class PhareHalogene implements Phare {
    private final int DISTANCEECLAIRAGE = 800;
    private final int CONSOMATION = 20;
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

    @Override
    public boolean isAllume() {
        return allume;
    }

    @Override
    public Texture getTexture() {
        return new Texture(Gdx.files.internal("core/assets/littleLights.png"));
    }
}
