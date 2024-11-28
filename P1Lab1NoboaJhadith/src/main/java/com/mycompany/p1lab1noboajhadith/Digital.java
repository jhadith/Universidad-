
package com.mycompany.p1lab1noboajhadith;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Digital extends Libros {
 // Digital digital= new Digital("", "", "", "", "", "");
    private String urlDescarga, formatoArchivo, repositorio;
    private Scanner scanner = new Scanner(System.in);
    public Digital(String urlDescarga, String formatoArchivo, String repositorio, String titulo, String autor, String isbn) {
        super(titulo, autor, isbn);
        this.urlDescarga = urlDescarga;
        this.formatoArchivo = formatoArchivo;
        this.repositorio = repositorio;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    public String getFormatoArchivo() {
        return formatoArchivo;
    }

    public void setFormatoArchivo(String formatoArchivo) {
        this.formatoArchivo = formatoArchivo;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }
    
    
    public void descargar(){
        System.out.println("Se ha descargado exitosamente");
        
    }
    //    public Digital(String urlDescarga,
    //String formatoArchivo, String repositorio, String titulo, String autor, String isbn)
    @Override
       public  void pedirDatos(){
           System.out.println("Ingrese el titulo del libro");
           setTitulo(scanner.nextLine());
           System.out.println("Ingrese el autor del libro");
           setAutor(scanner.nextLine());
           System.out.println("Ingrese el codigo del libro");
           setIsbn(scanner.next());
           scanner.nextLine();
           System.out.println("Ingrese el url de descarga");
           setUrlDescarga(scanner.nextLine());
           System.out.println("Ingrese el formato del archivo");
           setFormatoArchivo(scanner.nextLine());
           System.out.println("Ingrese el repositorio donde esta el libro gratis");
           setRepositorio(scanner.nextLine());  
       }
       @Override
    public void guardarCsv(String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write(getTitulo());
            bw.write(getAutor());
            bw.write(getIsbn());
            bw.write(getUrlDescarga());
            bw.write(getFormatoArchivo());
            bw.write(getRepositorio());
        }catch(IOException e){
            System.out.println("El archivo no fue guardado");
        }
        
    }
       @Override
  public void guardarJson(String fileName) {
    JSONObject objectDigital = new JSONObject();
    objectDigital.put("Título", getTitulo());
    objectDigital.put("Autor", getAutor());
    objectDigital.put("ISBN", getIsbn());
    objectDigital.put("URL de Descarga", getUrlDescarga());
    objectDigital.put("Formato de Archivo", getFormatoArchivo());
    objectDigital.put("Repositorio", getRepositorio());

    try (FileWriter file = new FileWriter(fileName, true)) {
        file.write(objectDigital.toJSONString() + System.lineSeparator());
        file.flush();
        System.out.println("Libro guardado correctamente en " + fileName);
    } catch (IOException e) {
        System.err.println("Error al guardar el archivo JSON: " + e.getMessage());
    }
}
   
   //NUEVO CODIGO PARA ARRAY LIST DE LIBROS DIGITALES
   //codigo para guardar arraylist en archivo de json
     private java.util.ArrayList<Digital> listaDigitales = new java.util.ArrayList<>();
         private int cantLibrosDigitales = 0;
         //implementacion de constructor 
         public void Biblioteca2( int cantLibrosDigitales){
             this.cantLibrosDigitales=cantLibrosDigitales;   
         }
            public int getCantLibrosDigitales() {
        return cantLibrosDigitales;
    }

    public void setCantLibrosDigitales(int cantLibrosDigitales) {
        this.cantLibrosDigitales = cantLibrosDigitales;
    }
    //getters y setters aplicados
 public void guardarLibrosDigitales() {
    do {
      
        System.out.println("Ingrese la cantidad de libros para digitales (entre 1 y 3):");
        cantLibrosDigitales = scanner.nextInt();

    } while (cantLibrosDigitales < 1 || cantLibrosDigitales > 3);

    for (int i = 0; i < cantLibrosDigitales; i++) {
        Digital nuevoDigital = new Digital("", "", "", "", "", "");
        nuevoDigital.pedirDatos();
        nuevoDigital.guardarJson("librosListJsonD");
        listaDigitales.add(nuevoDigital);
    }

    System.out.println("SE HAN GUARDADO LOS LIBROS AUTOMATICAMENTE");
}
    
    public void leerLibrosDigitales(){
        leer("librosListJsonD");
    }
}
