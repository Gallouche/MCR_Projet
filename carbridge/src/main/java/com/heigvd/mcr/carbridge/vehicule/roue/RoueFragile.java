package com.heigvd.mcr.carbridge.vehicule.roue;

import com.heigvd.mcr.carbridge.vehicule.obstacle.Obstacle;

/**
 * Created by User on 26.05.2017.
 *
 *
 * RoueFragile: Une roue qui frotte très peu, mais qui se fragilise avec le temps,
 * et qui perd donc des valeurs de solidité. Elle perd 50% de sa vie maximale à chaque collisions.
 */

public class RoueFragile implements Roue{

    private int vie;
    private int hauteurCm;
    private double coeff;  // Coef entre 0.5 et 0.8 d'après wiki

    public RoueFragile(){
        this.vie = 100;
        this.coeff = 0.3;
        this.hauteurCm = 60;
    }

    /**
     * Récupérer la hauteur d'une roue.
     * @return la hauteur de la roue
     */
    @Override
    public int getHauteur() {
        return hauteurCm;
    }

    /**
     * Récupérer le coefficient de frottement de la roue. Le
     * coefficient devrait être compris dans l'intervalle [0, 1]
     * un coefficient de 0 signifiant aucune friction et un
     * coefficient de 1 une friction maximale.
     * @return le coefficient de frottement de la roue
     */
    @Override
    public double getCoeffFrottement() {
        if(vie == 0) {
            return 1.0;
        }

        return coeff;
    }

    /**
     * Collision avec un obstacle.
     * @param obstacle l'obstacle heurté
     */
    @Override
    public void collision(Obstacle obstacle, double vitesse) {
        // Si vitesse plus grande que 30km/h => collision possible
        if(vitesse > 30){
            // Si l'hauteur de l'obstacle dépasse la moitié de la hauteur de la roue => Collision
            if(hauteurCm/2 < obstacle.getHauteur()){
                vie -= 50;
            }
        }
    }

    /**
     * La solidité actuelle de la roue. Une solidité de 0 devrait
     * signifier une roue cassée, et une roue dans cet état
     * devrait retourner un coefficient de frottement de 1.
     * @return la solidité de la roue.
     */
    @Override
    public int getSolidite() {
       return vie ;
    }
}
