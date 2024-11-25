
package com.mycompany.p1e1noboajhadith_java;

import java.util.Scanner;

public class Rectangulo {
   
    Scanner entrada= new Scanner(System.in);
    
  public double base=0.0, altura=0.0;
  
  public Rectangulo(double base, double altura ){
      this.altura=altura;
      this.base=base;
        
  }
    
  public  double getBase(){
      return base;
  }
  public double getAltura(){
      return altura;
  }  
   
  
    
}
