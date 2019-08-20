package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    @Test
    public void Given_RodeurToTheGuerrier_When_attaqueBasique_Then_ReduceLifeRodeur(){
        Guerrier guerrier = new Guerrier("Joueur 1",10,10,0,0);
        Rodeur rodeur = new Rodeur("Joueur 2",10,0,0,10);
        guerrier.attaqueBasique(rodeur);
        assertEquals(40,rodeur.getVie());
    }
    @Test
    public void Given_MageToTheGuerrier_When_attaqueSpeciale_Then_ReduceLifeMage(){
        Guerrier guerrier = new Guerrier("Joueur 1",10,10,0,0);
        Mage mage = new Mage("Joueur 2",10,0,0,10);
        guerrier.attaqueSpeciale(mage);
        assertEquals(30,mage.getVie());
        assertEquals(45,guerrier.getVie());
    }
}