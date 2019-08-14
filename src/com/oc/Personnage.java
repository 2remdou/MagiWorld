package com.oc;

public abstract class Personnage {
    private int niveau;
    private int force;
    private int agilite;
    private int intelligence;

    public abstract String nomAttaqueBasique();
    public abstract String nomAttaqueSpeciale();
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

}
