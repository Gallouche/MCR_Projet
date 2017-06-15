package com.mygdx.game.moteur;

/**
 * Interface d'un Moteur. Un moteur permet d'obtenir une certain puissance
 * représenté en quantité d'énergie entière ou nulle.
 * @author Mathieu Monteverde
 */
public interface Moteur {
    /**
     * Démarrer le moteur.
     */
    public void demarrer();
    
    /**
     * Eteindre le moteur. Un moteur considéré comme allumé devrait 
     * normalement retourner une puissance positive.
     */
    public void eteindre();
    
    /**
     * Récupérer la puissance du moteur en quantité d'énergie.
     * @return une quantité d'énergie produite
     */
    public int getPuissance();
    
    /**
     * Return la température actuelle d'un moteur. Un moteur ne devrait pas
     * dépasser sa température maximum.
     * @return la température actuelle du moteur
     */
    public int getTemperature();
    
    /**
     * Déterminer si le moteur est allumé.
     * @return true si le moteur est allumé
     */
    public boolean estAllume();
}
