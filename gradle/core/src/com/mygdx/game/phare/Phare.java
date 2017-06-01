/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.phare;

/**
 * Interface Phare. Le comportement de cette interface représente 
 * un phare étant alimenté par une certaine quantité d'énergie 
 * et produisant une certaine distance d'éclairage en fonction
 * de cette énergie fournie.
 * @author mathieu
 */
public interface Phare {
    /**
     * Donner de l'énergie au phare. L'énergie est un entier 
     * positif ou nul.
     * @param energie la quantité d'énergie fournie
     */
    public void donnerEnergie(int energie);
    
    /**
     * Récupérer la distance d'éclairage d'un Phare. La distance 
     * est une quantité de pixels.
     * @return 
     */
    public int getDistanceEclairage();
    
    /**
     * Allumer le phare. 
     */
    public void allumer();
    
    /**
     * Eteindre le phare. Un phare devrait retourner une distance nulle
     * d'éclairage quand il est considéré comme éteint.
     */
    public void eteindre();
    
    /**
     * Retourne la consommation d'énergie nécessaire pour produire la
     * distance d'éclairage optimale du Phare.
     * @return la consommation d'énergie 
     */
    public int getConsommation();
}
