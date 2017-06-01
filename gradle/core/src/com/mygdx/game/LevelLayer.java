package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin moreira on 11.05.2017.
 */
public class LevelLayer
{
    public float speedScalar = 1;

    private List<Sprite> backgroundSprites = new ArrayList<Sprite>();

    public LevelLayer()
    {

    }

    public void addSpriteLayer(Texture texture, float startingPointX, float y, int repeats)
    {
        for (int k = 0; k < repeats; k++)
        {
            Sprite s = new Sprite(texture);
            s.setX(startingPointX + (k*texture.getWidth()));
            s.setY(y);

            backgroundSprites.add(s);
        }
    }

    public void render(SpriteBatch spriteBatch, float speed)
    {
        for (Sprite s : backgroundSprites)
        {
            float delta = s.getX() - (speed * speedScalar);
            s.setX(delta);

            s.draw(spriteBatch);
        }
    }
}
