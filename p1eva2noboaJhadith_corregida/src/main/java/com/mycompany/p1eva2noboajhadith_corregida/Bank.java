package com.mycompany.p1eva2noboajhadith_corregida;

public abstract class Bank {
    protected String name;
    protected int account;
    protected double final1;

    public Bank(String name, int account, double final1) {
        this.name = name;
        this.account = account;
        this.final1 = final1;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAccount() { return account; }
    public void setAccount(int account) { this.account = account; }
    public double getFinal1() { return final1; }
    public void setFinal1(double final1) { this.final1 = final1; }

    public abstract void getIn(double amount);
    public abstract void getOut(double amount);
}
