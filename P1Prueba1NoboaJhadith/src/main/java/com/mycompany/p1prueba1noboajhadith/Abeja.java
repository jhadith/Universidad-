
package com.mycompany.p1prueba1noboajhadith;
import java.util.Scanner;
public class Abeja extends Animal{
       Scanner scanner = new Scanner(System.in);
    private String caracteristica;

    public Abeja(String nombre, String caracteristica) {
        super(nombre);
        this.caracteristica = caracteristica;
    }
    public String getCaracteristica() {
    return caracteristica;
}

public void setCaracteristica(String caracteristica) {
    this.caracteristica = caracteristica;
}

@Override
public void pedirInfo() {
    System.out.println("Nombre de la abeja:");
    setNombre(scanner.nextLine());
    System.out.println("Caracteristica:");
    setCaracteristica(scanner.nextLine());
}

@Override
public void salirInfo() {
    System.out.println("Nombre: " + getNombre() + " / Caracteristica: " + getCaracteristica());
}
}
