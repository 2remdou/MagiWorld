package com.oc;

import java.util.HashMap;
import java.util.Map;

public abstract class Personnage {
    private String nomJoueur;
    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;
    private int vie;
    protected String nomAttaqueBasique;
    protected String nomAttaqueSpeciale;

    public Personnage(String nomJoueur,int niveau, int force, int agilite, int intelligence) {
        this.nomJoueur = nomJoueur;
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.vie = this.niveau * 5;
    }

    public Personnage(String nomJoueur,Map<String, Integer> caracteristique){
        this.nomJoueur = nomJoueur;
        this.niveau = caracteristique.get("niveau");
        this.force = caracteristique.get("force");
        this.agilite = caracteristique.get("agilite");
        this.intelligence = caracteristique.get("intelligence");
        this.vie = this.niveau * 5;
    }

    public abstract void attaqueBasique(Personnage personnage);
    public abstract void attaqueSpeciale(Personnage personnage);

    /**
     * Affiche les messsages après une attaque
     * @param cible la cible de l'attaque
     * @param nomAttaque le nom de l'attaque
     * @param dommage le dommage infligé
     */
    public void messageApresAttaque(Personnage cible,String nomAttaque,int dommage){
        System.out.println(this.getNomJoueur()+" utilise "+this.getNomAttaqueBasique()+" et inflige "+dommage+" dommages.");
        System.out.println(cible.getNomJoueur()+" perd "+dommage+" points de vie");
        cible.controleVie();
    }

    public void controleVie(){
        if(this.getVie()<=0){
            System.out.println(this.getNomJoueur()+" est mort");
        }
    }

    /**
     * Presenter le joueur
     * @return
     */
    public String messagePresentation(){
        return this.nomJoueur+" niveau "+this.niveau+" je possède "+this.vie+" de vitalité, "+this.force+" de force, "+this.agilite+
                " d'agilité et "+this.intelligence+ " d'intelligence";
    }

    /**
     * Affiche la situation du joueur, après une attaque
     * @return
     */
    public String resumePersonnage(){
        return this.nomJoueur+" ("+this.vie+" Vitalité)";
    }


    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getNomAttaqueBasique() {
        return nomAttaqueBasique;
    }

    public String getNomAttaqueSpeciale() {
        return nomAttaqueSpeciale;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }
}
