package com.re;

//Personalloan
import java.util.Scanner;

interface Bank {
	void assignLoans(int[] loans);
    void averageLoan();
    void maxLoan();
    void minLoan();
}

abstract class LoanDept implements Bank {
    protected int[] loanAmounts;

      public void assignLoans(int[] loans) {
        int lengthToAssign = Math.min(loans.length, loanAmounts.length);
        for (int i = 0; i < lengthToAssign; i++) {
            loanAmounts[i] = loans[i];
        }
        System.out.println("Loans for " + (loanAmounts.length == 1 ? "client" : "clients") + " processed");
    }

    public void averageLoan() {
        double sum = 0;
        int loanCount = 0;
        for (int loan : loanAmounts) {
            sum += loan;
            if (loan > 0) {
                loanCount++;
            }
        }

        if (loanCount == 0) {
            System.out.println("Average loan amount is 0.00");
        } else {
            double average = sum / loanAmounts.length;
            System.out.println(String.format("Average loan amount is %.2f", average));
        }
    }

       public void maxLoan() {
        if (loanAmounts.length == 0) {
            System.out.println("No loans available");
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int loan : loanAmounts) {
            max = Math.max(max, loan);
        }
        System.out.println("Maximum loan amount is " + max);
    }

       public void minLoan() {
        if (loanAmounts.length == 0) {
            System.out.println("No loans available");
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int loan : loanAmounts) {
            min = Math.min(min, loan);
        }
        System.out.println("Minimum loan amount is " + min);
    }
}

class PersonalLoanDept extends LoanDept {
    public PersonalLoanDept(int clients) {
        loanAmounts = new int[clients];
    }
    
    @Override
    public void assignLoans(int[] loans) {
        super.assignLoans(loans);
    }

    @Override
    public void maxLoan() {
        super.maxLoan();
    }
    @Override
    public void minLoan() {
        super.minLoan();
    }
}
class BusinessLoanDept extends LoanDept {
    public BusinessLoanDept(int businesses) {
        loanAmounts = new int[businesses]; 
    }

    @Override
    public void assignLoans(int[] loans) {
        super.assignLoans(loans);
    }
    @Override
    public void minLoan() {
        super.minLoan();
    }
}

public class personalloan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of clients and businesses
        //System.out.println("Enter number of clients and businesses:");
        String[] count = sc.nextLine().split(" ");
        int clients = Integer.parseInt(count[0]);
        int businesses = Integer.parseInt(count[1]);
        
        // Create instances of PersonalLoanDept and BusinessLoanDept
        PersonalLoanDept personalLoanDept = new PersonalLoanDept(clients);  // Example with `clients` number of clients
        BusinessLoanDept businessLoanDept = new BusinessLoanDept(businesses); // Example with `businesses` number of businesses

        // Input client loans
        //System.out.println("Enter loan amounts for clients:");
        count = sc.nextLine().split(" ");
        int[] clientLoans = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            clientLoans[i] = Integer.parseInt(count[i]);
        }
        personalLoanDept.assignLoans(clientLoans);

        // Input business loans
        //System.out.println("Enter loan amounts for businesses:");
        count = sc.nextLine().split(" ");
        int[] businessLoans = new int[count.length];
        for (int i = 0; i < count.length; i++) {
            businessLoans[i] = Integer.parseInt(count[i]);
        }
        businessLoanDept.assignLoans(businessLoans);

        // Display average, max, and min loan for clients
        personalLoanDept.averageLoan();
        personalLoanDept.maxLoan();
        personalLoanDept.minLoan();

        // Display average, max, and min loan for businesses
        businessLoanDept.averageLoan();
        businessLoanDept.maxLoan();
        businessLoanDept.minLoan();
        
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
