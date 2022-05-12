/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author Lorenzo
 */
public abstract class Enemigo {

    int vida;
    int mana;
    int armadura;
    int dañoBasico;
    int dañoTotal;
    int pocionVida;
    int pocionMana;
    
    //MECANICAS(Nombres descriptivos para no comentar)_______________________________________________________________________________________________________________________________

    public int recibirDaño(int recibirIn) {

        
        int dañoReal=recibirIn-armadura;
        System.out.println("El enemigo recibe " + dañoReal + " puntos de daño.");
        vida = vida - dañoReal;
        System.out.println("Le quedan " + vida + " puntos de vida.");
        return vida;

    }

    public int calcularDaño(int dañoArma) {
        dañoTotal = dañoBasico + dañoArma;
        return dañoTotal;
    }

    public int realizarDaño() {
        return dañoTotal;
    }

    public void tomarPocionVida() {
        if (pocionVida > 0) {
            vida = vida + 25;
            pocionVida--;
            System.out.println("El enemigo ha tomado una pocion de vida y ha recuperado 25 puntos");
            System.out.println("Ahora tiene " + vida + " puntos de vida.");
        } else {
            System.out.println("No le quedan pociones de vida.");
        }
    }

    public void tomarPocionMana() {
        if (pocionMana > 0) {
            mana = mana + 25;
            pocionMana--;
            System.out.println("El enemigo ha tomado una pocion de mana y ha recuperado 25 puntos");
            System.out.println("Ahora tiene " + mana + " puntos de mana.");
        } else {
            System.out.println("No le quedan pociones de mana.");
        }
    }
    
    public abstract void drop(Personaje perIn);

    public void muerte() {
        System.out.println("El enemigo se ha quedado sin puntos de vida y ha muerto.");
    }
    
    
    //GETTERS-SETTERS__________________________________________________________________________________________________________________________________

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getArmadura() {
        return armadura;
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
