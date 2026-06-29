//5) Movie Ticket Booking System
//Build a Movie Ticket Booking Application.
//The theatre provides two types of ticket categories:
//• RegularTicket
//• VIPTicket
//The system calculates ticket price based on category.
//________________________________________
//🔹 Abstract Class: Ticket
//Private Variables:
//•	ticketId (auto-generated using static counter)
//•	customerName
//•	numberOfTickets
//Methods:
//•	Getters & Setters
//•	Protected method to generate Ticket ID
//•	Abstract method:
//calculateTotalAmount()
//________________________________________
//🔹 Child Classes
//	 RegularTicket
//Rules:
//•	Ticket price = ₹150 per ticket
//•	If numberOfTickets ≥ 5 → ₹100 discount
//•	Extra method:
//ticketDetails()
//________________________________________
//	 VIPTicket
//Rules:
//•	Ticket price = ₹300 per ticket
//•	Complimentary snacks charge ₹200
//•	Extra method:
//ticketDetails()
//Print:
//VIP benefits included
//________________________________________
//Expected Output
//Booking Confirmed
//
//Ticket ID: T1001
//Customer: Ramesh
//Number of Tickets: 6
//Discount Applied: 100.0
//Total Amount: 800.0
//
//--------------------------------
//
//Booking Confirmed
//
//Ticket ID: T1002
//Customer: Sita
//Number of Tickets: 3
//VIP benefits included
//Total Amount: 1100.0


package scenerious;

abstract class Ticket {

    private static int counter = 1000;

    private String ticketId;
    private String customerName;
    private int numberOfTickets;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    protected String generateTicketId() {
        return "T" + (++counter);
    }

    public abstract double calculateTotalAmount();
}

class RegularTicket extends Ticket {

    private double discount = 0;

    @Override
    public double calculateTotalAmount() {

        double total = getNumberOfTickets() * 150;

        if (getNumberOfTickets() >= 5) {
            discount = 100;
        }

        return total - discount;
    }

    public void ticketDetails() {

        calculateTotalAmount();

        System.out.println("Booking Confirmed\n");

        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Number of Tickets: " + getNumberOfTickets());
        System.out.println("Discount Applied: " + discount);
        System.out.println("Total Amount: " + calculateTotalAmount());
    }
}

class VIPTicket extends Ticket {

    @Override
    public double calculateTotalAmount() {
        return (getNumberOfTickets() * 300) + 200;
    }

    public void ticketDetails() {

        System.out.println("Booking Confirmed\n");

        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Number of Tickets: " + getNumberOfTickets());
        System.out.println("VIP benefits included");
        System.out.println("Total Amount: " + calculateTotalAmount());
    }
}

public class TicketMain {

    public static void main(String[] args) {

        RegularTicket t1 = new RegularTicket();

        t1.setTicketId(t1.generateTicketId());
        t1.setCustomerName("Ramesh");
        t1.setNumberOfTickets(6);

        t1.ticketDetails();

        System.out.println("\n--------------------------------\n");

        VIPTicket t2 = new VIPTicket();

        t2.setTicketId(t2.generateTicketId());
        t2.setCustomerName("Sita");
        t2.setNumberOfTickets(3);

        t2.ticketDetails();
    }
}