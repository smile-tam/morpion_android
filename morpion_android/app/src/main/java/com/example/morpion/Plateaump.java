package com.example.morpion;

public class Plateaump {

    public String[][] tab = new String[3][3];

    public Plateaump() {

    }

    public String[][] getTab() {
        return tab;
    }

    public void setTab(String[][] tab) {
        this.tab = tab;
    }

    public void inittab() {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = " ";
            }
        }
    }

    public void affichertab() {

        for (int i = 0; i < tab.length; i++) {
            if (i==0){
                System.out.println("   0 1 2");
                System.out.print("0 ");
            }
            if (i==1){
                System.out.print("1 ");
            }
            if (i==2){
                System.out.print("2 ");
            }
            System.out.print("|");
            for (int j = 0; j < tab.length; j++) {
                if (j == 1) {
                    System.out.print("|");
                    System.out.print(tab[i][j]);
                    System.out.print("|");
                } else {
                    System.out.print(tab[i][j]);
                }
            }
            System.out.println("|");
        }

    }




}
