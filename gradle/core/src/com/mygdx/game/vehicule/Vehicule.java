/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.vehicule;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.roue.Roue;

public interface Vehicule {

    public Texture getTexture();
    public Roue getRoue();
    public Moteur getMoteur();
    public Phare getPhare();
    public int getPuissance();
    public double getLife();
}
