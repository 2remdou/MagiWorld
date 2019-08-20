package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {

    @Test
    public void Given_GuerrierToTheMage_When_attaqueBasique_Then_ReduceLifeGuerrier(){
        Guerrier guerrier = new Guerrier("Joueur 1",10,10,0,0);
        Mage mage = new Mage("Joueur 2",10,0,0,10);
        mage.attaqueBasique(guerrier);
        assertEquals(40,guerrier.getVie());
    }
    @Test
    public void Given_RodeurToTheMage_When_attaqueSpeciale_Then_ReduceLifeRodeur(){
        Rodeur rodeur = new Rodeur("Joueur 1",10,0,10,0);
        Mage mage = new Mage("Joueur 2",10,0,0,10);
        rodeur.attaqueBasique(mage);
        mage.attaqueSpeciale(rodeur);
        assertEquals(50,mage.getVie());
    }
}