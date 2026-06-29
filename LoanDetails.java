//2) Loan Approval System
//Build a Loan Processing Application for a bank.
//The bank provides two types of loans:
//• PersonalLoan
//• HomeLoan
//The system must calculate interest based on loan type.
//________________________________________
//🔹 Abstract Class: Loan
//Private Variables:
//•	loanId (auto-generated using static counter)
//•	applicantName
//•	loanAmount
//Methods:
//•	Getters & Setters
//•	Protected method to generate Loan ID
//•	Abstract method:
//calculateInterest()
//________________________________________
//🔹 Child Classes
//PersonalLoan
//Rules:
//•	Interest rate = 12%
//•	If loanAmount > 5,00,000 → 1% concession (i.e., interest becomes 11%)
//•	Extra method:
//loanDetails()
//________________________________________
//HomeLoan
//Rules:
//•	Interest rate = 8%
//•	If loanAmount > 20,00,000 → 0.5% concession (i.e., interest becomes 7.5%)
//•	Extra method:
//loanDetails()
//Print:
//Home loan special interest applied
//________________________________________
// Expected Output
//Loan Processed Successfully
//
//Loan ID: L1001
//Applicant: Arun
//Loan Amount: 600000.0
//Interest: 66000.0
//
//--------------------------------
//
//Loan Processed Successfully
//
//Loan ID: L1002
//Applicant: Meena
//Loan Amount: 2500000.0
//Home loan special interest applied
//Interest: 187500.0




package scenerious;

abstract class Loan {

    private static int counter = 1000;

    private String loanId;
    private String applicantName;
    private double loanAmount;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    protected String generateLoanId() {
        return "L" + (++counter);
    }

    public abstract double calculateInterest();
}

class PersonalLoan extends Loan {

    @Override
    public double calculateInterest() {

        double rate = 12;

        if (getLoanAmount() > 500000) {
            rate = 11;
        }

        return (getLoanAmount() * rate) / 100;
    }

    public void loanDetails() {

        System.out.println("Loan Processed Successfully\n");

        System.out.println("Loan ID: " + getLoanId());
        System.out.println("Applicant: " + getApplicantName());
        System.out.println("Loan Amount: " + getLoanAmount());
        System.out.println("Interest: " + calculateInterest());
    }
}

class HomeLoan extends Loan {

    @Override
    public double calculateInterest() {

        double rate = 8;

        if (getLoanAmount() > 2000000) {
            rate = 7.5;
        }

        return (getLoanAmount() * rate) / 100;
    }

    public void loanDetails() {

        System.out.println("Loan Processed Successfully\n");

        System.out.println("Loan ID: " + getLoanId());
        System.out.println("Applicant: " + getApplicantName());
        System.out.println("Loan Amount: " + getLoanAmount());

        if (getLoanAmount() > 2000000) {
            System.out.println("Home loan special interest applied");
        }

        System.out.println("Interest: " + calculateInterest());
    }
}

public class LoanDetails {

    public static void main(String[] args) {

        PersonalLoan p = new PersonalLoan();

        p.setLoanId(p.generateLoanId());
        p.setApplicantName("Arun");
        p.setLoanAmount(600000);

        p.loanDetails();

        System.out.println("\n--------------------------------\n");

        HomeLoan h = new HomeLoan();

        h.setLoanId(h.generateLoanId());
        h.setApplicantName("Meena");
        h.setLoanAmount(2500000);

        h.loanDetails();
    }
}