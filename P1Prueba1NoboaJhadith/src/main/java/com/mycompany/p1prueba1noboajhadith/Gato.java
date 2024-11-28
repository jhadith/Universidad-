
package com.mycompany.p1prueba1noboajhadith;
import java.util.Scanner;
public class Gato extends Animal{
    Scanner scanner = new Scanner(System.in);
    private int comidas;

    // Constructor
    public Gato(String nombre, int comidas) {
        super(nombre);
        this.comidas = comidas;
    }
    // Getter
    public int getComidas() {
        return comidas;
    }
    // Setter
    public void setComidas(int comidas) {
        while (comidas <=0) {
            System.out.println("Nuevo intento:");
            comidas = scanner.nextInt();
        }
        this.comidas = comidas; }
    @Override
    public void pedirInfo() {
        System.out.println("Ingresa nombre:");
        setNombre(scanner.nextLine());
        System.out.println("Cuantas veces come?");
        setComidas(scanner.nextInt());
    }
    @Override
    public void salirInfo() {
        System.out.println("Nombre: " + getNombre() + "/Comidas: " + getComidas());
    } 
}
