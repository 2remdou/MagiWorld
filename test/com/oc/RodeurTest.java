package com.oc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodeurTest {

    @Test
    public void Given_GuerrierToTheRodeur_When_attaqueBasique_Then_ReduceLifeGuerrier(){
        Guerrier guerrier = new Guerrier("Joueur 1",10,10,0,0);
        Rodeur rodeur = new Rodeur("Joueur 2",10,0,10,0);
        rodeur.attaqueBasique(guerrier);
        assertEquals(40,guerrier.getVie());
    }
    @Test
    public void Given_MageToTheRodeur_When_attaqueSpeciale_Then_ReduceLifeMage(){
        Rodeur rodeur = new Rodeur("Joueur 1",10,0,10,0);
        Mage mage = new Mage("Joueur 2",10,0,0,10);
        rodeur.attaqueSpeciale(mage);
        assertEquals(15,rodeur.getAgilite());
    }
}