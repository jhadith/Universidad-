package com.mycompany.pruebaejercicio;

import java.util.Scanner;

public class Physical extends Library {
    private String dimensions;

    public Physical(String dimensions, String name, String idBook) {
        super(name, idBook);
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public void askBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book name:");
        setName(scanner.nextLine());
        System.out.println("Enter book ID:");
        setIdBook(scanner.nextLine());
        System.out.println("Enter book dimensions:");
        setDimensions(scanner.nextLine());
    }
}
