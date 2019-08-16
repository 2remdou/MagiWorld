package com.oc;

public class Rodeur extends Personnage {

    public Rodeur(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.nomAttaqueBasique = "Tir à l’Arc";
        this.nomAttaqueSpeciale = "Concentration";

    }

    @Override
    public void attaqueBasique(Personnage personnage) {

    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {

    }

}
