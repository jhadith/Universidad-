package com.mycompany.p1lab1noboajhadith;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Libros {
//ATRIBUTOS PROPIOS
    private String titulo;
    private String autor;
    private String isbn;

    public Libros(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
//METODOS ABSTRACTOS
    public abstract void pedirDatos();
    public abstract void guardarCsv(String fileName);
    public abstract void guardarJson(String fileName);
   // public abstract void alquilar();

    public void leer(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el mensaje" + e.getMessage());

        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
