/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Mazmorra1 {

    Scanner reader = new Scanner(System.in);
    int llaves = 0, maz1Completa = 0;
    boolean derechoVivo = true;
    boolean izquierdoVivo = true;

    Esqueleto esqueletoAnciana = new Esqueleto();
    Esqueleto esqueletoDerecha = new Esqueleto();
    Esqueleto esqueletoIzquierda = new Esqueleto();
    EsqueletoJefe esqueletoAltar = new EsqueletoJefe();
    Combate combateMaz1 = new Combate();
    Personaje perMaz1 = new Personaje();

    public void setPerMaz1(Personaje perIn) {           //Transporta a nuestro personaje a la mazmorra para poder usarlo aquí
        perMaz1.vida = perIn.vida;
        perMaz1.mana = perIn.mana;
        perMaz1.armadura = perIn.armadura;
        perMaz1.dañoBasico = perIn.dañoBasico;
        perMaz1.dañoTotal = perIn.dañoTotal;
        perMaz1.pocionVida = perIn.pocionVida;
        perMaz1.pocionMana = perIn.pocionMana;
        perMaz1.dinero = perIn.dinero;

    }

    public void actualizarPer(Personaje perIn) {
        perIn.vida = perMaz1.vida;
        perIn.mana = perMaz1.mana;
        perIn.armadura = perMaz1.armadura;
        perIn.dañoBasico = perMaz1.dañoBasico;
        perIn.dañoTotal = perMaz1.dañoTotal;
        perIn.pocionVida = perMaz1.pocionVida;
        perIn.pocionMana = perMaz1.pocionMana;
        perIn.dinero = perMaz1.dinero;
        System.out.println("Dineros: " + perMaz1.dinero);
    }

    public void getInfoPersonaje() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Información del personaje:");
        System.out.println("Puntos de vida: " + perMaz1.vida);
        System.out.println("Puntos de mana: " + perMaz1.mana);
        System.out.println("Puntos de armadura: " + perMaz1.armadura);
        System.out.println("Puntos de daño basico: " + perMaz1.dañoBasico);
        System.out.println("Puntos de daño total: " + perMaz1.dañoTotal);
        System.out.println("Pociones de vida: " + perMaz1.pocionVida);
        System.out.println("Pociones de maná: " + perMaz1.pocionMana);

    }
//METODOS NECESARIOS PARA EL MOVIMIENTO EN MAZMORRA_______________________________________________________________________________________________________________________________________________________________
    public void puertaExterior() {

        perMaz1.guardarPersonaje(perMaz1);

        if (maz1Completa == 0) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Te encuentras frente a las puertas de una catedral abandonada.");
            System.out.println("Junto a ella se encuentra una anciana.");
            System.out.println("Que quieres hacer?");
            System.out.println("1. Entrar");
            System.out.println("2. Hablar con la anciana");
            System.out.println("3. Marcharte");

            int puerta = reader.nextInt();

            switch (puerta) {
                case 1:
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("La anciana se convierte en un esqueleto y te impide la entrada.");
                    combateMaz1.Combatir(perMaz1, esqueletoAnciana);
                    System.out.println("Combates contra el esqueleto y lo vences.");
                    System.out.println("");

                    System.out.println("Entras en la catedral.");

                    central();

                    break;
                case 2:
                    hablarAnciana();
                    break;
                case 3:
                    terminar();
                    break;
            }
        } else if (maz1Completa == 1) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Te encuentras frente a las puertas de una catedral abandonada.");
            System.out.println("Ya has vencido a las criaturas que la habitaban y reclamado sus recompensas. No tiene sentido volver a entrar.");
            System.out.println("Te vuelves por el camino por el que has llegado.");
            System.out.println("\n------------------------------------------------------------------\n");
        }

    }

    public void hablarAnciana() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Decides hablar con la anciana.");
        System.out.println("Te advierte de que el edificio esta maldito y deberias marcharte de alli.");
        System.out.println("Que quieres hacer?");
        System.out.println("1. Entrar de todas formas.");
        System.out.println("2. Marcharte.");

        int anciana = reader.nextInt();

        switch (anciana) {
            case 1:
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Ignoras a la anciana e intentas entrar.");
                System.out.println("La anciana se convierte en un esqueleto y te impide la entrada.");
                combateMaz1.Combatir(perMaz1, esqueletoAnciana);
                System.out.println("Combates contra el esqueleto y lo vences.");
                System.out.println("");
                System.out.println("Detrás de la piedra donde se sentaba la anciana ves un par de armas abandonadas.");
                System.out.println("1. Equipar maza");
                System.out.println("2. Equipar martillo");
                System.out.println("3. Mantener el arma que ya llevas.");

                int eleccionArma = reader.nextInt();

                switch (eleccionArma) {
                    case 1:
                        perMaz1.desequiparArma();
                        perMaz1.equiparMaza();
                        System.out.println("Tu ataque total es ahora: " + perMaz1.dañoTotal);
                        break;

                    case 2:
                        perMaz1.desequiparArma();
                        perMaz1.equiparMartillo();
                        System.out.println("Tu ataque total es ahora: " + perMaz1.dañoTotal);
                        break;

                    case 3:
                        break;
                }

                System.out.println("");
                System.out.println("Entras en la catedral.");
                central();
                break;
            case 2:
                terminar();
                break;
        }
    }

    public void central() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Te encuentras en la gran nave central de la catedral.");
        System.out.println("Hay una puerta a cada lado y una gran puerta enfrente, donde deberia estar el altar.");
        System.out.println("Que quieres hacer?");
        System.out.println("1. Usar la puerta central.");
        System.out.println("2. Usar la puerta de la derecha.");
        System.out.println("3. Usar la puerta de la izquierda.");
        System.out.println("4. Usar la puerta por la que has entrado y huir.");

        int central = reader.nextInt();

        switch (central) {
            case 1:

                if (llaves == 2) {
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("Vuelves a la gran puerta central y usas ambas llaves.");

                    altar();
                } else if (llaves == 1) {
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("Vuelves a la gran puerta central pero no puedes abrirla, te falta una llave.");

                    central();

                } else {
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("Intentas utilizar la gran puerta central pero se encuentra cerrada.");
                    System.out.println("Al inspeccionarla, descubres dos pequeñas cerraduras. Quizas las llaves esten en alguna de las salas laterales.");

                    central();

                }
                break;
            case 2:
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Utilizas la puerta de la derecha.");

                derecha();

                break;

            case 3:
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Utilizas la puerta de la izquierda.");

                izquierda();
                break;

            case 4:

                terminar();

                break;

        }
    }

    public void altar() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Cuando entras en la ultima sala te encuentras al jefe de los esqueletos custodiando un cofre.");
        combateMaz1.Combatir(perMaz1, esqueletoAltar);
        System.out.println("Combates contra el y lo vences.");
        System.out.println("");
        System.out.println("Abres el cofre y en el encuentras la Espada Esmeralda. Ahora estas listo para enfrentarte al Señor Oscuro.");
        perMaz1.desequiparArma();
        perMaz1.equiparEspadaEsmeralda();
        System.out.println("Tu ataque total es ahora: " + perMaz1.dañoTotal);
        maz1Completa = 1;
        perMaz1.guardarPersonaje(perMaz1);
        System.out.println("");
        System.out.println("Vuelves a la entrada de la catedral.");
        puertaExterior();

    }

    public void derecha() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Entras en la sala de la derecha.");

        if (derechoVivo == true) {

            System.out.println("En ella, hay un esqueleto con el que combates.");
            combateMaz1.Combatir(perMaz1, esqueletoDerecha);
            System.out.println("Al morir, el esqueleto suelta una llave.");
            System.out.println("Vuelves a la sala central.");
            llaves++;
            derechoVivo = false;
        } else {
            System.out.println("Pero ya has vencido al esqueleto y recogido la llave.");
            System.out.println("Vuelves a la sala central.");
        }
        central();

    }

    public void izquierda() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Entras en la sala de la izquierda.");

        if (izquierdoVivo == true) {
            System.out.println("En ella, hay un esqueleto con el que combates.");
            combateMaz1.Combatir(perMaz1, esqueletoIzquierda);
            System.out.println("Al morir, el esqueleto suelta una llave.");
            System.out.println("Vuelves a la sala central.");
            izquierdoVivo = false;
            llaves++;
        } else {
            System.out.println("Pero ya has vencido al esqueleto y recogido la llave.");
            System.out.println("Vuelves a la sala central.");
        }

        central();

    }

    public void terminar() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Parece que no tienes lo que hay que tener para completar esta aventura.");
        System.out.println("Huyes acobardado por el camino por el que llegaste.");

    }

}
