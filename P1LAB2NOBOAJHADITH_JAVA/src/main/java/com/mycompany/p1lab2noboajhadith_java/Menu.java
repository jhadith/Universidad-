
package com.mycompany.p1lab2noboajhadith_java;
import java.util.Scanner;
public class Menu {
    //(int hp, double weight, String name, String color, int capacity)
    //(int year, double weight, String name, String color, String forWho)
    Truck truck = new Truck( 0, 0, "", "", 0);
    Carriage carriage = new Carriage( 0, 0, "", "","");
    byte option;
    Scanner scanner = new Scanner(System.in);
    public void menuEjec(){
      
        do {
            String[] head={"1. Enter info for Truck ", "2. Save info in CSV truck",
                "3. Read info from the truck", "4. Enter info for the carriage",
                "5. Save info in CSV Carriage", "6. Read info from carriage ", "7. Leave the program"};
           for(int i = 0 ; i<7; i++){
               System.out.println(head[i]);
           }
            System.out.println("Enter an option ");
            option = scanner.nextByte();
              
            switch(option){
                case 1:
                    truck.saveInfoArray();
                    break;
                case 2:
                      System.out.println("Enter filename for CSV:");
                    String fileName = scanner.next();
                    truck.saveCsv(fileName);
                    break;
                case 3:
                
                     truck.outInfo(truck.fileAux);
                    break;
                case 4: 
                     carriage.saveInfoArray();
                    break; 
                case 5: 
                    System.out.println("Enter filename for Carriage CSV:");
                String fileNameCarriage = scanner.next();
                carriage.saveCsv(fileNameCarriage);
                    
                    break;
                case 6:
                      carriage.outInfo(carriage.fileAux);
                    break;
                case 7: 
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Enter again");
                    break;      
            } 
        }while(option!=7);
    }
}
