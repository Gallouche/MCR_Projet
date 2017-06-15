package com.mygdx.game.moteur;

/**
 * 
 */
public class MoteurElectrique implements Moteur{
   // Décrit si le moteur est allumé
   private boolean allume;
   // Température du moteur
   private int temperature;
   // Puissance du moteur
   private static int puissance = 120;
   // Température du moteur à l'allumage
   public static final int TEMPERATURE_ALLUMAGE = 40;
   
   /**
    * Constructeur.
    */
   public MoteurElectrique() {
      allume = false;
      temperature = 0;
   }
   
   /**
    * Démarre le moteur.
    */
   @Override
   public void demarrer() {
      allume = true;
      temperature = TEMPERATURE_ALLUMAGE;
   }
   
   /**
    * Eteint le moteur.
    */
   @Override
   public void eteindre() {
      allume = false;
      temperature = 0;
   }
   
   /**
    * Retourn le puissance du moteur (0 si éteint).
    * @return la puissance
    */
   @Override
   public int getPuissance() {
      if (estAllume()) {
         return puissance;
      } else {
         return 0;
      }
   }
   
   /**
    * Retourne la température du moteur qui ne varie pas.
    * @return la température
    */
   @Override
   public int getTemperature() {
      return temperature;
   }
   
   /**
    * @return true si le moteur est allumé, false sinon
    */
   @Override
   public boolean estAllume() {
      return allume;
   }
   
}
