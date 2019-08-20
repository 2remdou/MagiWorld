package com.oc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitaireTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }
    @Test
    public void Given_listePersonnage_When_appellePoserQuestion_Then_afficheTextCorrect(){
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        String[] personnages = {"Guerrier","Rôdeur","Mage"};
        Utilitaire.poserQuestion(personnages,"Veuillez choisir la classe de votre personnage");
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Veuillez choisir la classe de votre personnage(1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n",output);
    }
    @Test
    public void Given_mauvaisChoix_When_appellePoserQuestion_Then_appelleEncorePoserQuestion(){
        System.setIn(new ByteArrayInputStream("4\n2\n".getBytes()));
        String[] personnages = {"Guerrier","Rôdeur","Mage"};
        Utilitaire.poserQuestion(personnages,"Veuillez choisir la classe de votre personnage");
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[1]);
    }
    @Test
    public void Given_mauvaiseValeur_When_appelleGetIntInput_Then_afficheError(){
        System.setIn(new ByteArrayInputStream("15\n0\n".getBytes()));
        Utilitaire.getIntInput(0,10);
        String[] output = outContent.toString().replace("\r\n","\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[0]);
    }
}