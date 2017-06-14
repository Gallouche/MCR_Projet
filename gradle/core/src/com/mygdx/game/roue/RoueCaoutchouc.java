package com.mygdx.game.roue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 26.05.2017.
 *
 * RoueCaoutchouc: Sa hauteur varie, devenant petite puis grande puis petite
 * etc... avec le temps. Son frottement varie en fonction de sa hauteur.
 */
public class RoueCaoutchouc implements Roue {

   private int solidite;
   private double coeff; // 0 => grande, 1 => peite
   private int hauteur;
   private int VITESSE_MAX = 60;

   public RoueCaoutchouc() {
      this.solidite = 1000;
      this.hauteur = 50;
      this.coeff = 1;
   }

   /**
    * Récupérer la hauteur d'une roue.
    *
    * @return la hauteur de la roue
    */
   @Override
   public int getHauteur() {
      return hauteur;
   }

   /**
    * Récupérer le coefficient de frottement de la roue. Le coefficient devrait
    * être compris dans l'intervalle [0, 1] un coefficient de 0 signifiant
    * aucune friction et un coefficient de 1 une friction maximale.
    *
    * @return le coefficient de frottement de la roue
    */
   @Override
   public double getCoeffFrottement() {
      return coeff;
   }

   /**
    * Collision avec un obstacle.
    *
    */
   @Override
   public void collision(boolean grosseCollision) {
         if(grosseCollision)
            solidite -= 80;
         else
            solidite -= 5;

   }

   /**
    * La solidité actuelle de la roue. Une solidité de 0 devrait signifier une
    * roue cassée, et une roue dans cet état devrait retourner un coefficient de
    * frottement de 1.
    *
    * @return la solidité de la roue.
    */
   @Override
   public int getSolidite() {
      return solidite;
   }

   public Texture getTexture(){
      return new Texture(Gdx.files.internal("roueCaoutchoucGrand.png"));
   }
}
