package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter
{
	Batch batch;

	Texture background1, background2, background3, background4, background5, voiture,
			wheelTurbo, cloud1, cloud2, cloud3, cloud4;

	Sprite backgroundScroll1, backgroundScroll2, backgroundScrollBack1, backgroundScrollBack2,
			backgroundScrollBackBack1, backgroundScrollBackBack2,
			backgroundScrollBackBackBack1, backgroundScrollBackBackBack2, backgroundSun, voitureS, wheelTurboS1, wheelTurboS2,
			cloudS1, cloudS2, cloudS3, cloudS4;
	List<Sprite> listClouds;

	int scrollingTranslate1 = 0;
	int scrollingTranslate2 = 0;
	int scrollingTranslate3 = 0;
	int scrollingTranslate4 = 0;
	int rand1, rand2, rand3, rand4;

	Texture menuTexture;
	Sprite menu;
	@Override
	public void create ()
	{
		menuTexture = new Texture(Gdx.files.internal("menu.png"));
		menu = new Sprite(menuTexture);
		menu.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

		batch = new SpriteBatch();
		background1 = new Texture(Gdx.files.internal("backgroundscroll_.png"));
		background2 = new Texture(Gdx.files.internal("backgroundscrollBack.png"));
		background3 = new Texture(Gdx.files.internal("backgroundscrollBack1.png"));
		background4 = new Texture(Gdx.files.internal("backgroundscrollBack2.png"));
		background5 = new Texture(Gdx.files.internal("backgroundscrollBack3.png"));
		voiture     = new Texture(Gdx.files.internal("voiture.png"));
		wheelTurbo  = new Texture(Gdx.files.internal("wheelTurbo.png"));
		cloud1 = new Texture(Gdx.files.internal("cloud1.png"));
		cloud2 = new Texture(Gdx.files.internal("cloud2.png"));
		cloud3 = new Texture(Gdx.files.internal("cloud3.png"));
		cloud4 = new Texture(Gdx.files.internal("cloud4.png"));

		cloudS1 = new Sprite(cloud1);
		cloudS2 = new Sprite(cloud2);
		cloudS3 = new Sprite(cloud3);
		cloudS4 = new Sprite(cloud4);

		cloudS1.setY(700);
		cloudS2.setY(650);
		cloudS3.setY(400);
		cloudS4.setY(550);

		cloudS1.setX(1000);
		cloudS2.setX(300);
		cloudS3.setX(1500);
		cloudS4.setX(1900);

		rand1 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		rand2 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		rand3 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		rand4 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;

		backgroundSun = new Sprite(background5);
		voitureS      = new Sprite(voiture);

		wheelTurboS1   = new Sprite(wheelTurbo);
		wheelTurboS2   = new Sprite(wheelTurbo);
		wheelTurboS1.setPosition(1020, 60);
		wheelTurboS2.setPosition(1200, 60);

		backgroundScroll1 = new Sprite(background1);
		backgroundScroll2 = new Sprite(background1);

		backgroundScrollBack1 = new Sprite(background2);
		backgroundScrollBack2 = new Sprite(background2);

		backgroundScrollBackBack1 = new Sprite(background3);
		backgroundScrollBackBack2 = new Sprite(background3);

		backgroundScrollBackBackBack1 = new Sprite(background4);
		backgroundScrollBackBackBack2 = new Sprite(background4);

		listClouds = new ArrayList<Sprite>();
	}

	@Override
	public void render ()
	{

		cloudS1.setX(cloudS1.getX()+ rand1);
		cloudS2.setX(cloudS2.getX()+ rand2);
		cloudS3.setX(cloudS3.getX()+ rand3);
		cloudS4.setX(cloudS4.getX()+ rand4);

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			scrollingTranslate1 -= 4;
			scrollingTranslate2 -= 1;
			scrollingTranslate3 -= 3;
			wheelTurboS1.setRotation(wheelTurboS1.getRotation()-5);
			wheelTurboS2.setRotation(wheelTurboS2.getRotation()-5);
		}
		if(-scrollingTranslate1 > background1.getWidth())
			scrollingTranslate1 = 0;
		if(-scrollingTranslate2 > background2.getWidth())
			scrollingTranslate2 = 0;
		if(-scrollingTranslate3 > background3.getWidth())
			scrollingTranslate3 = 0;
		if(-scrollingTranslate4 > background4.getWidth())
			scrollingTranslate4 = 0;

		backgroundScroll1.setX(scrollingTranslate1);
		backgroundScroll2.setX(scrollingTranslate1 + background1.getWidth());

		backgroundScrollBackBack1.setX(scrollingTranslate3);
		backgroundScrollBackBack2.setX(scrollingTranslate3 + background3.getWidth());

		backgroundScrollBack1.setX(scrollingTranslate2);
		backgroundScrollBack2.setX(scrollingTranslate2 + background2.getWidth() );

		backgroundScrollBackBackBack1.setX(scrollingTranslate4);
		backgroundScrollBackBackBack2.setX(scrollingTranslate4 + background4.getWidth() );

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		backgroundScrollBackBackBack1.draw(batch);
		backgroundScrollBackBackBack2.draw(batch);

		backgroundSun.draw(batch);

		backgroundScrollBack1.draw(batch);
		backgroundScrollBack2.draw(batch);

		backgroundScrollBackBack1.draw(batch);
		backgroundScrollBackBack2.draw(batch);

		backgroundScroll1.draw(batch);
		backgroundScroll2.draw(batch);

		voitureS.draw(batch);
		wheelTurboS1.draw(batch);
		wheelTurboS2.draw(batch);

		cloudS1.draw(batch);
		cloudS2.draw(batch);
		cloudS3.draw(batch);
		cloudS4.draw(batch);

		menu.draw(batch);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background1.dispose();
	}
}
