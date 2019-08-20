package com.oc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaire {
    static Scanner sc = new Scanner(System.in);

    /**
     * Afficher une liste de choix
     * @param choix la liste des choix
     * @param message le message à afficher
     * @return le choix
     */
    public static int poserQuestion(String[] choix,String message){
        String texte = "(";
        for(int i=0;i<=choix.length-1;i++){
            texte +=(i+1)+" : " + choix[i] + ", ";
        }
        texte = texte.substring(0,texte.length()-2);
        texte += ")";
        System.out.println(message+texte);
        return getIntInput(1,choix.length);
    }

    /**
     *
     * @param min la valeur minimale
     * @param max la valeur maximal
     * @return la saisie
     */
    public static int getIntInput(int min,int max){
        int input = -1;
        boolean isNotValid = false;
        do {
            try {
                input = sc.nextInt();
                isNotValid = (input<min || input>max);
            }catch (InputMismatchException e){
                isNotValid = true;
                sc.next();
            }
            if(isNotValid) {
                System.out.println("Veuillez recommencez, la saisie est incorrecte");
            }
        }while (isNotValid);
        return input;
    }
}
