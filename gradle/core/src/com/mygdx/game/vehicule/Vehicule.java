package com.mygdx.game.vehicule;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.roue.Roue;

/**
 *
 * @author mathieu
 */
public abstract class Vehicule {
    private Roue roue;
    private Phare phare;
    private Moteur moteur;
    
    public Vehicule(Roue roue, Phare phare, Moteur moteur) {
       this.roue = roue;
       this.phare = phare;
       this.moteur = moteur;
    }
   

    public abstract Texture getTexture();
    public Roue getRoue() {
       return roue;
    }
    public Moteur getMoteur() {
       return moteur;
    }
    public Phare getPhare() {
       return phare;
    }
    public  abstract int getPuissance();
    public  abstract double getLife();
}
