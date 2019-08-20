package com.oc;

import java.util.Map;

public class Rodeur extends Personnage {
    /**
     * le nom de attaques
     */
    private void setNomAttaque(){
        this.nomAttaqueBasique = "Tir à l’Arc";
        this.nomAttaqueSpeciale = "Concentration";
    }

    public Rodeur(String nomJoueur,int niveau, int force, int agilite, int intelligence) {
        super(nomJoueur,niveau, force, agilite, intelligence);
        this.setNomAttaque();
    }

    public Rodeur(String nomJoueur,Map<String, Integer> caracteristique) {
        super(nomJoueur,caracteristique);
        this.setNomAttaque();
    }

    @Override
    public void attaqueBasique(Personnage personnage) {
        int dommage = this.getAgilite();
        personnage.setVie(personnage.getVie()-dommage);
        this.messageApresAttaque(personnage,this.getNomAttaqueBasique(),dommage);
    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {
        int agilite = this.getNiveau()/2;
        this.setAgilite(this.getAgilite()+agilite);
        System.out.println(this.getNomJoueur()+" gagne "+agilite+" en agilité.");
    }

    @Override
    public String messagePresentation() {
        return "huummmm je suis le rôdeur "+super.messagePresentation();
    }

}
