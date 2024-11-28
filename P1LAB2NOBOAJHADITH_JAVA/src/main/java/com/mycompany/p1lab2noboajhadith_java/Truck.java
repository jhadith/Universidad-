
    package com.mycompany.p1lab2noboajhadith_java;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import org.json.simple.JSONObject;
  import java.util.Scanner;
    public class Truck extends Vehicles {
        //Instanciacion para entradas
         public String fileAux;
        Scanner scanner = new Scanner(System.in);
        private JSONObject truckObject=null;

        //atributos propoios de la clase hija
        private int hp;
        private int capacity; // atributo propio para el metodo propio de la clase

        public Truck(int hp, double weight, String name, String color, int capacity) {
            super(weight, name, color);
            this.hp = hp;
            this.capacity=capacity;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
            while(hp< 150 || hp>1200){
                System.out.println("Please enter a correct value 150-1200");
                hp= scanner.nextInt();

            }
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        //metodo propio, da la capacidad de mezcla de cemento segun los hp que tenga
     public String mixCement() {
        int mixingCapacity = capacity; // Usamos una variable local para determinar la capacidad de mezcla
        if (hp > 200) {
            mixingCapacity = 200; // Si los hp son mayores de 200, establecemos la capacidad de mezcla a 200
        }
        return "The truck can mix " + mixingCapacity + " or more tonaladas of cement";
    }

        @Override 
        public void askInfo() {
        
            System.out.println("Enter the trademark of the truck");
            setName(scanner.nextLine());
            System.out.println("Enter the color of the truck");
            setColor(scanner.nextLine());
            
            System.out.println("Enter the weight in tonaladas");
            setWeight(scanner.nextDouble());
           while(weight <= 1 || weight> 200){
            System.out.println("try again");
            setWeight(scanner.nextDouble());
            
        }
              //scanner.nextLine();
            System.out.println("Enter the horse powers of the truck");
            int hpInput = scanner.nextInt();
            setHp(hpInput);
   
    }
         //METODO PARA GUARDAR INFORMACION EN JSON DESDE UN METODO HEREDADO
        @Override 
        public void saveInfo(String fileName){
           truckObject = new JSONObject ();
           truckObject.put("Trademark is: " , getName());
           truckObject.put("Color ir: ", getColor());
           truckObject.put("Weight: ", getWeight());
           truckObject.put("HP: ", getHp());
           truckObject.put("Mixing capacity: ", mixCement());


           try(FileWriter file= new FileWriter(fileName, true)){
           file.write(truckObject.toJSONString());
                file.flush();
                System.out.println("The information were saved correctly");
            } catch (IOException e) {
                System.err.println("Error, file Json were not saved"+e.getMessage());
            }
           }

        //METODOS PARA GUARDAR LOS DATOS EN ARRAY LIST
         ArrayList<Truck> listTrucks = new ArrayList<>();
            private int numTrucks = 0;
          

          //constructor para numtrucks
          public void truckSave(int numTrucks ){
              this.numTrucks=numTrucks;
          }

        public int getNumTrucks() {
            return numTrucks;
        }

        public void setNumTrucks(int numTrucks) {
            this.numTrucks = numTrucks;
        }
   public String getFileAux() {
        return fileAux;
    }

    public void setFileAux(String fileAux) {
        this.fileAux = fileAux;
    }

         public void saveInfoArray(){

            System.out.println("Enter the cant of trucks");
            numTrucks = scanner.nextInt();
            while(numTrucks<= 0 || numTrucks> 3){
                System.out.println("Enter again");
                numTrucks = scanner.nextInt();  
            }
                 scanner.nextLine();//limpiar linea vacia

             System.out.println("Enter a name for the file");
             System.out.println("If you wanna save your info in a file that already ");
             System.out.println("exists establish the same name ");
             
           fileAux= scanner.nextLine();
            for(int i = 0 ; i<numTrucks; i++){
                askInfo();
                saveInfo(fileAux);
                listTrucks.add(this);

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
    String header = "Trademark,Color,Weight,HP,Mixing capacity\n";
    String data = String.format(
        "%s,%s,%s,%s,%s\n",
        getName(), 
        getColor(),  
        getWeight(),  
        getHp(),  
        mixCement()  
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
    
    
       
    
       
       
    

 


    
    



