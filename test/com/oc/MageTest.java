package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {

    @Test
    public void Given_RodeurToTheGuerrier_When_attaqueBasique_Then_ReduceLifeRodeur(){
        Guerrier guerrier = new Guerrier(10,10,0,0);
        Rodeur rodeur = new Rodeur(10,0,0,10);
        guerrier.attaqueBasique(rodeur);
        assertEquals(40,rodeur.getVie());
    }
    @Test
    public void Given_MageToTheGuerrier_When_attaqueSpeciale_Then_ReduceLifeMage(){
        Guerrier guerrier = new Guerrier(10,10,0,0);
        Mage mage = new Mage(10,0,0,10);
        guerrier.attaqueSpeciale(mage);
        assertEquals(30,mage.getVie());
        assertEquals(5,guerrier.getForce());
    }
    @Test
    public void Given_GuerrierToTheRodeur_When_attaqueBasique_Then_ReduceLifeGuerrier(){
        Guerrier guerrier = new Guerrier(10,10,0,0);
        Rodeur rodeur = new Rodeur(10,0,10,0);
        rodeur.attaqueBasique(guerrier);
        assertEquals(40,guerrier.getVie());
    }
    @Test
    public void Given_MageToTheRodeur_When_attaqueSpeciale_Then_ReduceLifeMage(){
        Rodeur rodeur = new Rodeur(10,0,10,0);
        Mage mage = new Mage(10,0,0,10);
        rodeur.attaqueSpeciale(mage);
        assertEquals(15,rodeur.getAgilite());
    }
    @Test
    public void Given_GuerrierToTheMage_When_attaqueBasique_Then_ReduceLifeGuerrier(){
        Guerrier guerrier = new Guerrier(10,10,0,0);
        Mage mage = new Mage(10,0,0,10);
        mage.attaqueBasique(guerrier);
        assertEquals(40,guerrier.getVie());
    }
    @Test
    public void Given_RodeurToTheMage_When_attaqueSpeciale_Then_ReduceLifeRodeur(){
        Rodeur rodeur = new Rodeur(10,0,10,0);
        Mage mage = new Mage(10,0,0,10);
        rodeur.attaqueBasique(mage);
        mage.attaqueSpeciale(rodeur);
        assertEquals(50,mage.getVie());
    }
}