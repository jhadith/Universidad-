
package com.mycompany.p1eva2noboajhadith_corregida;


public class Saves extends Bank {
    private double more;

    public Saves(double more, String name, int account, double final1) {
        super(name, account, final1);
        this.more = more;
    }

    @Override
    public void getIn(double amount) {
        this.final1 += amount; // Agrega el monto al saldo final
        System.out.println("Deposited: " + amount + ". New balance: " + this.final1);
    }

    @Override
    public void getOut(double amount) {
        if (amount <= this.final1) {
            this.final1 -= amount; // Resta el monto del saldo final
            System.out.println("Withdrawn: " + amount + ". Remaining balance: " + this.final1);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getMore() { return more; }
    public void setMore(double more) { this.more = more; }
}