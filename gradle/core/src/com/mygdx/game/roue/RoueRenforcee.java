package com.mygdx.game.roue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.obstacle.Obstacle;

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
   private int VITESSE_MAX = 80;

   public RoueRenforcee() {
      this.solidite = 100;
      this.coeff = 0.7;
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
      if (solidite == 0) {
         return 1.0;
      }

      return coeff;
   }

   /**
    * Collision avec un obstacle.
    *
    * @param obstacle l'obstacle heurté
    */
   @Override
   public void collision(Obstacle obstacle, double vitesse) {
      // Si vitesse plus grande que 80km/h => collision possible
      if (vitesse > VITESSE_MAX && obstacle.getHauteur() > hauteurCm / 2) {
         solidite -= 5;
      } else {
         obstacle.destruire();
      }

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
      return new Texture(Gdx.files.internal("core/assets/roueRenforcee.png"));
   }
}
