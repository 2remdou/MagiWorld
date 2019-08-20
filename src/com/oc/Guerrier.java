package com.oc;

import java.util.Map;

public class Guerrier extends Personnage {
    /**
     * le nom de attaques
     */
    private void setNomAttaque(){
        this.nomAttaqueBasique = "Coup d’Épée";
        this.nomAttaqueSpeciale = "Coup de Rage";
    }
    public Guerrier(String nomJoueur,int niveau, int force, int agilite, int intelligence) {
        super(nomJoueur,niveau, force, agilite, intelligence);
        this.setNomAttaque();
    }

    public Guerrier(String nomJoueur,Map<String, Integer> caracteristique) {
        super(nomJoueur,caracteristique);
        this.setNomAttaque();
    }

    @Override
    public void attaqueBasique(Personnage personnage) {
        int dommage = this.getForce();
        personnage.setVie(personnage.getVie()-dommage);
        this.messageApresAttaque(personnage,this.getNomAttaqueBasique(),dommage);
    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {
        int dommage = this.getForce()*2;
        int forceInitiale = this.getForce();
        personnage.setVie(personnage.getVie()-dommage);
        this.setVie(this.getVie()-this.getForce()/2);
        this.messageApresAttaque(personnage,this.getNomAttaqueSpeciale(),dommage);
        System.out.println(this.getNomJoueur()+" perd "+(forceInitiale-(forceInitiale/2))+" points de vie");
        this.controleVie();

    }

    @Override
    public String messagePresentation() {
        return "Woarg je suis le Guerrier "+super.messagePresentation();
    }
}
