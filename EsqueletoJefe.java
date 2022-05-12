/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class EsqueletoJefe extends Enemigo {

    public EsqueletoJefe() {
        super.vida = 50;
        super.mana = 0;
        super.armadura = 0;
        super.dañoBasico = 15;
        super.pocionVida = 2;
        super.pocionMana = 0;

    }

    @Override
    public void drop(Personaje perIn) {  //Sistema de drops
        Scanner reader = new Scanner(System.in);
        int eleccionArma;
        int randomDrop = (int) Math.floor(Math.random() * 100);

        if (randomDrop < 60) {
        } else if (randomDrop < 85 && randomDrop >= 60) {
            int dropDinero = (int) Math.floor(Math.random() * 15 + 1);
            System.out.println("");
            System.out.println("Al morir, el enemigo suelta: " + dropDinero + " Dineros.");
            perIn.dinero = perIn.dinero + dropDinero;
            System.out.println("Ahora tienes: " + perIn.dinero + " Dineros.");
        } else if (randomDrop < 95 && randomDrop >= 85) {

            int dropPocion = (int) Math.floor(Math.random() * 2);
            switch (dropPocion) {
                case 0:
                    System.out.println("");
                    System.out.println("Al morir, el enemigo suelta una poción de vida.");
                    perIn.pocionVida++;
                    System.out.println("Pociones de vida: " + perIn.pocionVida);
                    break;

                case 1:
                    System.out.println("");
                    System.out.println("Al morir, el enemigo suelta una poción de mana.");
                    perIn.pocionMana++;
                    System.out.println("Pociones de mana: " + perIn.pocionMana);
                    break;

            }

        } else {
            int dropArma = (int) Math.floor(Math.random() * 3);
            switch (dropArma) {
                case 0:
                    System.out.println("Al morir, el enemigo suelta un martillo. Quieres equiparlo?");
                    System.out.println("1. Si");
                    System.out.println("2. No, mantener el arma actual.");
                    eleccionArma = reader.nextInt();
                    switch (eleccionArma) {
                        case 0:
                            perIn.desequiparArma();
                            perIn.equiparMartillo();
                            break;

                        case 1:
                            break;
                    }

                case 1:
                    System.out.println("Al morir, el enemigo suelta una maza. Quieres equiparla?");
                    System.out.println("1. Si");
                    System.out.println("2. No, mantener el arma actual.");
                    eleccionArma = reader.nextInt();
                    switch (eleccionArma) {
                        case 0:
                            perIn.desequiparArma();
                            perIn.equiparMaza();
                            break;

                        case 1:
                            break;
                    }

                case 2:
                    System.out.println("Al morir, el enemigo suelta una espada. Quieres equiparla?");
                    System.out.println("1. Si");
                    System.out.println("2. No, mantener el arma actual.");
                    eleccionArma = reader.nextInt();
                    switch (eleccionArma) {
                        case 0:
                            perIn.desequiparArma();
                            perIn.equiparEspada();
                            break;

                        case 1:
                            break;
                    }

            }

        }
    }

}
