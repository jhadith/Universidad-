
package com.mycompany.p1prueba1noboajhadith;

public abstract class Animal {
      // Constructor
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos abstractos
    public abstract void pedirInfo();
    public abstract void salirInfo();
}
