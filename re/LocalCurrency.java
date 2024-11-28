package com.re;  // Ensure this matches your directory structure
 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
 
public class LocalCurrency {
 
    // Method for adding a double (local currency) and a String (foreign currency)
	 public String rate(double localCurrency, String foreignCurrency) {
	        String formattedLocalCurrency;
	        
	        // Check if the double value is a whole number (no decimal part)
	        if (localCurrency == Math.floor(localCurrency)) {
	            // Format as an integer (no decimal places)
	            formattedLocalCurrency = String.valueOf((int) localCurrency);
	        } else {
	            // Format with two decimal places
	            formattedLocalCurrency = String.format("%.2f", localCurrency);
	        }
 
	        return formattedLocalCurrency + foreignCurrency;
	    }
 
    // Method for adding two double values (local and foreign currencies)
    public String rate(double localCurrency, double foreignCurrency) {
        // Calculate the sum
        double sum = localCurrency + foreignCurrency;
        
        // Use BigDecimal for precise rounding to two decimal places with HALF_UP rounding
        BigDecimal roundedSum = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
        
        // Convert BigDecimal to a string
        String result = roundedSum.stripTrailingZeros().toPlainString();
        
        // Ensure at least one decimal place
        if (result.indexOf('.') == -1 || result.endsWith(".")) {
            result += ".0";
        }
        
        return result;
    }
 
    public String rate(String localCurrency, String foreignCurrency) {
        return localCurrency + foreignCurrency;
    }
 
    public static void main(String[] args) {
        // Create a scanner object for reading input from the user
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        LocalCurrency currencyConverter = new LocalCurrency();
 
        //System.out.print("Enter the number of test cases: ");
        int testCases = Integer.parseInt(scanner.nextLine());
 
        for (int i = 1; i <= testCases; i++) {
            //System.out.println("\nTest case #" + i);
 
            // Prompt user for first input
            //System.out.print("Enter the first value (local currency): ");
            String input1 = scanner.nextLine();
 
            // Prompt user for second input
            //System.out.print("Enter the second value (foreign currency): ");
            String input2 = scanner.nextLine();
 
            boolean isInput1Double = isDouble(input1);
            boolean isInput2Double = isDouble(input2);
 
            // Decide which overloaded method to call based on input types
            String result;
            if (isInput1Double && isInput2Double) {
                // Both inputs are doubles
                result = currencyConverter.rate(Double.parseDouble(input1), Double.parseDouble(input2));
            } else if (isInput1Double) {
                // First input is double, second is String
                result = currencyConverter.rate(Double.parseDouble(input1), input2);
            } else if (isInput2Double) {
                // Second input is double, first is String
                result = currencyConverter.rate(input1, input2);
            } else {
                // Both inputs are strings
                result = currencyConverter.rate(input1, input2);
            }
 
            //System.out.println("Result: " + result);
            System.out.println(result);
        }
 
 
        scanner.close();
    }
 
    // Helper method to check if a string can be parsed as a double
    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}