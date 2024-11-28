package com.mycompany.pruebaejercicio;

import java.util.Scanner;

public class Digital extends Library {
    private String format;

    public Digital(String format, String name, String idBook) {
        super(name, idBook);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void askBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book name:");
        setName(scanner.nextLine());
        System.out.println("Enter book ID:");
        setIdBook(scanner.nextLine());
        System.out.println("Enter book format (e.g., PDF, EPUB):");
        setFormat(scanner.nextLine());
    }
}
