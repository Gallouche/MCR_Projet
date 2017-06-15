package com.mygdx.game.vehicule;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.roue.Roue;

/**
 *
 */
public class VehiculeNormal extends Vehicule{

    public VehiculeNormal(Roue r, Phare p, Moteur m)
    {
       super(r, p, m);
    }

    @Override
    public Texture getTexture() {
        return new Texture(Gdx.files.internal("voitureNormale.png"));
    }

    @Override
    public int getPuissance(){
        return (int)((getMoteur().getPuissance() - getPhare().getConsommation())*getRoue().getCoeffFrottement());
    }

    @Override
    public double getLife() {
        return (getRoue().getSolidite() + 300)/1300.0;
    }
}
