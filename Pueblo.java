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
public class Pueblo {

    Scanner reader = new Scanner(System.in);

    int eleccionPueblo, eleccionMercado, eleccionArmas, eleccionArmaduras, eleccionPociones, eleccionMonturas;

    Combate combatePueblo = new Combate();
    Personaje perPueblo = new Personaje();

    public void setPerPueblo(Personaje perIn) {   //Transporta a nuestro personaje al pueblo, para poder usarlo aquí.
        perPueblo.vida = perIn.vida;
        perPueblo.mana = perIn.mana;
        perPueblo.armadura = perIn.armadura;
        perPueblo.dañoBasico = perIn.dañoBasico;
        perPueblo.dañoTotal = perIn.dañoTotal;
        perPueblo.pocionVida = perIn.pocionVida;
        perPueblo.pocionMana = perIn.pocionMana;
        perPueblo.dinero = perIn.dinero;

    }

    public void actualizarPer(Personaje perIn) {
        perIn.vida = perPueblo.vida;
        perIn.mana = perPueblo.mana;
        perIn.armadura = perPueblo.armadura;
        perIn.dañoBasico = perPueblo.dañoBasico;
        perIn.dañoTotal = perPueblo.dañoTotal;
        perIn.pocionVida = perPueblo.pocionVida;
        perIn.pocionMana = perPueblo.pocionMana;
        perIn.dinero = perPueblo.dinero;
    }

    public void getInfoPersonaje() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Información del personaje:");
        System.out.println("Puntos de vida: " + perPueblo.vida);
        System.out.println("Puntos de mana: " + perPueblo.mana);
        System.out.println("Puntos de armadura: " + perPueblo.armadura);
        System.out.println("Puntos de daño basico: " + perPueblo.dañoBasico);
        System.out.println("Puntos de daño total: " + perPueblo.dañoTotal);
        System.out.println("Pociones de vida: " + perPueblo.pocionVida);
        System.out.println("Pociones de maná: " + perPueblo.pocionMana);
        System.out.println("Dineros: " + perPueblo.dinero);
    }

    public void puertaPrincipal() {                                      //Menú de todas las cosas que tiene el pueblo
        perPueblo.guardarPersonaje(perPueblo);
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Te encuentras en la puerta principal del pueblo.");
        System.out.println("Existen varios lugares de interes:");
        System.out.println("1. Taberna");
        System.out.println("2. Plaza del mercado.");
        System.out.println("3. Salir del pueblo.");

        eleccionPueblo = reader.nextInt();

        switch (eleccionPueblo) {
            case 1:
                taberna();
                break;
            case 2:
                mercado();
                break;

            case 3:
                break;
        }
    }

    public void mercado() {         //Menú de compra en el mercado
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Te encuentras en la plaza del pueblo. Se está celebrando un mercado.");
        System.out.println("Te fijas en varios mercaderes interesantes:");
        System.out.println("1. Hablar con el mercader de armas.");
        System.out.println("2. Hablar con el mercader de armaduras.");
        System.out.println("3. Hablar con el mercader de pociones.");
        System.out.println("4. Hablar con el mercader de monturas.");
        System.out.println("5. Visitar la taberna.");
        System.out.println("6. Volver a la puerta principal del pueblo.");

        eleccionMercado = reader.nextInt();

        switch (eleccionMercado) {

            case 1:
                mercaderArmas();
                break;

            case 2:
                mercaderArmaduras();
                break;
            case 3:
                mercaderPociones();
                break;
            case 4:
                mercaderMonturas();
                break;
            case 5:
                taberna();
                break;
            case 6:
                puertaPrincipal();
                break;

        }

    }

    public void taberna() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Llegas a la puerta de la principal taberna del pueblo.");
    }

    public void mercaderArmas() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Ojeas los productos del mercader.");
        System.out.println("1. Comprar martillo. (30 Dineros)");
        System.out.println("2. Comprar maza. (30 Dineros)");
        System.out.println("3. Comprar mandoble. (40 Dineros)");
        System.out.println("4. Comprar palo (3 Dineros)");
        System.out.println("5. Salir");
        eleccionArmas = reader.nextInt();

        switch (eleccionArmas) {
            case 1:
                perPueblo.desequiparArma();
                perPueblo.equiparMartillo();
                System.out.println("Tu ataque total es ahora: " + perPueblo.dañoTotal);
                perPueblo.dinero = perPueblo.dinero - 30;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 2:
                perPueblo.desequiparArma();
                perPueblo.equiparMaza();
                System.out.println("Tu ataque total es ahora: " + perPueblo.dañoTotal);
                perPueblo.dinero = perPueblo.dinero - 30;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 3:
                perPueblo.desequiparArma();
                perPueblo.equiparMandoble();
                System.out.println("Tu ataque total es ahora: " + perPueblo.dañoTotal);
                perPueblo.dinero = perPueblo.dinero - 40;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 4:
                perPueblo.desequiparArma();
                perPueblo.equiparPalo();
                System.out.println("Tu ataque total es ahora: " + perPueblo.dañoTotal);
                perPueblo.dinero = perPueblo.dinero - 3;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 5:
                System.out.println("Dejas el puesto.");
                break;
        }

        mercado();
    }

    public void mercaderArmaduras() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Ojeas los productos del mercader.");
        System.out.println("1. Comprar armadura de cuero. (50 Dineros)");
        System.out.println("2. Comprar armadura de acero. (90 Dineros)");
        System.out.println("3. Salir");
        eleccionArmaduras = reader.nextInt();

        switch (eleccionArmaduras) {
            case 1:
                perPueblo.desequiparArmadura();
                perPueblo.equiparCuero();
                System.out.println("Tu indice de armadura es ahora de: " + perPueblo.armadura);
                perPueblo.dinero = perPueblo.dinero - 50;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 2:
                perPueblo.desequiparArmadura();
                perPueblo.equiparAcero();
                System.out.println("Tu indice de armadura es ahora de: " + perPueblo.armadura);
                perPueblo.dinero = perPueblo.dinero - 90;
                System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                break;
            case 3:
                System.out.println("Dejas el puesto.");
                break;
        }
        mercado();
    }

    public void mercaderPociones() {

        do {

            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Ojeas los productos del mercader.");
            System.out.println("1. Comprar poción de vida. (20 Dineros)");
            System.out.println("2. Comprar poción de mana. (20 Dineros)");
            System.out.println("3. Abandonar el puesto.");

            eleccionPociones = reader.nextInt();

            switch (eleccionPociones) {
                case 1:
                    System.out.println("Compras un poción de vida.");
                    perPueblo.dinero = perPueblo.dinero - 20;
                    perPueblo.pocionVida++;
                    System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                    break;
                case 2:
                    System.out.println("Compras un poción de mana.");
                    perPueblo.dinero = perPueblo.dinero - 20;
                    perPueblo.pocionMana++;
                    System.out.println("Te quedan: " + perPueblo.dinero + " Dineros.");
                    break;
                case 3:
                    System.out.println("Dejas el puesto.");
                    break;

            }
        } while (eleccionPociones != 3);

        mercado();
    }

    public void mercaderMonturas() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Ojeas los productos del mercader.");
        mercado();
    }

}
