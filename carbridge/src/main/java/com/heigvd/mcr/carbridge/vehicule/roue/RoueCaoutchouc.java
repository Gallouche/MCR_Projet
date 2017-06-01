package com.heigvd.mcr.carbridge.vehicule.roue;

import com.heigvd.mcr.carbridge.vehicule.obstacle.Obstacle;

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
      this.solidite = 100;
      this.hauteur = 120;
      this.coeff = 0.7;
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
      // Si vitesse plus grande que 60km/h => collision possible
      if (vitesse > VITESSE_MAX) {
         if (hauteur / 2 < obstacle.getHauteur()) {
              solidite -= 10;
              coeff += 0.05;
              hauteur -= 10;
         } else {
            obstacle.destruire();
         }
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
