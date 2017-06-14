/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mathieu
 */
public class Obstacle {
    ArrayList<Texture> textures = new ArrayList<Texture>();
    Texture currentTexture;
    public Obstacle()
    {
        textures.add(new Texture(Gdx.files.internal("core/assets/rock1.png")));
        textures.add(new Texture(Gdx.files.internal("core/assets/rock2.png")));
        textures.add(new Texture(Gdx.files.internal("core/assets/rock3.png")));
        textures.add(new Texture(Gdx.files.internal("core/assets/rock4.png")));
        textures.add(new Texture(Gdx.files.internal("core/assets/rock5.png")));

        Random random = new Random();
        currentTexture = textures.get(random.nextInt(4));
    }
    public int getHauteur() {
        return 0;
    }

    public void destruire() {
        
    }
    public Texture getTexture()
    {
        return currentTexture;
    }
}
