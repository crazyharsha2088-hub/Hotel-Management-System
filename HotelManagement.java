import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    int id;
    String name;
    int roomNo;
    int days;
    double bill;

    // Constructor
    Customer(int id, String name, int roomNo, int days) {
        this.id = id;
        this.name = name;
        this.roomNo = roomNo;
        this.days = days;
        calculateBill();
    }

    // Method to calculate bill
    void calculateBill() {
        bill = days * 1000; // ₹1000 per day
    }

    // Display customer details
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Room No: " + roomNo);
        System.out.println("Days: " + days);
        System.out.println("Bill: ₹" + bill);
        System.out.println("----------------------");
    }
}

public class HotelManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- HOTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room No: ");
                    int roomNo = sc.nextInt();

                    System.out.print("Enter Days Stayed: ");
                    int days = sc.nextInt();

                    if (days <= 0) {
                        System.out.println("Invalid days!");
                        break;
                    }

                    list.add(new Customer(id, name, roomNo, days));
                    System.out.println("Customer Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Customer c : list) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Customer c : list) {
                        if (c.id == searchId) {
                            c.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = list.removeIf(c -> c.id == deleteId);

                    if (removed) {
                        System.out.println("Customer deleted successfully!");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}