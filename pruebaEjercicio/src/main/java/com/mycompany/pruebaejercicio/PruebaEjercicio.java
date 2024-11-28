package com.mycompany.pruebaejercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaEjercicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte option2;
        do {
            System.out.println("1. Student");
            System.out.println("2. Librarian");
            System.out.println("3. Exit");
            option2 = scanner.nextByte();

            switch (option2) {
                case 1:
                    System.out.println("Student");
                    if (enter(scanner)) {
                        menuStudent(scanner); // MENÚ PARA ESTUDIANTES
                    }
                    break;
                case 2:
                    System.out.println("Librarian");
                    if (enter(scanner)) {
                        menuLibrarian(scanner); // MENÚ PARA BIBLIOTECARIOS
                    }
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (option2 != 3);
        scanner.close();
    }

    public static boolean enter(Scanner scanner) {
        byte option;
        String name = "", password = "", nameaux, passwordaux;
        boolean loggedIn = false;

        do {
            System.out.println("1. Sign in");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            option = scanner.nextByte();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.println("Nickname: ");
                    name = scanner.nextLine();
                    System.out.println("Password: ");
                    password = scanner.nextLine();
                    while (password.length() < 8) {
                        System.out.println("Password must have at least 8 characters. Try again:");
                        password = scanner.nextLine();
                    }
                    System.out.println("You've been registered successfully!");
                    break;
                case 2:
                    System.out.println("Log in:");
                    System.out.println("Enter your nickname:");
                    nameaux = scanner.nextLine();
                    System.out.println("Enter your password:");
                    passwordaux = scanner.nextLine();

                    if (nameaux.equals(name) && passwordaux.equals(password)) {
                        System.out.println("You entered successfully!");
                        loggedIn = true;
                    } else {
                        System.out.println("Your credentials don't match. Try again.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return false;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (!loggedIn);
        return true;
    }

    public static void menuStudent(Scanner scanner) {
        byte opt;
        do {
            System.out.println("STUDENT MENU");
            System.out.println("1. List available books");
            System.out.println("2. Borrow books");
            System.out.println("3. Exit");
            opt = scanner.nextByte();
            scanner.nextLine(); // Limpiar buffer

            switch (opt) {
                case 1:
                    Library.listBooks(); // MOSTRAR LIBROS DISPONIBLES
                    break;
                case 2:
                    ArrayList<Library> borrowedBooks = Library.borrowBooks(scanner); // ESTUDIANTE PIDE LIBROS
                    Library.saveCsv("receipts.csv", borrowedBooks); // GUARDAR RECIBO EN CSV
                    break;
                case 3:
                    System.out.println("Exiting student menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (opt != 3);
    }

    public static void menuLibrarian(Scanner scanner) {
        byte opt;
        do {
            System.out.println("LIBRARIAN MENU");
            System.out.println("1. Register Physical Book");
            System.out.println("2. Register Digital Book");
            System.out.println("3. Save books to JSON");
            System.out.println("4. Exit");
            opt = scanner.nextByte();
            scanner.nextLine(); // Limpiar buffer

            switch (opt) {
                case 1:
                    Physical physical = new Physical("", "", "");
                    physical.askBooks();
                    Library.registerBook(physical);
                    break;
                case 2:
                    Digital digital = new Digital("", "", "");
                    digital.askBooks();
                    Library.registerBook(digital);
                    break;
                case 3:
                    Library.saveJson("books.json");
                    break;
                case 4:
                    System.out.println("Exiting librarian menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (opt != 4);
    }
}
