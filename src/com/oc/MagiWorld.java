package com.oc;

import java.util.HashMap;
import java.util.Map;

public class MagiWorld {

    /**
     * Crée un personnage
     * @return le personnage crée
     */
    public Personnage creationPersonnage(String nomJoueur){
        String[] personnages = {"Guerrier","Rôdeur","Mage"};
        int noPersonnage = Utilitaire.poserQuestion(personnages,"Veuillez choisir la classe de votre personnage");
        Map<String, Integer> caracteristique = getCaracteristique();
        Personnage personnage=null;
        switch (noPersonnage){
            case 1:
                personnage = new Guerrier(nomJoueur,caracteristique);
                break;
            case 2:
                personnage = new Rodeur(nomJoueur,caracteristique);
                break;
            case 3:
                personnage = new Mage(nomJoueur,caracteristique);
                break;
        }
        return  personnage;
    }

    /**
     * Recupere les caracteristiques d'un personnage
     * @return
     */
    public Map<String, Integer> getCaracteristique(){
        Map<String, Integer> caracteristique = new HashMap<>();
        System.out.println("Niveau du personnage ?");
        int niveau = Utilitaire.getIntInput(1,100);
        caracteristique.put("niveau",niveau);
        System.out.println("Force du personnage ?");
        int force = Utilitaire.getIntInput(0,100);
        caracteristique.put("force",force);
        System.out.println("Agilite du personnage ?");
        int agilite = Utilitaire.getIntInput(0,niveau-force);
        caracteristique.put("agilite",agilite);
        System.out.println("Intelligence du personnage ?");
        int intelligence = Utilitaire.getIntInput(niveau-force-agilite,niveau-force-agilite);
        caracteristique.put("intelligence",intelligence);
        return  caracteristique ;
    }

    public void lancerAttaque(Personnage source,Personnage cible){
        String[] attaques = {"Attaque Basique","Attaque Spéciale"};
        int noAttaque = Utilitaire.poserQuestion(attaques,source.resumePersonnage()+" veuillez choisir votre action");
        switch (noAttaque){
            case 1:
                source.attaqueBasique(cible);
                break;
            case 2:
                source.attaqueSpeciale(cible);
        }

    }

    /**
     *
     */
    public void start(){
        System.out.println("Création du personnage du Joueur 1");
        Personnage joueur1 = this.creationPersonnage("Joueur 1");
        System.out.println(joueur1.messagePresentation());
        System.out.println("Création du personnage du Joueur 2");
        Personnage joueur2 = this.creationPersonnage("Joueur 2");
        System.out.println(joueur2.messagePresentation());
        while (true){
            this.lancerAttaque(joueur1,joueur2);
            if(joueur1.getVie()<=0 || joueur2.getVie()<=0) break;
            this.lancerAttaque(joueur2,joueur1);
            if(joueur1.getVie()<=0 || joueur2.getVie()<=0) break;
        }
        if(joueur1.getVie()<=0) System.out.println(joueur1.getNomJoueur()+" a perdu!");
        else System.out.println(joueur2.getNomJoueur()+" a perdu!");
    }
}
