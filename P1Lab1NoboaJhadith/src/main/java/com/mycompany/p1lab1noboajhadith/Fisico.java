
package com.mycompany.p1lab1noboajhadith;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Fisico extends Libros{
 
  //Fisico fisico = new Fisico("", 0, "", "", "", ""); 

    private String dimensiones, genero;
    private double peso;
    private final Scanner scanner = new Scanner(System.in);
    private JSONObject objectFisico=null;
    
    public Fisico(String dimensiones, double peso, String titulo, String autor, String isbn, String genero) {
        super(titulo, autor, isbn);
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.genero=genero;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        
        while(peso< 0 || peso>100){
            System.out.println("Vuelva a ingresaer");
            peso=scanner.nextDouble();
            
        }
        this.peso = peso;
    }
    
  
public void alquilar(){
    System.out.println("Alquilado con exito");
}
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    //public Libros(String titulo, String autor, String isbn) DATOS QUE SE VAN A HEREDAR
    //  public Fisico(String dimensiones, double peso, String titulo, String autor, String isbn)
    @Override 
       public  void pedirDatos(){
       
           System.out.println("Ingrese el titulo del libro");
           setTitulo(scanner.nextLine());
           System.out.println("Ingrese el autor del libre");
           setAutor(scanner.nextLine());
           System.out.println("Ingrese el codigo del libro");
           setIsbn(scanner.nextLine());
          
           System.out.println("Dimensiones: ");
           setDimensiones(scanner.nextLine());
           System.out.println("Ingrese peso en gramos");
           setPeso(scanner.nextDouble());
           scanner.nextLine();
           System.out.println("Ingrese el genero del libro");
           setGenero(scanner.nextLine());
           
       }
       
       
       @Override
    public void guardarCsv(String fileName){
        /*
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write("Titulo: " +getTitulo());
            bw.write("Autor: "+getTitulo());
            bw.write("ISBN: "+getAutor());
            bw.write("Dimesiones: "+getIsbn());
            bw.write("Genero: "+getDimensiones());
            bw.write("Peso: "+String.valueOf(getPeso()));
            bw.write("Genero: "+getGenero()); 
        }catch(IOException e){
            System.out.println("El archivo no fue guardado");
        }
       */
        //NO ESTA EN USO ESTE METODO
    }
    
   @Override
public void guardarJson (String fileName){
    
        objectFisico=new JSONObject();
        objectFisico.put("Titulo: ", getTitulo());
        objectFisico.put("Autor: ", getAutor());
        objectFisico.put("ISBN: ", getIsbn());
        objectFisico.put("Dimesiones: ", getDimensiones());
        objectFisico.put("Genero: ", getGenero());
        objectFisico.put("Peso: ", String.valueOf(getPeso()));
        try(FileWriter file= new FileWriter(fileName, true)){
            file.write(objectFisico.toJSONString());
            file.flush();
            System.out.println("Libros Guardados cortectamente");
        } catch (IOException e) {
            System.err.println("Error de Guardar el Archivo Json"+e.getMessage());;
        }
    }

    //NUEVO CODIGO PARA ARRAY LIST
   //codigo para guardar arraylist en archivo de json
      private java.util.ArrayList<Fisico> listaFisicos= new java.util.ArrayList<>();
         private int cantLibrosFisicos = 0;
       
  //implementacion de constructor 
    public void Biblioteca(int cantLibrosFisicos ) {
        this.cantLibrosFisicos=cantLibrosFisicos;
    }
    public int getCantLibrosFisicos() {
        return cantLibrosFisicos;
    }

    public void setCantLibrosFisicos(int cantLibrosFisicos) {
        this.cantLibrosFisicos = cantLibrosFisicos;
    }
   //getters y setters aplicados
    // NUEVO CODIGO 
    public void guardarLibrosFisicos() {
        System.out.println("Ingrese la cantidad de libros:");
        do {
            cantLibrosFisicos = scanner.nextInt();
            scanner.nextLine();
            if (cantLibrosFisicos < 1 || cantLibrosFisicos > 3) {
                System.out.println("La cantidad debe estar entre 1 y 3.");
            }
        } while (cantLibrosFisicos < 1 || cantLibrosFisicos > 3);

        for (int i = 0; i < cantLibrosFisicos; i++) {
            Fisico libroFisico = new Fisico("", 0, "", "", "", "");
            libroFisico.pedirDatos();
            libroFisico.guardarJson("librosJSON");
            listaFisicos.add(libroFisico);
        }
    }
    public void leerLibrosFisicos() {
        System.out.println("Leyendo libros desde 'librosJSON'...");
        leer("librosJSON");
    }
}
     // FIN NUEVO CODIGO NUEVO  



