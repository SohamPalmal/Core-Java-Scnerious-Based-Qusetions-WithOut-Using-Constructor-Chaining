//Hospital Billing System
//Build a Hospital Billing Application.
//The hospital treats two types of patients:
//• GeneralPatient
//• InsuredPatient
//The hospital needs to calculate the final bill based on patient type.
//________________________________________
// Abstract Class: Patient
//Private Variables:
//•	patientId (auto-generated using static counter)
//•	patientName
//•	treatmentCost
//Methods:
//•	Getters & Setters
//•	Protected method to generate Patient ID
//•	Abstract method:
//calculateBill()
//________________________________________
//* Child Classes
// GeneralPatient
//Rules:
//•	No insurance coverage
//•	If treatmentCost > 50,000 → ₹5,000 discount
//•	Extra method:
//patientDetails()
//________________________________________
//InsuredPatient
//Rules:
//•	Insurance covers 70% of treatment cost
//•	If final bill > 20,000 → ₹3,000 additional discount
//•	Extra method:
//patientDetails()
//Print:
//Insurance coverage applied
//________________________________________
//Expected Output
//Bill Generated Successfully
//
//Patient ID: P1001
//Name: Rahul
//Treatment Cost: 60000.0
//Discount Applied: 5000.0
//Final Bill: 55000.0
//
//--------------------------------
//
//Bill Generated Successfully
//
//Patient ID: P1002
//Name: Sneha
//Treatment Cost: 50000.0
//Insurance coverage applied
//Additional Discount Applied: 3000.0
//Final Bill: 12000.0
//________________________________________

package scenerious;

abstract class Patient {
    private static int counter = 1000;

    private String patientId;
    private String patientName;
    private double treatmentCost;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Patient.counter = counter;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    protected String generatePatientId() {
        return "P" + (++counter);
    }

    public abstract double calculateBill();
}

class GeneralPatient extends Patient {

    private double discount = 0;

    @Override
    public double calculateBill() {

        double bill = getTreatmentCost();

        if (bill > 50000) {
            discount = 5000;
            bill -= discount;
        }

        return bill;
    }

    public void patientDetails() {

        calculateBill();

        System.out.println("Bill Generated Successfully\n");

        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getPatientName());
        System.out.println("Treatment Cost: " + getTreatmentCost());
        System.out.println("Discount Applied: " + discount);
        System.out.println("Final Bill: " + calculateBill());
    }
}

class InsuredPatient extends Patient {

    private double additionalDiscount = 0;

    @Override
    public double calculateBill() {

        double bill = getTreatmentCost() * 0.30;

        if (getTreatmentCost() >= 50000) {
            additionalDiscount = 3000;
            bill -= additionalDiscount;
        }

        return bill;
    }

    public void patientDetails() {

        calculateBill();

        System.out.println("Bill Generated Successfully\n");

        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getPatientName());
        System.out.println("Treatment Cost: " + getTreatmentCost());
        System.out.println("Insurance coverage applied");

        if (additionalDiscount > 0) {
            System.out.println("Additional Discount Applied: "
                    + additionalDiscount);
        }

        System.out.println("Final Bill: " + calculateBill());
    }
}

public class HospitalBillingSystem {

    public static void main(String[] args) {

        GeneralPatient p1 = new GeneralPatient();

        p1.setPatientId(p1.generatePatientId());
        p1.setPatientName("Rahul");
        p1.setTreatmentCost(60000);

        p1.patientDetails();

        System.out.println("--------------------------------");

        InsuredPatient p2 = new InsuredPatient();

        p2.setPatientId(p2.generatePatientId());
        p2.setPatientName("Sneha");
        p2.setTreatmentCost(50000);

        p2.patientDetails();
    }
}