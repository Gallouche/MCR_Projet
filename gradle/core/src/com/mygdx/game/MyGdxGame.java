package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.mygdx.game.moteur.Moteur;
import com.mygdx.game.moteur.MoteurEssence;
import com.mygdx.game.moteur.MoteurTurbo;
import com.mygdx.game.phare.Phare;
import com.mygdx.game.phare.PhareHalogene;
import com.mygdx.game.phare.PhareLED;
import com.mygdx.game.phare.PhareXenon;
import com.mygdx.game.roue.Roue;
import com.mygdx.game.roue.RoueCaoutchouc;
import com.mygdx.game.roue.RoueFragile;
import com.mygdx.game.roue.RoueRenforcee;
import com.mygdx.game.vehicule.Vehicule;
import com.mygdx.game.vehicule.VehiculeNormal;
import com.mygdx.game.vehicule.VehiculeTurbo;

import java.util.ArrayList;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter
{
	Texture background1, background2, background3, background4, background5, voiture, voitureTurbo,
			wheelTurbo, cloud1, cloud2, cloud3, cloud4;

	Image backgroundScroll1, backgroundScroll2, backgroundScrollBack1, backgroundScrollBack2,
			backgroundScrollBackBack1, backgroundScrollBackBack2,
			backgroundScrollBackBackBack1, backgroundScrollBackBackBack2, backgroundSun, voitureS, wheelTurboS1, wheelTurboS2,
			cloudS1, cloudS2, cloudS3, cloudS4, roueAffichee1, roueAffichee2, phareAffiche, moteurAffiche;
	List<Image> listClouds;

	int scrollingTranslate1 = 0;
	int scrollingTranslate2 = 0;
	int scrollingTranslate3 = 0;
	int scrollingTranslate4 = 0;
	int rand1, rand2, rand3, rand4;

	Stage stage, menuStage;
	Texture menuTexture, buttonSelectedTex, buttonNotSelectedTex, buttonStart, buttonStartOn;
	Actor menu;
	Image buttonvoiture1, buttonvoiture2;
	Image buttonMotorEssence, buttonMotorTurbo;
	Image buttonWheelBig, buttonWheelSmall, buttonWheelCaoutchouc;
	Image buttonBigLight, buttonMiddleLight, buttonSmallLight;
	Image start;

	String carSelection;

	Moteur myMoteur;
	Phare myPhare;
	Roue myRoue;
	Vehicule myVehicule;


	boolean menuOver;
	boolean cloud1MovingRight, cloud2MovingRight, cloud3MovingRight, cloud4MovingRight;
	@Override
	public void create ()
	{
		myMoteur = new MoteurEssence();
		myRoue = new RoueRenforcee();
		myPhare = new PhareXenon();
		carSelection = "vehiculeNormal";

		menuOver  = true;
		stage     = new Stage();
		menuStage = new Stage();

		menuTexture = new Texture(Gdx.files.internal("core/assets/menu.png"));
		buttonSelectedTex = new Texture(Gdx.files.internal("core/assets/buttonSelect.png"));
		buttonNotSelectedTex = new Texture(Gdx.files.internal("core/assets/buttonNotSelect.png"));
		buttonStart = new Texture(Gdx.files.internal("core/assets/startButton.png"));
		buttonStartOn = new Texture(Gdx.files.internal("core/assets/startButton-on.png"));

		voiture     = new Texture(Gdx.files.internal("core/assets/voiture.png"));
		voitureTurbo = new Texture(Gdx.files.internal("core/assets/voitureTurbo.png"));



		menu = new Image(menuTexture);
		menu.setPosition(Gdx.graphics.getWidth()/2 - menu.getWidth()/2, Gdx.graphics.getHeight()/2 - menu.getHeight()/2);

		buttonvoiture1 = new Image(buttonSelectedTex);
		buttonvoiture1.setSize(70,40);
		buttonvoiture1.setPosition(menu.getX() + 180, menu.getY() + 690);

		buttonvoiture1.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonvoiture1.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonvoiture2.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				carSelection = "vehiculeNormal";
			}
		});

		buttonvoiture2 = new Image(buttonNotSelectedTex);
		buttonvoiture2.setSize(70,40);
		buttonvoiture2.setPosition(menu.getX() + 580, menu.getY() + 690);

		buttonvoiture2.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonvoiture2.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonvoiture1.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				carSelection = "vehiculeTurbo";
			}
		});


		buttonMotorEssence = new Image(buttonSelectedTex);
		buttonMotorEssence.setSize(70,40);
		buttonMotorEssence.setPosition(menu.getX() + 95, menu.getY() + 430);

		buttonMotorEssence.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonMotorEssence.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonMotorTurbo.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myMoteur = new MoteurEssence();
			}
		});

		buttonMotorTurbo = new Image(buttonNotSelectedTex);
		buttonMotorTurbo.setSize(70,40);
		buttonMotorTurbo.setPosition(menu.getX() + 270, menu.getY() + 430);

		buttonMotorTurbo.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonMotorTurbo.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonMotorEssence.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myMoteur = new MoteurTurbo();
			}
		});

		buttonWheelBig = new Image(buttonSelectedTex);
		buttonWheelBig.setSize(70,40);
		buttonWheelBig.setPosition(menu.getX() + 465, menu.getY() + 430);

		buttonWheelBig.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonWheelBig.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonWheelCaoutchouc.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonWheelSmall.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myRoue = new RoueRenforcee();
			}
		});

		buttonWheelSmall = new Image(buttonNotSelectedTex);
		buttonWheelSmall.setSize(70,40);
		buttonWheelSmall.setPosition(menu.getX() + 588, menu.getY() + 430);

		buttonWheelSmall.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonWheelSmall.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonWheelCaoutchouc.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonWheelBig.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myRoue = new RoueCaoutchouc();
			}
		});

		buttonWheelCaoutchouc = new Image(buttonNotSelectedTex);
		buttonWheelCaoutchouc.setSize(70,40);
		buttonWheelCaoutchouc.setPosition(menu.getX() + 695, menu.getY() + 430);

		buttonWheelCaoutchouc.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonWheelCaoutchouc.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonWheelSmall.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonWheelBig.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myRoue = new RoueFragile();
			}
		});

		buttonBigLight = new Image(buttonSelectedTex);
		buttonBigLight.setSize(70,40);
		buttonBigLight.setPosition(menu.getX() + 160, menu.getY() + 170);

		buttonBigLight.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonBigLight.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonSmallLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonMiddleLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myPhare = new PhareXenon();
			}
		});

		buttonMiddleLight = new Image(buttonNotSelectedTex);
		buttonMiddleLight.setSize(70,40);
		buttonMiddleLight.setPosition(menu.getX() + 400, menu.getY() + 170);

		buttonMiddleLight.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonMiddleLight.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonSmallLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonBigLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myPhare = new PhareLED();
			}
		});

		buttonSmallLight = new Image(buttonNotSelectedTex);
		buttonSmallLight.setSize(70,40);
		buttonSmallLight.setPosition(menu.getX() + 600, menu.getY() + 170);

		buttonSmallLight.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				buttonSmallLight.setDrawable(new SpriteDrawable(new Sprite(buttonSelectedTex)));
				buttonMiddleLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				buttonBigLight.setDrawable(new SpriteDrawable(new Sprite(buttonNotSelectedTex)));
				myPhare = new PhareHalogene();
			}
		});

		start = new Image(buttonStart);
		start.setSize(416,89);
		start.setPosition(menu.getX() + menu.getWidth()/2 - start.getWidth()/2, menu.getY() +20);
		start.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y) {
				if(carSelection.equals("vehiculeNormal"))
				{
					myVehicule = new VehiculeNormal(myRoue, myPhare, myMoteur);
				}
				else if(carSelection.equals("vehiculeTurbo"))
				{
					myVehicule = new VehiculeTurbo(myRoue,myPhare,myMoteur);
				}

				voitureS = new Image(myVehicule.getTexture());
				roueAffichee1 = new Image((myVehicule.getRoue().getTexture()));
				roueAffichee2 = new Image((myVehicule.getRoue().getTexture()));
				phareAffiche = new Image(myVehicule.getPhare().getTexture());
				menuOver = false;
			}
		});
		start.addListener(new InputListener() {

			public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
				start.setDrawable(new SpriteDrawable(new Sprite(buttonStartOn)));
			}
			public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
				start.setDrawable(new SpriteDrawable(new Sprite(buttonStart)));
			}
		});

		background1 = new Texture(Gdx.files.internal("core/assets/backgroundscroll_.png"));
		background2 = new Texture(Gdx.files.internal("core/assets/backgroundscrollBack.png"));
		background3 = new Texture(Gdx.files.internal("core/assets/backgroundscrollBack1.png"));
		background4 = new Texture(Gdx.files.internal("core/assets/backgroundscrollBack2.png"));
		background5 = new Texture(Gdx.files.internal("core/assets/backgroundscrollBack3.png"));
		wheelTurbo  = new Texture(Gdx.files.internal("core/assets/wheelTurbo.png"));

		cloud1 = new Texture(Gdx.files.internal("core/assets/cloud1.png"));
		cloud2 = new Texture(Gdx.files.internal("core/assets/cloud2.png"));
		cloud3 = new Texture(Gdx.files.internal("core/assets/cloud3.png"));
		cloud4 = new Texture(Gdx.files.internal("core/assets/cloud4.png"));

		cloudS1 = new Image(cloud1);
		cloudS2 = new Image(cloud2);
		cloudS3 = new Image(cloud3);
		cloudS4 = new Image(cloud4);

		cloudS1.setY(700);
		cloudS2.setY(650);
		cloudS3.setY(400);
		cloudS4.setY(550);

		cloudS1.setX(1000);
		cloudS2.setX(300);
		cloudS3.setX(1500);
		cloudS4.setX(1900);

		rand1 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		if(rand1 < 0)
			cloud1MovingRight = false;
		rand2 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		if(rand2 < 0)
			cloud2MovingRight = false;
		rand3 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		if(rand3 < 0)
			cloud3MovingRight = false;
		rand4 = (int)( Math.random()*( 4 + 4 + 1 ) )  -4;
		if(rand4 < 0)
			cloud4MovingRight = false;

		backgroundSun = new Image(background5);


		wheelTurboS1   = new Image(wheelTurbo);
		wheelTurboS2   = new Image(wheelTurbo);
		wheelTurboS1.setPosition(1020, 60);
		wheelTurboS2.setPosition(1200, 60);

		backgroundScroll1 = new Image(background1);
		backgroundScroll2 = new Image(background1);

		backgroundScrollBack1 = new Image(background2);
		backgroundScrollBack2 = new Image(background2);

		backgroundScrollBackBack1 = new Image(background3);
		backgroundScrollBackBack2 = new Image(background3);

		backgroundScrollBackBackBack1 = new Image(background4);
		backgroundScrollBackBackBack2 = new Image(background4);

		listClouds = new ArrayList<Image>();
	}

	@Override
	public void render ()
	{
		if(cloud1MovingRight &&cloudS1.getX() > stage.getWidth())
		{
			rand1 = rand1 * (-1);
			cloud1MovingRight = false;
		}
		else if(!cloud1MovingRight && cloudS1.getX()+cloudS1.getWidth() < 0)
		{
			rand1 = rand1 * (-1);
			cloud1MovingRight = true;
		}
		cloudS1.setX(cloudS1.getX()+ rand1);

		if(cloud2MovingRight &&cloudS2.getX() > stage.getWidth())
		{
			rand2 = rand2 * (-1);
			cloud2MovingRight = false;
		}
		else if(!cloud2MovingRight && cloudS2.getX()+cloudS2.getWidth() < 0)
		{
			rand2 = rand2 * (-1);
			cloud2MovingRight = true;

		}
		cloudS2.setX(cloudS2.getX()+ rand2);

		if(cloud3MovingRight &&cloudS3.getX() > stage.getWidth())
		{
			rand3 = rand3 * (-1);
			cloud3MovingRight = false;
		}
		else if(!cloud3MovingRight && cloudS3.getX()+cloudS3.getWidth() < 0)
		{
			rand3 = rand3 * (-1);
			cloud3MovingRight = true;
		}
		cloudS3.setX(cloudS3.getX()+ rand3);

		if(cloud4MovingRight &&cloudS4.getX() > stage.getWidth())
		{
			rand4 = rand4 * (-1);
			cloud4MovingRight = false;
		}
		else if(!cloud4MovingRight && cloudS4.getX()+cloudS4.getWidth() < 0)
		{
			rand4 = rand4 * (-1);
			cloud4MovingRight = true;

		}
		cloudS4.setX(cloudS4.getX()+ rand4);

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

		Gdx.input.setInputProcessor(stage);

		stage.addActor(backgroundScrollBackBackBack1);
		stage.addActor(backgroundScrollBackBackBack2);
		backgroundSun.setPosition(stage.getWidth() - 300, stage.getHeight()-300);
		stage.addActor(backgroundSun);
		stage.addActor(backgroundScrollBack1);
		stage.addActor(backgroundScrollBack2);
		stage.addActor(backgroundScrollBackBack1);
		stage.addActor(backgroundScrollBackBack2);
		stage.addActor(backgroundScroll1);
		stage.addActor(backgroundScroll2);
		stage.addActor(cloudS1);
		stage.addActor(cloudS2);
		stage.addActor(cloudS3);
		stage.addActor(cloudS4);

		if(!menuOver)
		{
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			{
				double vitesse =myVehicule.getMoteur().getPuissance()/100.0;
				System.out.println(vitesse);
				scrollingTranslate1 -= 4 * vitesse;
				scrollingTranslate2 -= 1 * vitesse;
				scrollingTranslate3 -= 3 * vitesse;

			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			{
				myVehicule.getMoteur().eteindre();
			}
			if(Gdx.input.isKeyPressed(Input.Keys.UP))
			{
				myVehicule.getMoteur().demarrer();
			}
			if(-scrollingTranslate1 > background1.getWidth())
				scrollingTranslate1 = 0;
			if(-scrollingTranslate2 > background2.getWidth())
				scrollingTranslate2 = 0;
			if(-scrollingTranslate3 > background3.getWidth())
				scrollingTranslate3 = 0;
			if(-scrollingTranslate4 > background4.getWidth())
				scrollingTranslate4 = 0;


			phareAffiche.setPosition(stage.getWidth()+300 - myVehicule.getPhare().getDistanceEclairage(), myVehicule.getRoue().getHauteur()+20);
			stage.addActor(phareAffiche);
			voitureS.setPosition(stage.getWidth() - myVehicule.getPhare().getDistanceEclairage(), myVehicule.getRoue().getHauteur());
			stage.addActor(voitureS);

			roueAffichee1.setPosition(stage.getWidth()+60- myVehicule.getPhare().getDistanceEclairage(),20);
			stage.addActor(roueAffichee1);
			roueAffichee2.setPosition(stage.getWidth()+235- myVehicule.getPhare().getDistanceEclairage(), 20);
			stage.addActor(roueAffichee2);

			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				roueAffichee1.setOrigin(roueAffichee1.getWidth()/2, roueAffichee1.getHeight()/2);
				roueAffichee2.setOrigin(roueAffichee2.getWidth()/2, roueAffichee2.getHeight()/2);

				roueAffichee1.setRotation(roueAffichee1.getRotation() - 5);
				roueAffichee2.setRotation(roueAffichee2.getRotation() - 5);
			}
		}
		stage.draw();

		if(menuOver) {
			Gdx.input.setInputProcessor(menuStage);
			menuStage.act();
			menuStage.addActor(menu);
			menuStage.addActor(buttonvoiture1);
			menuStage.addActor(buttonvoiture2);

			menuStage.addActor(buttonMotorEssence);
			menuStage.addActor(buttonMotorTurbo);

			menuStage.addActor(buttonWheelBig);
			menuStage.addActor(buttonWheelSmall);
			menuStage.addActor(buttonWheelCaoutchouc);

			menuStage.addActor(buttonBigLight);
			menuStage.addActor(buttonMiddleLight);
			menuStage.addActor(buttonSmallLight);

			menuStage.addActor(start);
			menuStage.draw();
		}
	}
	
	@Override
	public void dispose () {
		background1.dispose();
	}
}
