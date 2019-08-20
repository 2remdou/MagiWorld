package com.oc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MagiWorldTest {
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
    public void Given_caracteristique_When_appelleGetCaracteristique_Then_afficheMessage(){
        ByteArrayInputStream input = new ByteArrayInputStream("10\n10\n0\n3\n0\n".getBytes());
        System.setIn(input);
        MagiWorld magiWorld = new MagiWorld();
        Map<String, Integer> caracteristique = magiWorld.getCaracteristique();
        String[] output = outContent.toString().replace("\r\n","\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[4]);
        assertEquals(caracteristique.get("niveau"),caracteristique.get("force")+caracteristique.get("agilite")+caracteristique.get("intelligence"));
    }
    @Test
    public void Given_mauvaisCaracteristique_When_appelleGetCaracteristique_Then_afficheMessageError(){
        System.setIn(new ByteArrayInputStream("10\n5\n0\n3\n5\n".getBytes()));
        MagiWorld magiWorld = new MagiWorld();
        Map<String, Integer> caracteristique = magiWorld.getCaracteristique();
        String[] output = outContent.toString().replace("\r\n","\n").split("\n");
        assertEquals("Veuillez recommencez, la saisie est incorrecte",output[4]);

    }


    @Test
    public void Given_noJoueurToCreationJoueur_When_creationJoueur_Then_creerGuerrier(){
        System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
        MagiWorld magiWorld = new MagiWorld();
        Personnage guerrier = magiWorld.creationPersonnage("Joueur 1");
        String[] output = outContent.toString().replace("\r\n","\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence",
                guerrier.messagePresentation());

    }

}