
package com.mycompany.p1tarea1noboajhadith_java;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class P1Tarea1NoboaJhadith_Java {
    static float[] noboaN1 = new float[3];
    static float noboaPromedio = 0, noboaSuma = 0;

    public static void main(String[] args) {
        noboaIngreso();
    }
    public static void noboaIngreso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PROGRAMA PARA EL INGRESO DE SUS TRES NOTAS Y SU PROMEDIO");
        System.out.println("Ingrese sus 3 notas");

        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            noboaN1[i] = scanner.nextFloat();

            while (noboaN1[i] < 0 || noboaN1[i] > 20) {
                System.out.println("Solo se permiten notas de 0 a 20, vuelva a ingresar");
                noboaN1[i] = scanner.nextFloat();
            }
        }
        scanner.close();

        noboaNota();
        noboaArchivo();
    }

    public static void noboaNota() {
        for (int i = 0; i < 3; i++) {
            noboaSuma += noboaN1[i];
        }
        noboaPromedio = noboaSuma / 3;
        System.out.println("Su promedio es: " + noboaPromedio);

        if (noboaPromedio > 14) {
            System.out.println("Usted ha sido aprobado");
        } else {
            System.out.println("Ha sido reprobado");
        }
    }

    public static void noboaArchivo() {
        try (FileWriter archivo = new FileWriter("noboaNotas.txt")) {
            for (int i = 0; i < 3; i++) {
                archivo.write("Nota " + (i + 1) + ": " + noboaN1[i] + "\n");
            }
            archivo.write("------------------------------\n");
            archivo.write("Promedio: " + noboaPromedio + "\n");

            if (noboaPromedio > 14) {
                archivo.write("Resultado: Aprobado\n");
            } else {
                archivo.write("Resultado: Reprobado\n");
            }

            System.out.println("Notas registradas en el archivo 'noboaNotas.txt'.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        }
    }
    
}
