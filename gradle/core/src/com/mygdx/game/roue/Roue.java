/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.roue;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.obstacle.Obstacle;

/**
 * Interface pour une Roue. Une Roue permet de déterminer un coefficient 
 * de frottement, une hauteur de roue, et une solidite.
 * @author mathieu
 */
public interface Roue {
    /**
     * Récupérer la hauteur d'une roue.
     * @return la hauteur de la roue
     */
    public int getHauteur();
    
    /**
     * Récupérer le coefficient de frottement de la roue. Le 
     * coefficient devrait être compris dans l'intervalle [0, 1]
     * un coefficient de 0 signifiant aucune friction et un
     * coefficient de 1 une friction maximale.
     * @return le coefficient de frottement de la roue
     */
    public double getCoeffFrottement();
    
    /**
     * Collision avec un obstacle.
     * @param obstacle l'obstacle heurté
     */
    public void collision(Obstacle obstacle, double vitesse);
    
    /**
     * La solidité actuelle de la roue. Une solidité de 0 devrait
     * signifier une roue cassée, et une roue dans cet état 
     * devrait retourner un coefficient de frottement de 1.
     * @return la solidité de la roue.
     */
    public int getSolidite();

    public Texture getTexture();

}
