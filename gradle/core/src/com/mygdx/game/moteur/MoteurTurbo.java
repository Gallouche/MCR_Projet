package com.mygdx.game.moteur;

import java.util.Random;

/**
 *
 * @author mathieu
 */
public class MoteurTurbo implements Moteur {
   // Décrit si le moteur est allumé
   private boolean allume;
   // Température du moteur
   private int temperature;
   // Température à l'allumage
   public static final int TEMPERATURE_ALLUMAGE = 40;
   // puissance de base
   private static final int PUISSANCE = 160;
   // Générateur aléatoire
   private final Random rand;
   
   // "Date" en millisecondes du début de récupération d'un turbo
   private long recuperation;
   
   // Temps nécessaire en millisecondes pour récupérer
   private static final int TEMPS_RECUPERATION = 3000; // 3 secondes
   
   /**
    * Constructeur. Initialise les attributs et le générateur aléatoire.
    */
   public MoteurTurbo() {
      allume = false;
      temperature = 0;
      recuperation = 0;
      rand = new Random();
   }
   
   /**
    * Démarrer le moteur. Ne démarre le moteur que si celui-ci n'est pas en
    * train de récupérer d'un turbo.
    */
   @Override
   public void demarrer() {
      if (recuperation == 0) {
         allume = true;
         temperature = TEMPERATURE_ALLUMAGE;
      }
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
    * Calcul de la puissance du moteur. Retourne la valeur de PUISSANCE, avec
    * une probabilité faible de voir cette valeur multipliée par 20. 
    * 
    * Lorsque c'est le cas, le moteur s'éteint et devra attendre un certain temps
    * avant de pouvoir être rallumé.
    * @return la puissance du moteur.
    */
   @Override
   public int getPuissance() {
      // Si le moteur est en train de récupérer, on regarde depuis combien de temps
      if (recuperation != 0) {
         // Temps actuel
         long currentTime = System.currentTimeMillis();
         // Si le temps écoulé est suffisamment grand
         if (currentTime - recuperation >= TEMPS_RECUPERATION) {
            recuperation = 0;
         }
      }
      
      // Si le moteur est éteint, on retourne une puissance de 0
      if (!estAllume()) {
         return 0;
      }
      
      // Calculer la puissance sinon
      int p = PUISSANCE;
      if (rand.nextDouble() < 0.01 * Double.MAX_VALUE) {
         eteindre();
         recuperation = System.currentTimeMillis();
         p *= 20;
      }
      return p;
   }
   
   /**
    * la température du moteur
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
