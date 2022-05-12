/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            File f = new File("FichaPersonaje.txt");
            f.createNewFile();
            Personaje per = new Personaje();
            
            crearPersonaje(per);
            cruceDeCaminos(per);
            

        } catch (IOException e) {
            System.out.println("error: " + e);
        }
    }

    static void crearPersonaje(Personaje perIn) {  //Menú de creación de personajes
        Scanner reader2 = new Scanner(System.in);
        int eleccion, opcionPer;

        System.out.println("Quieres crear un personaje nuevo o cargar uno desde un fichero?");
        System.out.println("1. Crear personaje.");
        System.out.println("2. Cargar personaje.");
        eleccion = reader2.nextInt();

        switch (eleccion) {
            case 1:
                System.out.println("Cual es la clase de tu personaje?");
                System.out.println("1. Guerrero");
                System.out.println("2. Paladin");
                opcionPer = reader2.nextInt();

                switch (opcionPer) {
                    case 1:
                        perIn.rellenarGuerrero();
                        System.out.println("Has creado un guerrero.");
                        perIn.equiparEspada();
                        break;

                    case 2:
                        perIn.rellenarPaladin();
                        System.out.println("Has creado un paladin.");
                        perIn.equiparEspada();
                        break;
                }

                perIn.guardarPersonaje(perIn);
                perIn.getInfoPersonaje();
                break;

            case 2:
                perIn.cargarPersonaje(perIn);
                perIn.getInfoPersonaje();
                break;
        }
    }
    
    static void cruceDeCaminos(Personaje perIn){  //Menú base del juego, aquí es donde vuelves siempre que sales de algo.
        int ending=0;
        Scanner readerCaminos=new Scanner(System.in);
        Mazmorra1 maz1 = new Mazmorra1();
        Pueblo pueblo=new Pueblo();
        
        int eleccionCamino;
        
        
        do{
        
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Te encuentras en un cruce de caminos.");
        System.out.println("1. Ir al norte.");
        System.out.println("2. Ir al sur.");
        System.out.println("3. Ir al este. (Mazmorra1)");
        System.out.println("4. Ir al oeste. (Pueblo)");
        
        eleccionCamino=readerCaminos.nextInt();
        
        switch (eleccionCamino){
            case 1:
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Camino disponible en la versión de pago.");
                break;
            
            case 2:
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Camino disponible en la versión de pago.");
                break;
                
            case 3:
                System.out.println("\n------------------------------------------------------------------\n");
                maz1.setPerMaz1(perIn);
                maz1.puertaExterior();
                maz1.actualizarPer(perIn);
                break;
                
            case 4:
                System.out.println("\n------------------------------------------------------------------\n");
                pueblo.setPerPueblo(perIn);
                pueblo.puertaPrincipal();
                pueblo.actualizarPer(perIn);
                break;
            
        }
        }while(ending==0);
    }

}
