package com.mycompany.p1lab1noboajhadith;
import java.util.Scanner;
public class Menu {
     Scanner scanner = new Scanner(System.in);
   Fisico fisico = new Fisico("", 0, "", "", "", ""); 
     Digital digital= new Digital("", "", "", "", "", "");
        //  Fisico fisico1 = new Fisico("", 0, "", "", "", "");
int opcion2, opcion3;
    public void menuA() {
    byte opcion;
        do {
            System.out.println("\n---MENU---");
          String[] encabezado = {"1. Agregar libro fisico (JSON)", "2. Guardar libro fisico (JSON)",
    "3. Leer libros fisicos", "4. Agregar libro digital (CSV)", "5. Guardar libro digital (CSV)",
    "6. Leer libros digitales", "7. Array list FISICOS", "8. Array list DIGITALES", "9. Salir" };

            int i = 0;
            for (i = 0; i < 9; i++) {
                System.out.println(encabezado[i]);

            }
            opcion = scanner.nextByte();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Agregar libro físico (JSON)");
                    
                    fisico.pedirDatos();
                    System.out.println("--------------------------------------------");
                    break;
                case 2:
                    System.out.println("⁠Guardar libro fisico (JSON)");
                   fisico.guardarJson("ARCHIVO DE JSON");
                    System.out.println("LIBRO GUARDADO EN : 'ARCHIVO DE JSON' ");
                    break;
                case 3:
                    System.out.println("⁠Leer libros fisicos");
                   fisico.leer("ARCHIVO DE JSON");
                    break;
                case 4:
                    System.out.println("\n--- Agregar Libro Digital ---");
           digital.pedirDatos();
                    break;
                case 5:
                    System.out.println("\n--- Guardar Libro Digital (CSV) ---");
                    //(String urlDescarga, String formatoArchivo, String repositorio, String titulo, String autor, String isbn)
                    System.out.println("ARCHIVO GUARDADO EN 'archivoCSV'");
                    digital.guardarCsv("archivo.csv");
                    System.out.println("--------------------------------------------");
                    break;
                case 6:
                    System.out.println("\n--- Leer Libros Digitales ---");

                    digital.leer("archivo.csv");
                    break;
                case 7:
                    //NUEVO CODIGO PARA LA IMPLEMENTACION EN MENU DE ARRAY LIST
                    // UN MENU DENTRO DEL MENU PRINCIPAL PARA ELEGIR LEER A COMODIDAD 
                   do{
                       System.out.println("1. Escribir libros, 2. Leer guardados, 3. Salir");
                         opcion3=scanner.nextInt(); 
                         switch(opcion3){
                               case 1:
                                  fisico.guardarLibrosFisicos();
                                     System.out.println("SE HAN GUARDADO LOS LIBROS AUTOMATICAMENTE");
                    System.out.println("Libros guardados en: 'librosListJson'");
                                 break;
                             case 2:
                                   fisico.leerLibrosFisicos();
                                 break;
                             case 3:
                                 System.out.println("Saliendo a menu principal");
                                 break;
                             default:
                                 System.out.println("Ingrese opcion correcta");
                                 break;
                         }
                   }while(opcion3!=3);
                    break;
                case 8:
                //NUEVO CODIGO PARA LA IMPLEMENTACION EN MENU DE ARRAY LIST
                       
                    do{
                        System.out.println("1. Escribir libros, 2. Leer guardados, 3. Salir");
                         opcion2=scanner.nextInt();
                         switch(opcion2){
                             case 1:
                                  digital.guardarLibrosDigitales();
                    System.out.println("SE HAN GUARDADO LOS LIBROS AUTOMATICAMENTE");
                    System.out.println("Libros guardados en: 'librosListJsonD'");
                                 break;
                             case 2:
                                 digital.leer("librosListJsonD");
                                 break;
                             case 3:
                                 System.out.println("Saliendo a menu principal");
                                 break;
                             default:
                                 System.out.println("Ingrese opcion correcta");
                                 break;
                         }
                       }while(opcion2!=3);
                    break;
                case 9:
                     System.out.println("SALIENDO.....");
                    break;
                default:
                    System.out.println("Intente nuevamente");
                    break;
            }
        } while (opcion != 9); 
    }

}
