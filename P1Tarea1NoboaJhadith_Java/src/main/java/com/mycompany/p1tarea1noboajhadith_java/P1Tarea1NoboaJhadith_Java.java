
package com.mycompany.p1tarea1noboajhadith_java;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;

public class P1Tarea1NoboaJhadith_Java {
   static float[] noboaN1 = new float[3];
    static float noboaPromedio = 0, noboaSuma = 0;
    static int opcion;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        noboaMenu();
    }

    public static void noboaMenu() {
        do {
            System.out.println("PROGRAMA PARA EL INGRESO DE SUS TRES NOTAS Y SU PROMEDIO");
            System.out.println("1. Registrar notas");
            System.out.println("2. Promedio de notas");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion del menu: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    noboaIngreso();
                    break;
                case 2:
                    noboaNota();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente nuevamente");
                    break;
            }
        } while (opcion != 3);
    }

    public static void noboaIngreso() {
        System.out.println("Ingrese sus 3 notas");
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            noboaN1[i] = scanner.nextFloat();
            while (noboaN1[i] < 0 || noboaN1[i] > 20) {
                System.out.println("Solo se permiten notas de 0 a 20, vuelva a ingresar");
                noboaN1[i] = scanner.nextFloat();
            }
        }
        System.out.println("Notas ingresadas correctamente");
    }

    public static void noboaNota() {
        noboaSuma = 0;
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
        noboaArchivo();
    }

    public static void noboaArchivo() {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < 3; i++) {
            jsonObject.put("Nota " + (i + 1), noboaN1[i]);
        }
        jsonObject.put("Promedio", noboaPromedio);
        jsonObject.put("Resultado", (noboaPromedio > 14) ? "Aprobado" : "Reprobado");

        try (FileWriter file = new FileWriter("noboaNotas.json")) {
            file.write(jsonObject.toString(4)); // Formatea con sangría de 4 espacios
            System.out.println("Notas registradas en el archivo 'noboaNotas.json'.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo");
            e.printStackTrace();
        }
    }
    
}
