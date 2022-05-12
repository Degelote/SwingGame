/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Combate {

    Scanner reader = new Scanner(System.in);

    public void Combatir(Personaje perIn, Enemigo eneIn) {  //Método combate

        int eleccionPocion;
        while (perIn.vida > 0 && eneIn.vida > 0 && perIn.escapar == false) {

            System.out.println("Opciones:");
            System.out.println("1. Atacar");
            System.out.println("2. Beber pocion");
            System.out.println("3. Huir");

            int eleccion = reader.nextInt();

            switch (eleccion) {
                case 1:

                    eneIn.recibirDaño(perIn.realizarDaño());
                    if (eneIn.getVida() < 0) {
                        break;
                    }
                    perIn.recibirDaño(eneIn.getDañoBasico());
                    break;

                case 2:

                    System.out.println("1.Poción de Vida");
                    System.out.println("2. Poción de Mana");

                    eleccionPocion = reader.nextInt();

                    switch (eleccionPocion) {
                        case 1:
                            perIn.tomarPocionVida();
                            perIn.recibirDaño(eneIn.getDañoBasico());
                            break;

                        case 2:
                            perIn.tomarPocionMana();
                            perIn.recibirDaño(eneIn.getDañoBasico());
                            break;

                    }
                    break;
                case 3:
                    perIn.escapar();
                    break;

            }
        }

        if (eneIn.vida <= 0) {
            eneIn.drop(perIn);
        } else if (perIn.vida <= 0) {
            perIn.muerte();
            System.exit(0);
        }

    }

}
