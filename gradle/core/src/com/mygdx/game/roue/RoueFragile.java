package com.mygdx.game.roue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 26.05.2017.
 *
 *
 * RoueFragile: Une roue qui frotte très peu, mais qui se fragilise avec le
 * temps, et qui perd donc des valeurs de solidité. Elle perd 50% de sa solidite
 * maximale à chaque collisions.
 */
public class RoueFragile implements Roue {

   private int solidite;
   private int hauteurCm;
   private double coeff;  // Coef entre 0.5 et 0.8 d'après wiki
   private int VITESSE_MAX;

   public RoueFragile() {
      this.solidite = 1000;
      this.coeff = 1.2;
      this.hauteurCm = 30;
   }

   /**
    * Récupérer la hauteur d'une roue.
    *
    * @return la hauteur de la roue
    */
   @Override
   public int getHauteur() {
      return hauteurCm;
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
    */
   @Override
   public void collision(boolean grosseCollision) {
      if(grosseCollision)
         solidite -= 120;
      else
         solidite -= 30;
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

   @Override
   public Texture getTexture() {
      return new Texture(Gdx.files.internal("core/assets/roueFragile.png"));
   }


}
