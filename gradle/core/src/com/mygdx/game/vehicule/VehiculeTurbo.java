/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.vehicule;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.roue.Roue;

/**
 *
 * @author mathieu
 */
public class VehiculeTurbo implements Vehicule
{
    private Roue   roue;
    private Phare  phare;
    private Moteur moteur;

    public VehiculeTurbo(Roue r, Phare p, Moteur m)
    {
        roue   = r;
        phare  = p;
        moteur = m;
    }
    public Texture getTexture()
    {
        return new Texture(Gdx.files.internal("voitureTurbo.png"));
    }
    @Override
    public Roue getRoue(){
        return roue;
    }
    @Override
    public Moteur getMoteur(){
        return moteur;
    }
    @Override
    public Phare getPhare(){
        return phare;
    }


    @Override
    public int getPuissance() {
        return (int)((moteur.getPuissance() - phare.getConsommation())*roue.getCoeffFrottement() + 40);
    }

    @Override
    public double getLife() {
        return roue.getSolidite()/1000.0;
    }
}
