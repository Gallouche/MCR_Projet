package com.mygdx.game.moteur;

/**
 *
 * @author mathieu
 */
public class MoteurEssence implements Moteur {

   private boolean allume;
   private int temperature;
   private int puissance;
   public static final int MAX_TEMPERATURE = 350;
   public static final int TEMPERATURE_ALLUMAGE = 50;
   private long tempsSurchauffe; // Temps auquel le moteur commence à surhcauffer
   public static final int DUREE_REFROIDISSEMENT = 10; // secondes

   public MoteurEssence() {
      allume = false;
      temperature = 0;
      puissance = 200;
   }

   @Override
   public void demarrer() {
      allume = true;
      temperature = TEMPERATURE_ALLUMAGE;
   }

   @Override
   public void eteindre() {
      allume = false;
      temperature = 0;
   }

   @Override
   public int getPuissance() {
      if (!allume) {
         return 0;
      } else {
         if (temperature <= MAX_TEMPERATURE) {
            if (temperature == MAX_TEMPERATURE) {
               tempsSurchauffe = System.currentTimeMillis();
            }
            ++temperature;
            return puissance;
         } else {
            long tempsCourant = System.currentTimeMillis();
            if ((tempsCourant - tempsSurchauffe) >= DUREE_REFROIDISSEMENT) {
               temperature = TEMPERATURE_ALLUMAGE;
            }
            return (int)(puissance * 0.5);
         }
      }
   }

   @Override
   public int getTemperature() {
      return temperature;
   }

   @Override
   public boolean estAllume() {
      return allume;
   }


}
