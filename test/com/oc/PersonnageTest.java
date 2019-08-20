package com.oc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {
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
    public void Given_mageAuGuerrier_When_messageApresAttaque_Then_afficherMessage(){
        Guerrier guerrier = new Guerrier("Joueur 1",10,10,0,0);
        Mage mage = new Mage("Joueur 2",10,0,0,10);
        guerrier.messageApresAttaque(mage,guerrier.getNomAttaqueBasique(),10);
        String output = outContent.toString().replace("\r\n","\n");
        assertEquals("Joueur 1 utilise Coup d’Épée et inflige 10 dommages.\n" +
                "Joueur 2 perd 10 points de vie\n",output);
    }
}