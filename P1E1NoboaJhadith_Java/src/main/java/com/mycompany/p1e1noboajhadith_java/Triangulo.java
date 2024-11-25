
package com.mycompany.p1e1noboajhadith_java;
import java.util.Scanner;
public class Triangulo {
    Scanner scanner=new Scanner(System.in);
   private double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
 
    //Getter
    public double getBase(){
        return base;
    }
    public double getAltura(){
        return altura;
    }
    
    //setter 
    public void setBase(double base){
        while(base<0 || base >100){
            System.out.println("Ingrese dato valido");
            base=scanner.nextDouble();
            
        }
       this.base=base;
    }
    
    public void setAltura(double altura){
        while(altura<0 || altura>100){
            System.out.println("Ingrese un dato valido");
            altura=scanner.nextDouble();
            
        }
        this.altura=altura;
    }
    //metodo comun para calcular el area 
    
    public double calcularArea(){
        /*
        Para calcular el area ya no se llaman a las variables si no se llaman a los metodos 
        que se han establecido para hacer las operaciones
        
        */
        return (getBase()*getAltura()/2);
        //return (base*altura/2); forma de calcular sin uso de poo
        
    }
    public void ingresarDatos(){
        System.out.println("Ingrese la base para el triangulo");
        setBase (scanner.nextDouble());
        System.out.println("Ingrese altura del triangulo");
        setAltura (scanner.nextDouble());
        
    }
    
  public void mostrarDatos(){
      //cout
      System.out.println("Base"+getBase());
      System.out.println("Altura"+getAltura());
      System.out.println("Area"+calcularArea());
}
  
}
 