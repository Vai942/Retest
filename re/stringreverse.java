package com.re;

import java.util.Scanner;

class Validator {
 public static boolean validate(String name) {
         return name.matches("[a-zA-Z ]+");
 }
}

class Encrypter {
 public String getEncryptedName(String name) {
     if (Validator.validate(name)) {
         StringBuilder reversed = new StringBuilder(name).reverse();
         return reversed.toString().toLowerCase();
     } else {
         throw new IllegalArgumentException("Try again with valid name");
     }
 }
}

public class stringreverse {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     String name = sc.nextLine();
     Encrypter encrypter = new Encrypter();
     
     try {
                 String encryptedName = encrypter.getEncryptedName(name);
         System.out.println(encryptedName);
     } catch (IllegalArgumentException e) {
                 System.out.println(e);
     }
 }
}
