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
public class Personaje {

    int vida;
    int mana;
    int armadura;
    int dañoBasico;
    int dañoTotal;
    int pocionVida;
    int pocionMana;
    int dinero;
    boolean escapar = false;

    //CREACIÓN DE PERSONAJE______________________________________________________________________________________________________________________________________________________
    public void rellenarGuerrero() {
        vida = 170;
        mana = 0;
        armadura = 0;
        dañoBasico = 10;
        pocionVida = 2;
        pocionMana = 0;
        dinero = 100;
    }

    public void rellenarPaladin() {
        vida = 240;
        mana = 0;
        armadura = 0;
        dañoBasico = 8;
        pocionVida = 3;
        pocionMana = 0;
        dinero = 100;
    }
    
    public void rellenarFisico() {
        vida = 100;
        mana = 80;
        armadura = 0;
        dañoBasico = 6;
        pocionVida = 3;
        pocionMana = 2;
        dinero = 100;
    }
    
    public void rellenarArcanista() {
        vida = 100;
        mana = 100;
        armadura = 0;
        dañoBasico = 7;
        pocionVida = 3;
        pocionMana = 2;
        dinero = 100;
    }
    
    public void rellenarFrancotirador() {
        vida = 150;
        mana = 40;
        armadura = 0;
        dañoBasico = 17;
        pocionVida = 3;
        pocionMana = 1;
        dinero = 100;
    }
    
     public void rellenarHokage() {
        vida = 200;
        mana = 50;
        armadura = 0;
        dañoBasico = 13;
        pocionVida = 3;
        pocionMana = 1;
        dinero = 100;
    }
    
     public void rellenarFutbolista() {
        vida = 140;
        mana = 70;
        armadura = 0;
        dañoBasico = 21;
        pocionVida = 3;
        pocionMana = 2;
        dinero = 100;
    }
    
     public void rellenarInvocador() {
        vida = 120;
        mana = 90;
        armadura = 0;
        dañoBasico = 8;
        pocionVida = 3;
        pocionMana = 3;
        dinero = 100;
    } 
   

    //ESTADISTICAS-GUARDADO-CARGA_________________________________________________________________________________________________________________________________________________
    public void getInfoPersonaje() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Información del personaje:");
        System.out.println("Puntos de vida: " + vida);
        System.out.println("Puntos de mana: " + mana);
        System.out.println("Puntos de armadura: " + armadura);
        System.out.println("Puntos de daño basico: " + dañoBasico);
        System.out.println("Puntos de daño total: " + dañoTotal);
        System.out.println("Pociones de vida: " + pocionVida);
        System.out.println("Pociones de maná: " + pocionMana);
        System.out.println("Dineros: " + dinero);

    }

    public void guardarPersonaje(Personaje perIn) {  //Método GUARDAR
        try {
            File f = new File("FichaPersonaje.txt");
            f.createNewFile();
            Scanner reader = new Scanner(f);
            FileWriter fw = new FileWriter(f);

            Personaje per = new Personaje();
            per.rellenarGuerrero();

            //Se introducen los datos en el fichero.
            fw.write(perIn.vida + ";");
            fw.write(perIn.mana + ";");
            fw.write(perIn.armadura + ";");
            fw.write(perIn.dañoBasico + ";");
            fw.write(perIn.dañoTotal + ";");
            fw.write(perIn.pocionVida + ";");
            fw.write(perIn.pocionMana + ";");
            fw.write(perIn.dinero + ";");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void cargarPersonaje(Personaje perIn) {  //Metodo CARGAR

        try {
            int vida = 0;
            int mana = 0;
            int armadura = 0;
            int dañoBasico = 0;
            int dañoTotal = 0;
            int pocionVida = 0;
            int pocionMana = 0;
            int dinero = 0;

            File f = new File("FichaPersonaje.txt");
            Scanner reader = new Scanner(f);

            String[] datos = new String[0];
            while (reader.hasNextLine()) {
                datos = (reader.nextLine()).split(";");
            }

            perIn.vida = Integer.parseInt(datos[0]);
            perIn.mana = Integer.parseInt(datos[1]);
            perIn.armadura = Integer.parseInt(datos[2]);
            perIn.dañoBasico = Integer.parseInt(datos[3]);
            perIn.dañoTotal = Integer.parseInt(datos[4]);
            perIn.pocionVida = Integer.parseInt(datos[5]);
            perIn.pocionMana = Integer.parseInt(datos[6]);
            perIn.dinero = Integer.parseInt(datos[7]);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    //MECÁNICAS____(Nombres descriptivos)_____________________________________________________________________________________________________________________________________________________________________
    public boolean escapar() {
        System.out.println("Huyes del combate.");
        escapar = true;
        return escapar;
    }

    public int recibirDaño(int recibirIn) {
        System.out.println("\n------------------------------------------------------------------\n");
        int dañoReal = recibirIn - armadura;
        System.out.println("Recibes " + dañoReal + " puntos de daño.");
        vida = vida - dañoReal;
        System.out.println("Te quedan " + vida + " puntos de vida.");

        System.out.println("\n------------------------------------------------------------------\n");
        return vida;

    }

    public int realizarDaño() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Realizas un ataque provocando " + dañoTotal + " puntos de daño.");

        return dañoTotal;

    }

    public void tomarPocionVida() {
        if (pocionVida > 0) {
            vida = vida + 30;
            pocionVida--;
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Has tomado una pocion de vida y has recuperado 25 puntos");
            System.out.println("Ahora tienes " + vida + " puntos de vida.");

        } else {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("No te quedan pociones de vida.");

        }
    }

    public void tomarPocionMana() {
        if (pocionMana > 0) {
            mana = mana + 30;
            pocionMana--;
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Has tomado una pocion de mana y has recuperado 25 puntos");
            System.out.println("Ahora tienes " + mana + " puntos de mana.");

        } else {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("No te quedan pociones de mana.");

        }
    }

    public void muerte() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Te has quedado sin puntos de vida y has muerto.");
        System.out.println("--GAME OVER--");

    }

    //INVENTARIO__________________________________________________________________________________________________________________________________________________________________
    public void equiparEspada() {
        dañoTotal = dañoBasico + 20;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas una espada");

    }

    public void equiparMandoble() {
        dañoTotal = dañoBasico + 30;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un mandoble");

    }

    public void equiparPalo() {
        dañoTotal = dañoBasico + 10;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un palo");

    }

    public void equiparMaza() {
        dañoTotal = dañoBasico + 15;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas una maza");
    }

    public void equiparMartillo() {
        dañoTotal = dañoBasico + 25;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un martillo");
    }

    public void equiparEspadaEsmeralda() {
        dañoTotal = dañoBasico + 100;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas la espada esmeralda.");
    }

    public void equiparCuero() {
        armadura = armadura + 5;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te vistes con armadura de cuero.");
    }

    public void equiparAcero() {
        armadura = armadura + 10;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te vistes con armadura de acero.");
    }

    public void equiparRunica() {
        armadura = armadura + 20;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te vistes con armadura rúnica.");
    }
    
    public void equiparKunai(){
        dañoTotal = dañoBasico + 30;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un Kunai");
    }
    
    public void equiparBalon(){
        dañoTotal = dañoBasico + 50;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un balón");
    }
    
    public void equiparBallista(){
        dañoTotal = dañoBasico + 60;
        System.out.println("------------------------------------------------------------------");
        System.out.println("Te equipas un Ballista del Call of Duty");
    }

    public void desequiparArma() {
        dañoTotal = 0;
    }

    public void desequiparArmadura() {
        armadura = 0;
    }

    //GETTERS-SETTERS_________________________________________________________________________________________________________________________________________________________________
    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setEscapar(boolean escapar) {
        this.escapar = escapar;
    }

    public int getPocionVida() {
        return pocionVida;
    }

    public void setPocionVida(int pocionVida) {
        this.pocionVida = pocionVida;
    }

    public int getPocionMana() {
        return pocionMana;
    }

    public void setPocionMana(int pocionMana) {
        this.pocionMana = pocionMana;
    }

    public int getDañoBasico() {
        return dañoBasico;
    }

    public int getDañoTotal() {
        return dañoTotal;
    }

}
