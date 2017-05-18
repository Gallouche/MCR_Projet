/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heigvd.mcr.carbridge.vehicule.moteur;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathieu
 */
public class MoteurEssenceTest {

   public MoteurEssenceTest() {
   }

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
   }

   @Before
   public void setUp() {
   }

   @After
   public void tearDown() {
   }

   /**
    * Test of demarrer method, of class MoteurEssence.
    */
   @Test
   public void testDemarrer() {
      System.out.println("demarrer");
      MoteurEssence instance = new MoteurEssence();
      instance.demarrer();

      assertTrue(instance.estAllume());
   }

   /**
    * Test of eteindre method, of class MoteurEssence.
    */
   @Test
   public void testEteindre() {
      System.out.println("eteindre");
      MoteurEssence instance = new MoteurEssence();
      instance.demarrer();
      instance.eteindre();

      assertFalse(instance.estAllume());
   }

   /**
    * Test of getPuissance method, of class MoteurEssence.
    */
   @Test
   public void testGetPuissance() {
      System.out.println("getPuissance");
      MoteurEssence instance = new MoteurEssence();
      System.out.println("Moteur éteint doit donner une puissance de 0");
      assertEquals(0, instance.getPuissance());

      System.out.println("Moteur allumé devrait donner une puissance 200");
      instance.demarrer();
      assertEquals(200, instance.getPuissance());

      System.out.println("Après MAX_TEMPERATURE - TEMPERATURE_ALLLUMAGE + 1 tours "
              + "le moteur devrait donner une puissance de 50%");
      int puissance = instance.getPuissance();
      int nbIterations = MoteurEssence.MAX_TEMPERATURE - MoteurEssence.TEMPERATURE_ALLUMAGE - 1;
      for (int i = 1; i <= nbIterations; ++i) {
         instance.getPuissance();
      }
      
      assertEquals((int)(puissance/2.0), instance.getPuissance());
   }

   /**
    * Test of getTemperature method, of class MoteurEssence.
    */
   @Test
   public void testGetTemperature() {
      System.out.println("getTemperature");
      MoteurEssence instance = new MoteurEssence();
      System.out.println("La température doit être 0 quand le moteur est éteint");
      assertEquals(0, instance.getTemperature());
      System.out.println("La température doit être TEMPERATURE_ALLUMAGE après le démarrage");
      instance.demarrer();
      assertEquals(MoteurEssence.TEMPERATURE_ALLUMAGE, instance.getTemperature());
      System.out.println("La température devrait augmenter de 1 à chaque utilisation");
      for (int i = 0; i < MoteurEssence.MAX_TEMPERATURE - MoteurEssence.TEMPERATURE_ALLUMAGE; ++i) {
         instance.getPuissance();
         assertEquals(MoteurEssence.TEMPERATURE_ALLUMAGE + i + 1, instance.getTemperature());
      }
   }

   /**
    * Test of estAllume method, of class MoteurEssence.
    */
   @Test
   public void testEstAllume() {
      System.out.println("estAllume");
      MoteurEssence instance = new MoteurEssence();
      assertFalse(instance.estAllume());
      instance.demarrer();
      assertTrue(instance.estAllume());
      instance.eteindre();
      assertFalse(instance.estAllume());
   }

}
