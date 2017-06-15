package com.mygdx.game.roue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 26.05.2017.
 *
 * RoueRenforcee: Une roue spécialement solide, qui peut détruire lun obstacle
 * s'ils sont plus petits qu'elle, et ne subit pas de dégat non plus...
 */
public class RoueRenforcee implements Roue {

   private int solidite;
   private int hauteurCm;
   private double coeff;  // Coef entre 0.5 et 0.8 d'après wiki4
   private final int VITESSE_MAX = 80;

   public RoueRenforcee() {
      this.solidite = 1000;
      this.coeff = 0.8;
      this.hauteurCm = 65;
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
         solidite -= 70;

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
      return new Texture(Gdx.files.internal("roueRenforcee.png"));
   }
}
