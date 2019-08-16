package com.oc;

public abstract class Personnage {
    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;
    private int vie;
    protected String nomAttaqueBasique;
    protected String nomAttaqueSpeciale;

    public Personnage(int niveau, int force, int agilite, int intelligence) {
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.vie = this.niveau * 5;
    }

    public abstract void attaqueBasique(Personnage personnage);
    public abstract void attaqueSpeciale(Personnage personnage);

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
}
