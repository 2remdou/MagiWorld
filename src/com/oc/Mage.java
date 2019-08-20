package com.oc;

import java.util.Map;

public class Mage extends Personnage {

    private int vieInitiele;
    /**
     * le nom de attaques
     */
    private void setNomAttaque(){
        this.nomAttaqueBasique = "Boule de Feu";
        this.nomAttaqueSpeciale = "Soin";
    }
    public Mage(String nomJoueur,int niveau, int force, int agilite, int intelligence) {
        super(nomJoueur,niveau, force, agilite, intelligence);
        this.setNomAttaque();
        this.vieInitiele = this.getVie();
    }

    public Mage(String nomJoueur,Map<String, Integer> caracteristique) {
        super(nomJoueur,caracteristique);
        this.setNomAttaque();
        this.vieInitiele = this.getVie();
    }

    @Override
    public void attaqueBasique(Personnage personnage) {
        int dommage = this.getIntelligence();
        personnage.setVie(personnage.getVie()-dommage);
        this.messageApresAttaque(personnage,this.getNomAttaqueBasique(),dommage);
    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {
        int vie = (this.getVie() + this.getIntelligence()*2)> this.vieInitiele ?
                this.vieInitiele - this.getVie() :
                this.getIntelligence()*2;
        this.setVie(this.getVie()+vie);
        System.out.println(this.getNomJoueur()+" utilise "+this.getNomAttaqueSpeciale()+" et gagne "+vie+" en vitalité.");
    }
    @Override
    public String messagePresentation() {
        return "Abracadabra je suis le Mage "+super.messagePresentation();
    }

}
