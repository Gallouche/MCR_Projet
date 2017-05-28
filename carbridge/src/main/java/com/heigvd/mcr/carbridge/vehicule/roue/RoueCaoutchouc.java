package com.heigvd.mcr.carbridge.vehicule.roue;

import com.heigvd.mcr.carbridge.vehicule.obstacle.Obstacle;

/**
 * Created by User on 26.05.2017.
 *
 * RoueCaoutchouc: Sa hauteur varie, devenant petite puis grande puis petite etc...
 * avec le temps. Son frottement varie en fonction de sa hauteur.
 */
public class RoueCaoutchouc implements Roue{

    private int vie;
    private boolean isPetiteRoue; // 0 => grande, 1 => peite
    private int hauteurCmPetite;
    private int hauteurCmGrande;
    private double coeffPetite ;  // Coef entre 0.5 et 0.8 d'après wiki
    private double coeffGrande;

    public RoueCaoutchouc(){
        this.vie = 100;
        this.isPetiteRoue = false;
        this.hauteurCmPetite = 60;
        this.hauteurCmGrande = 120;
        this.coeffPetite = 0.3;  // Coef entre 0.5 et 0.8 d'après wiki
        this.coeffGrande = 0.8;
    }

    /**
     * Récupérer la hauteur d'une roue.
     * @return la hauteur de la roue
     */
    @Override
    public int getHauteur() {
        if(isPetiteRoue){
            return hauteurCmPetite;
        }else{
            return hauteurCmGrande;
        }
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

        if(isPetiteRoue){
            isPetiteRoue = false; // changement d'état
            return coeffPetite;
        }
        else {
            isPetiteRoue = true; // Changement d'état
            return coeffGrande;
        }
    }

    /**
     * Collision avec un obstacle.
     * @param obstacle l'obstacle heurté
     */
    @Override
    public void collision(Obstacle obstacle, double vitesse) {
        // Si vitesse plus grande que 30km/h => collision possible
       if(isPetiteRoue){
            collisionPetiteRoue(obstacle,vitesse);
       }else{
           collisionGrandeRoue(obstacle,vitesse);
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

    private void collisionPetiteRoue(Obstacle obstacle, double vitesse){
        if(vitesse > 30){
            if(obstacle.getHauteur() > hauteurCmPetite/2) {
                vie -= 50;
            }
        }
    }

    private void collisionGrandeRoue(Obstacle obstacle, double vitesse){
        if(vitesse > 80){
            if(obstacle.getHauteur() > hauteurCmGrande/2) {
                vie -= 5;
            }else{
                obstacle.destruire();
            }
        }
    }
}
