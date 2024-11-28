
package com.mycompany.p1lab2noboajhadith_java;
import java.util.Scanner;
 import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import org.json.simple.JSONObject;

public class Carriage extends Vehicles {
     public String fileAux;//variable en donde se guardara el nombre para el archivo
    Scanner scanner = new Scanner(System.in);
    private int year;
    private String forWho;
    private JSONObject carriageObject=null;
    
    public Carriage(int year, double weight, String name, String color, String forWho) {
        super(weight, name, color);
        this.year = year;
        this.forWho=forWho;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        while(year<1920 || year>2024 ){
            System.out.println("Please, enter a correct year");
            year=scanner.nextInt();
            
        }
    }

    public String getForWho() {
        return forWho;
    }

    public void setForWho(String forWho) {
        this.forWho = forWho;
    }
    
    //A PESAR DE QUIEN INGRESE SEA CUALQUIERA SE ADVIERTE QUE SOLO PUEDE USAR USADO POR LA REALEZA
    public String who(){
         return "The carriage can be only used for the majesty";
    }
    
    @Override 
    public void askInfo(){
        //(int year, double weight, String name, String color)
         System.out.println("Enter the name of the carriage");
        setName(scanner.nextLine());
        System.out.println("Enter the  principal color of the carriage");
        setColor(scanner.nextLine());
        System.out.println("Enter the weight of the carriage");
        setWeight(scanner.nextDouble());
        while(weight< 1000 || weight> 10000){
            System.out.println("Enter again");
               setWeight(scanner.nextDouble()); 
        }
        
        scanner.nextLine();
        System.out.println("Enter who will use the carriage");
        setForWho(scanner.nextLine());
    }
    
    @Override 
    public void saveInfo(String fileName){
        carriageObject = new JSONObject();
        carriageObject.put("Name: ", getName());
       carriageObject.put("Color: ", getColor());
       carriageObject.put("Weight: ", getWeight());
       carriageObject.put("Who uses: ", getForWho());
         carriageObject.put("",who());
         
         try(FileWriter file= new FileWriter(fileName, true)){
           file.write(carriageObject.toJSONString());
                file.flush();
                System.out.println("The information were saved correctly");
            } catch (IOException e) {
                System.err.println("Error, file Json were not saved"+e.getMessage());;
            }
         
    }
    
    //METODOS PARA GUARDAR LOS DATOS EN ARRAY LIST
         ArrayList<Carriage> listCarriage = new ArrayList<>();
            private int numCarriage = 0;
          

          //constructor para numtrucks
          public void carriageSave(int numCarriage ){
              this.numCarriage=numCarriage;
          }

        public int getNumCarriage() {
            return numCarriage;
        }

        public void setNumCarriage(int numCarriage) {
            this.numCarriage = numCarriage;
        }
   public String getFileAux() {
        return fileAux;
    }

    public void setFileAux(String fileAux) {
        this.fileAux = fileAux;
    }
         public void saveInfoArray(){

            System.out.println("Enter the cant of Carriages");
            numCarriage = scanner.nextInt();
            while(numCarriage<= 0 || numCarriage> 3){
                System.out.println("Enter again");
                numCarriage = scanner.nextInt();  
            }
                 scanner.nextLine();//limpiar linea vacia
             System.out.println("Enter a name for the file");
             System.out.println("If you wanna save your info in a file that already ");
             System.out.println("exists establish the same name ");
             
           fileAux= scanner.nextLine();
            for(int i = 0 ; i<numCarriage; i++){
                askInfo();
                saveInfo(fileAux);
                listCarriage.add(this);

            }
             System.out.println("Your file were saved on: "+fileAux);
             
         }
    @Override 
    public void outInfo(String fileName){
        System.out.println("Enter the name of the file");
                fileAux= scanner.nextLine();
               System.out.println("Reading the file ' "+fileAux+"'");
               read(fileAux); 
    }
    
     @Override
public void saveCsv(String fileName) {
    // Crear el contenido en formato CSV
    String header = "Name,Color,Weight,Who uses\n";
    String data = String.format(
        "%s,%s,%s,%s\n",
        getName(), 
        getColor(),  
        getWeight(), 
        getForWho()  
    );

    // Escribir el contenido en el archivo CSV
    try (FileWriter file = new FileWriter(fileName, true)) {  // Usamos true para append al archivo existente
        file.write(header + data);
        file.flush();
        System.out.println("The CSV information was saved correctly.");
    } catch (IOException e) {
        System.err.println("Error, the CSV file was not saved: " + e.getMessage());
    }
}
         
    
}
