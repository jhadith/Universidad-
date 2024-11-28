package com.mycompany.pruebaejercicio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Library {
    protected static ArrayList<Library> books = new ArrayList<>(); // LISTA COMPARTIDA ENTRE TODOS LOS LIBROS
    protected String name;
    protected String idBook;

    // BLOQUE ESTÁTICO PARA CARGAR LIBROS INICIALES
    static {
        books.add(new Physical("8x11 inches", "Introduction to Java", "ID001"));
        books.add(new Physical("7x10 inches", "Data Structures", "ID002"));
        books.add(new Digital("PDF", "Algorithms", "ID003"));
        books.add(new Physical("6x9 inches", "Operating Systems", "ID004"));
        books.add(new Digital("EPUB", "Computer Networks", "ID005"));
    }

    public Library(String name, String idBook) {
        this.name = name;
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    // MÉTODO PARA GUARDAR LIBROS EN JSON
    public static void saveJson(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("[\n");
            for (int i = 0; i < books.size(); i++) {
                Library book = books.get(i);
                writer.write("  {\n");
                writer.write("    \"name\": \"" + book.getName() + "\",\n");
                writer.write("    \"idBook\": \"" + book.getIdBook() + "\"\n");
                writer.write("  }");
                if (i < books.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
            System.out.println("Books saved to JSON successfully!");
        } catch (IOException e) {
            System.out.println("Error saving books to JSON: " + e.getMessage());
        }
    }

    // MÉTODO PARA GUARDAR RECIBOS EN CSV
    public static void saveCsv(String fileName, ArrayList<Library> borrowedBooks) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (Library book : borrowedBooks) {
                writer.write(book.getName() + "," + book.getIdBook() + "\n");
            }
            System.out.println("Receipt saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving receipt to CSV: " + e.getMessage());
        }
    }

    // MÉTODO PARA LISTAR LIBROS DISPONIBLES
    public static void listBooks() {
        System.out.println("Available books:");
        for (int i = 0; i < books.size(); i++) {
            Library book = books.get(i);
            System.out.println((i + 1) + ". Name: " + book.getName() + ", ID: " + book.getIdBook());
        }
    }

    // MÉTODO PARA QUE EL ESTUDIANTE PIDA LIBROS
    public static ArrayList<Library> borrowBooks(Scanner scanner) {
        ArrayList<Library> borrowedBooks = new ArrayList<>();
        listBooks();
        System.out.println("Enter the number of books you want to borrow:");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter the index of the book you want to borrow:");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpiar buffer
            if (index >= 0 && index < books.size()) {
                borrowedBooks.add(books.remove(index)); // REMOVER LIBRO DE LA LISTA Y AÑADIR A PRESTADOS
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Invalid index, try again.");
            }
        }
        return borrowedBooks;
    }

    // MÉTODO PARA REGISTRAR LIBROS
    public static void registerBook(Library book) {
        books.add(book);
        System.out.println("Book registered successfully!");
    }

    // MÉTODO ABSTRACTO PARA SER IMPLEMENTADO POR SUBCLASES
    public abstract void askBooks();
}
