//Smart Ride Booking System
//You are building a ride booking application.
//Two types of rides:
//•	MiniRide
//•	LuxuryRide
//________________________________________
//* Abstract Class: Ride
//Private Variables:
//•	rideId (auto-generated using static counter)
//•	customerName
//•	pickupLocation
//•	distance
//Methods:
//•	Getters & Setters
//•	Protected method to generate Ride ID
//•	Abstract method:
//calculateFare()
//________________________________________
//**  Child Classes
// MiniRide
//•	₹12 per km
//•	If distance > 20 → ₹80 discount
//•	Extra method:
//	rideDetails()
//________________________________________
//
//
//** LuxuryRide
//•	₹20 per km
//•	Extra ₹200 luxury charge
//•	If total > 800 → ₹150 discount
//•	Extra method:
//rideDetails()
//Print:
//"Luxury comfort charges applied"
//________________________________________
// Expected Output 
//Ride booked successfully
//
//Ride ID: R1001
//Customer: Dinga
//Pickup: Bangalore
//Distance: 25.0 km
//Mini Ride Discount Applied: 80
//Final Fare: 220.0
//
//--------------------------------
//
//Ride booked successfully
//
//Ride ID: R1002
//Customer: Dingi
//Pickup: Chennai
//Distance: 30.0 km
//Luxury Ride Discount Applied: 150
//Luxury comfort charges applied
//Final Fare: 650.0


package scenerious;

abstract class Ride {

    private static int counter = 1000;

    private String rideId;
    private String customerName;
    private String pickupLocation;
    private double distance;

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    protected String generateRideId() {
        return "R" + (++counter);
    }

    public abstract double calculateFare();
}

class MiniRide extends Ride {

    private double discount = 0;

    @Override
    public double calculateFare() {

        double fare = getDistance() * 12;

        if (getDistance() > 20) {
            discount = 80;
            fare -= discount;
        }

        return fare;
    }

    public void rideDetails() {

        calculateFare();

        System.out.println("Ride booked successfully\n");

        System.out.println("Ride ID: " + getRideId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Pickup: " + getPickupLocation());
        System.out.println("Distance: " + getDistance() + " km");

        if (discount > 0) {
            System.out.println("Mini Ride Discount Applied: "
                    + (int) discount);
        }

        System.out.println("Final Fare: " + calculateFare());
    }
}

class LuxuryRide extends Ride {

    private double discount = 0;

    @Override
    public double calculateFare() {

        double fare = (getDistance() * 20) + 200;

        if (fare >= 800) {
            discount = 150;
            fare -= discount;
        }

        return fare;
    }

    public void rideDetails() {

        calculateFare();

        System.out.println("Ride booked successfully\n");

        System.out.println("Ride ID: " + getRideId());
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Pickup: " + getPickupLocation());
        System.out.println("Distance: " + getDistance() + " km");

        if (discount > 0) {
            System.out.println("Luxury Ride Discount Applied: "
                    + (int) discount);
        }

        System.out.println("Luxury comfort charges applied");
        System.out.println("Final Fare: " + calculateFare());
    }
}

public class RideBookingSystem {
    public static void main(String[] args) {

        MiniRide mini = new MiniRide();

        mini.setRideId(mini.generateRideId());
        mini.setCustomerName("Dinga");
        mini.setPickupLocation("Bangalore");
        mini.setDistance(25);

        mini.rideDetails();

        System.out.println("\n--------------------------------\n");

        LuxuryRide luxury = new LuxuryRide();

        luxury.setRideId(luxury.generateRideId());
        luxury.setCustomerName("Dingi");
        luxury.setPickupLocation("Chennai");
        luxury.setDistance(30);

        luxury.rideDetails();
    }
}