package com.re;
//adder calculator

import java.util.Scanner;

abstract class Calculator {
 
    int add(int a, int b) {
		return 0;
	}protected abstract int add();
 
}

class Adder{
 
    public int add(int a, int b){
 
               System.out.println("Adding integers:" + " " + a + " " + b);
 
               return a + b;
 
    }

}

class Multiplier{
 
    public int  multiply(int a, int b, Adder  calculator){
 
      int temp = a;
 
        for(int i =0; i<b-1; i++) {
 
               temp = calculator.add(temp, a);// 4
 
      }
return temp;
  }
    
public class addermulticalculator {
 
private static final Scanner INPUT_READER = new Scanner(System.in);
 
    private static final    Adder  CALCULATOR = new Adder();
 
   
 
    private static void testAddition(int a, int b) {
 
        System.out.println("Sum = " + CALCULATOR.add(a, b));
 
    }
 
    private static void testMultiplication(int a, int b) {
 
        System.out.println("Product = " + new Multiplier().multiply(a, b, CALCULATOR));
 
    }

    public static void main(String[] args) {
 
    	System.out.println("adder running");
        int a = Integer.parseInt(INPUT_READER.nextLine());
 
        int b = Integer.parseInt(INPUT_READER.nextLine());
System.out.println("Testing Addition");
 
        testAddition(a, b);
System.out.println("\nTesting Multiplication");
 
        testMultiplication(a, b);
 
    }
 
}
}



//package com.re;
//
////Abstract class representing a general calculator
//abstract class Calculator {
// // Abstract method for addition
// abstract int add(int a, int b);
//}
//
////Adder class implementing the add method
//class Adder extends Calculator {
//
// @Override
// public int add(int a, int b) {
//     System.out.println("Adding integers: " + a + " and " + b);
//     return a + b;
// }
//}
//
////Multiplier class to handle multiplication using repeated addition
//class Multiplier {
//
// public int multiply(int a, int b, Adder adder) {
//     int result = 0;
//     for (int i = 0; i < b; i++) {
//         result = adder.add(result, a);
//     }
//     return result;
// }
//}
//
////Solution class to test the Adder and Multiplier functionalities
//public class Solution {
//
// private static final Scanner INPUT_READER = new Scanner(System.in);
// private static final Adder CALCULATOR = new Adder();
//
// // Method to test the addition
// private static void testAddition(int a, int b) {
//     System.out.println("Sum = " + CALCULATOR.add(a, b));
// }
//
// // Method to test the multiplication
// private static void testMultiplication(int a, int b) {
//     Multiplier multiplier = new Multiplier();
//     System.out.println("Product = " + multiplier.multiply(a, b, CALCULATOR));
// }
//
// // Main method to read input and run the tests
// public static void main(String[] args) {
//     System.out.println("Enter two integers:");
//     int a = Integer.parseInt(INPUT_READER.nextLine());
//     int b = Integer.parseInt(INPUT_READER.nextLine());
//
//     System.out.println("Testing Addition");
//     testAddition(a, b);
//
//     System.out.println("\nTesting Multiplication");
//     testMultiplication(a, b);
// }
//}

