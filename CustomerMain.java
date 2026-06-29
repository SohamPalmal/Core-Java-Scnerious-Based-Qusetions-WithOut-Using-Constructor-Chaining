//4) E-Commerce Discount System
//Build an E-Commerce Billing Application.
//The platform supports two types of customers:
//• RegularCustomer
//• PremiumCustomer
//The system must calculate the final payable amount based on customer type.
//________________________________________
//🔹 Abstract Class: Customer
//Private Variables:
//•	customerId (auto-generated using static counter)
//•	customerName
//•	cartAmount
//Methods:
//•	Getters & Setters
//•	Protected method to generate Customer ID
//•	Abstract method:
//calculateFinalAmount()
//________________________________________
//🔹 Child Classes
//	 RegularCustomer
//Rules:
//•	Delivery charge = ₹100
//•	If cartAmount > 5000 → ₹500 discount
//•	Extra method:
//customerDetails()
//________________________________________  PremiumCustomer
//Rules:
//•	No delivery charge
//•	10% discount on cartAmount
//•	Extra method:
//customerDetails()
//Print:
//Premium membership discount applied
//________________________________________
//	 Expected Output
//Order Summary Generated
//
//Customer ID: C1001
//Name: Ajay
//Cart Amount: 6000.0
//Discount Applied: 500.0
//Final Amount: 5600.0
//
//--------------------------------
//
//Order Summary Generated
//
//Customer ID: C1002
//Name: Priya
//Cart Amount: 4000.0
//Premium membership discount applied
//Final Amount: 3600.0

package scenerious;

abstract class Customer {

    private static int counter = 1000;

    private String customerId;
    private String customerName;
    private double cartAmount;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(double cartAmount) {
        this.cartAmount = cartAmount;
    }

    protected String generateCustomerId() {
        return "C" + (++counter);
    }

    public abstract double calculateFinalAmount();
}

class RegularCustomer extends Customer {

    private double discount = 0;

    @Override
    public double calculateFinalAmount() {

        if (getCartAmount() > 5000) {
            discount = 500;
        }

        return getCartAmount() - discount + 100;
    }

    public void customerDetails() {

        calculateFinalAmount();

        System.out.println("Order Summary Generated\n");

        System.out.println("Customer ID: " + getCustomerId());
        System.out.println("Name: " + getCustomerName());
        System.out.println("Cart Amount: " + getCartAmount());
        System.out.println("Discount Applied: " + discount);
        System.out.println("Final Amount: " + calculateFinalAmount());
    }
}

class PremiumCustomer extends Customer {

    @Override
    public double calculateFinalAmount() {

        double discount = getCartAmount() * 0.10;

        return getCartAmount() - discount;
    }

    public void customerDetails() {

        System.out.println("Order Summary Generated\n");

        System.out.println("Customer ID: " + getCustomerId());
        System.out.println("Name: " + getCustomerName());
        System.out.println("Cart Amount: " + getCartAmount());
        System.out.println("Premium membership discount applied");
        System.out.println("Final Amount: " + calculateFinalAmount());
    }
}

public class CustomerMain {

    public static void main(String[] args) {

        RegularCustomer c1 = new RegularCustomer();

        c1.setCustomerId(c1.generateCustomerId());
        c1.setCustomerName("Ajay");
        c1.setCartAmount(6000);

        c1.customerDetails();

        System.out.println("\n--------------------------------\n");

        PremiumCustomer c2 = new PremiumCustomer();

        c2.setCustomerId(c2.generateCustomerId());
        c2.setCustomerName("Priya");
        c2.setCartAmount(4000);

        c2.customerDetails();
    }
}