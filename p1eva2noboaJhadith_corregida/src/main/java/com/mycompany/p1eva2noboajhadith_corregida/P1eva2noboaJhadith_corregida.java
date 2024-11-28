package com.mycompany.p1eva2noboajhadith_corregida;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class P1eva2noboaJhadith_corregida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bank> accounts = new ArrayList<>();
        boolean continueRunning = true;

        // Crear cuentas de ejemplo para interacción
        Saves saves = new Saves(0, "User1", 1234567890, 1000);
        Corrient corrient = new Corrient("User2", 1234567891, 2000, 500);
        accounts.add(saves);
        accounts.add(corrient);
          double depositAmount = 0;
        double withdrawAmount = 0;

        while (continueRunning) {
            System.out.println("Select an operation: 1) Deposit 2) Withdraw 3) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1: // Depositar
                    System.out.println("Enter amount to deposit:");
                     depositAmount = scanner.nextDouble();
                    saves.getIn(depositAmount);
                    break;
                case 2: // Retirar
                    System.out.println("Enter amount to withdraw:");
                         withdrawAmount = scanner.nextDouble();
                    saves.getOut(withdrawAmount);
                    break;
                case 3: // Salir
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        // Guardar transacciones en CSV
        try (FileWriter csvWriter = new FileWriter("transactions.csv")) {
            csvWriter.append("Account,Type,Amount\n");
            csvWriter.append(String.format("%d,Deposit,%f\n", saves.getAccount(), depositAmount));
            csvWriter.append(String.format("%d,Withdraw,%f\n", saves.getAccount(), withdrawAmount));
            System.out.println("Transactions saved to CSV file.");
        } catch (IOException e) {
            System.out.println("Failed to save transactions.");
        }

        // Creación de JSON para guardar datos
        JSONObject user = new JSONObject();
        user.put("Name", saves.getName());
        user.put("Account", saves.getAccount());
        user.put("Final Balance", saves.getFinal1());

        // Escribir en archivo JSON
        try (FileWriter file = new FileWriter("user_data.json")) {
            file.write(user.toJSONString());
            System.out.println("User data saved to JSON file.");
        } catch (IOException e) {
            System.out.println("Failed to save user data.");
        }
    }
}
