/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1progmain;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;

public class POEPART1PROGMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRegistered = false;

        System.out.println("=== USER REGISTRATION ===");

        while (!isRegistered) {
            System.out.print("Enter your First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter a username (must contain an underscore and be no more than 15 characters): ");
            String username = scanner.nextLine();

            System.out.print("Enter a password (min 8 characters, must contain uppercase letter, number, special character): ");
            String password = scanner.nextLine();

            System.out.print("Enter your South African cell number (e.g., +27831234567): ");
            String cellphone = scanner.nextLine();

            Login user = new Login(username, password, cellphone, firstName, lastName);

            String registrationResult = user.registerUser();
            System.out.println("\n" + registrationResult);

            
            if (user.checkUserName() && user.checkPasswordComplexity() && user.checkCellPhoneNumber()) {
                isRegistered = true;
                System.out.println("\nRegistration successful! You may now log in.\n");
            } else {
                System.out.println("\nRegistration failed. Please try again.\n");
            }
            if (!registrationResult.equals("User registered successfully!")) {
            System.out.println("Registration failed. Please restart and try again.");
            return;
        }

      
        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter your Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String loginPassword = scanner.nextLine();

        boolean success = user.loginUser(loginUsername, loginPassword);
        String loginMsg = user.returnLoginStatus(success);
        System.out.println(loginMsg);

        }

        scanner.close();
    }
}
