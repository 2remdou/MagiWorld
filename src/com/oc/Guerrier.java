package com.oc;

public class Guerrier extends Personnage {

    public Guerrier(int niveau, int force, int agilite, int intelligence) {
        super(niveau, force, agilite, intelligence);
        this.nomAttaqueBasique = "Coup d’Épée";
        this.nomAttaqueSpeciale = "Coup de Rage";
    }

    @Override
    public void attaqueBasique(Personnage personnage) {
        personnage.setVie(personnage.getVie()-this.getForce());
    }

    @Override
    public void attaqueSpeciale(Personnage personnage) {

    }


}
