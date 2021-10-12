package com.example.morpion;

import java.util.Scanner;

public class Morpion {

    // attribut

    int t = 1;
    Plateaump plateau;

    //constructeur
    public Morpion() {
        plateau = new Plateaump();
        plateau.inittab();
    }

    //getter setter

    //methodes
    public boolean cochercase(String s) {
        boolean cocher=false;

        int coupx = Integer.parseInt(s.substring(1,2));
        int coupy = Integer.parseInt(s.substring(0,1));
        if (verifcoup(coupx, coupy)){
            cocher = true;
            t = t + 1;
        }

        return cocher;
    }


    public boolean verifcoup(int x, int y) {
        boolean verif=false;

        if (plateau.getTab()[y][x].equals(" ")) {

            if (t % 2 == 1) {
                plateau.getTab()[y][x] = "X";
            } else {
                plateau.getTab()[y][x] = "O";
            }
            verif = true;
        }
        return verif;
    }

    public int win() {

        int ligne = 0;
        int ligne1 = 0;
        int win=0;

// lignes horizontale

        for (int i = 0; i < 3; i++) {
            if (ligne == 3 || ligne1 == 3) {

            } else {
                ligne = 0;
                ligne1 = 0;
                for (int j = 0; j < 3; j++) {
                    if (plateau.getTab()[i][j] == "X") {
                        ligne = ligne + 1;
                    }
                    if (plateau.getTab()[i][j] == "O") {
                        ligne1 = ligne1 + 1;
                    }
                    if (ligne == 3) {
                        win= 1;
                    }
                    if (ligne1 == 3) {
                        win= 1;
                    }

                }
            }
        }

// lignes verticale

        ligne = 0;
        ligne1 = 0;

        for (int j = 0; j < 3; j++) {
            if (ligne == 3 || ligne1 == 3) {

            } else {
                ligne = 0;
                ligne1 = 0;
                for (int i = 0; i < 3; i++) {
                    if (plateau.getTab()[i][j] == "X") {
                        ligne = ligne + 1;
                    }
                    if (plateau.getTab()[i][j] == "O") {
                        ligne1 = ligne1 + 1;
                    }
                    if (ligne == 3) {
                        win= 1;
                    }
                    if (ligne1 == 3) {
                        win= 1;
                    }

                }


            }
        }

// diagonales

        ligne = 0;
        ligne1 = 0;

//diagonales hautg a basd
        for (int j = 0; j < 3; j++) {

            if (plateau.getTab()[j][j]=="X"){
                ligne=ligne+1;
            }
            if (plateau.getTab()[j][j]=="O"){
                ligne1=ligne1+1;
            }
        }

        if (ligne == 3) {
            win= 1;
        }
        if (ligne1 == 3) {
            win= 1;
        }

//diagonales hautg a basg

        ligne = 0;
        ligne1 = 0;

        if(plateau.getTab()[2][0]=="X"){
            ligne=ligne+1;
        }
        if(plateau.getTab()[2][0]=="O"){
            ligne1=ligne1+1;
        }
        if(plateau.getTab()[1][1]=="X"){
            ligne=ligne+1;
        }
        if(plateau.getTab()[1][1]=="O"){
            ligne1=ligne1+1;
        }
        if(plateau.getTab()[0][2]=="X"){
            ligne=ligne+1;
        }
        if(plateau.getTab()[0][2]=="O"){
            ligne1=ligne1+1;
        }

        if (ligne == 3) {
            win= 1;
        }
        if (ligne1 == 3) {
            win= 1;
        }

        //egalité

        if(win==0 && t==10){
            win=2;
        }
        if(win == 1 || win ==2){
            t=1;
        }

        return win;
    }

    public void restart(){
        plateau.inittab();
        t=1;
    }



}

