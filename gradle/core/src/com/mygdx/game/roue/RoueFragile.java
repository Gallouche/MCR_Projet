package com.mygdx.game.roue;

import com.mygdx.game.obstacle.Obstacle;

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
      this.solidite = 100;
      this.coeff = 0.2;
      this.hauteurCm = 60;
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
      // Si vitesse plus grande que 30km/h => collision possible
      if (vitesse > VITESSE_MAX && hauteurCm / 2 < obstacle.getHauteur()) {
         // Si l'hauteur de l'obstacle dépasse la moitié de la hauteur de la roue => Collision
         solidite -= 50;

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
}
