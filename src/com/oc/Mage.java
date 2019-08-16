package com.oc;

public class Mage extends Personnage {

    public Mage(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.nomAttaqueBasique = "Boule de Feu";
        this.nomAttaqueSpeciale = "Soin";
    }

    @Override
    public void attaqueBasique(Personnage personnage) {

    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {

    }

}
