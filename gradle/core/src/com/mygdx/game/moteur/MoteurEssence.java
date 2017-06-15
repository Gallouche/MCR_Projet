package com.mygdx.game.moteur;

/**
 *
 * @author Mathieu Monteverde
 */
public class MoteurEssence implements Moteur {
   // Décrit si le moteur est allumé.
   private boolean allume;
   // Température actuelle du moteur
   private int temperature;
   // Puissance du moteur
   private int puissance;
   // Température maximum que peut supporter le moteur
   public static final int MAX_TEMPERATURE = 350;
   // Température d'allumage
   public static final int TEMPERATURE_ALLUMAGE = 50;
    // Temps auquel le moteur commence à surhcauffer
   private long tempsSurchauffe;
   // Durée nécessaire pour refroidir le moteur
   public static final int DUREE_REFROIDISSEMENT = 1800; // ms
   
   /**
    * Constructeur
    */
   public MoteurEssence() {
      allume = false;
      temperature = 0;
      puissance = 350;
   }
   
   /**
    * Démarrer le moteur.
    */
   @Override
   public void demarrer() {
      if(!estAllume())
      {

         allume = true;
         temperature = TEMPERATURE_ALLUMAGE;
      }
   }
   
   /**
    * Eteindre le moteur.
    */
   @Override
   public void eteindre() {
      allume = false;
      temperature = 0;
   }

   /**
    * Récupérer la puissance du moteur. Si la température >= à la température 
    * maximum, le moteur donne 10% de la puissance de départ. Si le moteur
    * est éteint, la puissance est de 0.
    * @return la puissance.
    */
   @Override
   public int getPuissance() {
      if (!allume) {
         return 0;
      } else {
         // SI la température est en dessous de la limite.
         if (temperature <= MAX_TEMPERATURE) {
            if (temperature == MAX_TEMPERATURE) {
               tempsSurchauffe = System.currentTimeMillis();
            }
            ++temperature;
            return puissance;
         } else { // Sinon attendre le temps nécessaiire
            long tempsCourant = System.currentTimeMillis();
            if ((tempsCourant - tempsSurchauffe) >= DUREE_REFROIDISSEMENT) {
               temperature = TEMPERATURE_ALLUMAGE;
            }
            return (int)(puissance * 0.2);
         }
      }
   }
   
   /**
    * Retourne la température actuelle du moteur.
    * @return la température.
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
