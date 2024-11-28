
package com.mycompany.p1lab2noboajhadith_java;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Vehicles {
    Scanner scanner = new Scanner(System.in);
    public double weight;
    public String name;
    public String color;

    public Vehicles(double weight, String name, String color) {
        this.weight = weight;
        this.name = name;
        this.color = color;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
     
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public abstract void askInfo();
    public abstract void saveInfo(String fileName);
    public abstract void outInfo(String fileName);
    public abstract void saveCsv(String fileName);
    
    public void read(String fileName){
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error something went wrong" + e.getMessage());

        }
    
    }
}
