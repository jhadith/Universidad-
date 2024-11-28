package com.mycompany.p1eva2noboajhadith_corregida;

public class Corrient extends Bank {
    private double sobe;

    public Corrient(String name, int account, double final1, double sobe) {
        super(name, account, final1);
        this.sobe = sobe;
    }

    @Override
    public void getIn(double amount) {
        this.final1 += amount; // Agrega el monto al saldo final
        System.out.println("Deposited: " + amount + ". New balance: " + this.final1);
    }

    @Override
    public void getOut(double amount) {
        if (amount <= this.final1 + this.sobe) { // Verifica contra el saldo más el sobregiro
            this.final1 -= amount;
            System.out.println("Withdrawn: " + amount + ". Remaining balance: " + this.final1);
        } else {
            System.out.println("Insufficient funds including overdraft protection.");
        }
    }

    public double getSobe() { return sobe; }
    public void setSobe(double sobe) { this.sobe = Math.min(sobe, 1000); } // Límite de sobregiro
}
