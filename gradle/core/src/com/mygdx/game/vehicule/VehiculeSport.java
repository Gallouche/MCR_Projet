package com.mygdx.game.vehicule;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.roue.Roue;

/**
 * 
 */
<<<<<<< HEAD:gradle/core/src/com/mygdx/game/vehicule/VehiculeSport.java
public class VehiculeSport implements Vehicule
{
    private Roue   roue;
    private Phare  phare;
    private Moteur moteur;
=======
public class VehiculeTurbo extends Vehicule {
>>>>>>> 2ff1f0eaa0c708193f7c2edd52c6b9389d2ac927:gradle/core/src/com/mygdx/game/vehicule/VehiculeTurbo.java

    public VehiculeSport(Roue r, Phare p, Moteur m)
    {
       super(r, p, m);
    }
    public Texture getTexture()
    {
        return new Texture(Gdx.files.internal("voitureTurbo.png"));
    }


    @Override
    public int getPuissance() {
        return (int)((getMoteur().getPuissance() - getPhare().getConsommation())*getRoue().getCoeffFrottement() + 40);
    }

    @Override
    public double getLife() {
        return getRoue().getSolidite()/1000.0;
    }
}
