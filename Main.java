import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final CustomerQueue customerQueue =
            new CustomerQueue();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println();
        System.out.println("_______________________________________________");
        System.out.println("     BANK CUSTOMER QUEUE MANAGEMENT SYSTEM");
        System.out.println("_______________________________________________");

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");
            System.out.flush();

            String input = scanner.nextLine();

            int choice;

            try {

                choice = Integer.parseInt(input.trim());

            } catch (NumberFormatException e) {

                System.out.println();
                System.out.println("Please enter a number from 1 to 9.");
                continue;
            }

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    serveCustomer();
                    break;

                case 3:
                    viewNextCustomer();
                    break;

                case 4:
                    searchCustomer();
                    break;

                case 5:
                    sortById();
                    break;

                case 6:
                    sortByPriority();
                    break;

                case 7:
                    displayCustomers();
                    break;

                case 8:
                    displayQueueSize();
                    break;

                case 9:
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please select 1-9.");
            }
        }

        scanner.close();
    }

    
    // MENU
    

    private static void displayMenu() {

        System.out.println();
        System.out.println("__________ MAIN MENU ________________");
        System.out.println("1. Add Customer");
        System.out.println("2. Serve Next Customer");
        System.out.println("3. View Next Customer");
        System.out.println("4. Search Customer");
        System.out.println("5. Sort Customers by ID");
        System.out.println("6. Sort Customers by Priority");
        System.out.println("7. Display All Customers");
        System.out.println("8. Display Queue Size");
        System.out.println("9. Exit");
        System.out.println("_______________________________________");
    }

    // ==============================
    // 1. ADD CUSTOMER
    // ==============================

    private static void addCustomer() {

        System.out.println();
        System.out.println("---------- ADD CUSTOMER ----------");

        int id = readInt("Enter customer ID: ");

        Customer existing =
                SearchAlgorithms.linearSearch(
                        customerQueue.toArray(), id);

        if (existing != null) {

            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter customer name: ");
        System.out.flush();

        String name = scanner.nextLine();

        System.out.print("Enter banking service: ");
        System.out.flush();

        String service = scanner.nextLine();

        int priority =
                readInt("Enter priority (1 = highest, 5 = lowest): ");

        if (priority < 1 || priority > 5) {

            System.out.println(
                    "Priority must be between 1 and 5.");

            return;
        }

        Customer customer =
                new Customer(
                        id,
                        name,
                        service,
                        priority);

        customerQueue.enqueue(customer);

        System.out.println();
        System.out.println("Customer added successfully!");
    }

    // ==============================
    // 2. SERVE CUSTOMER
    // ==============================

    private static void serveCustomer() {

        System.out.println();
        System.out.println("---------- SERVE CUSTOMER ----------");

        if (customerQueue.isEmpty()) {

            System.out.println("No customers are waiting.");

            return;
        }

        Customer customer =
                customerQueue.dequeue();

        System.out.println();
        System.out.println("Customer being served:");
        System.out.println(customer);

        System.out.println();
        System.out.println("Customer served successfully.");
    }

    // ==============================
    // 3. VIEW NEXT CUSTOMER
    // ==============================

    private static void viewNextCustomer() {

        System.out.println();
        System.out.println("---------- NEXT CUSTOMER ----------");

        if (customerQueue.isEmpty()) {

            System.out.println("No customers are waiting.");

            return;
        }

        Customer customer =
                customerQueue.peek();

        System.out.println();
        System.out.println("Next customer:");
        System.out.println(customer);
    }

    
    // 4. SEARCH CUSTOMER
    

    private static void searchCustomer() {

        System.out.println();
        System.out.println("---------- SEARCH CUSTOMER ----------");

        if (customerQueue.isEmpty()) {

            System.out.println("The queue is empty.");

            return;
        }

        int id =
                readInt("Enter customer ID to search: ");

        Customer found =
                SearchAlgorithms.linearSearch(
                        customerQueue.toArray(),
                        id);

        System.out.println();

        if (found != null) {

            System.out.println("CUSTOMER FOUND:");
            System.out.println(found);

        } else {

            System.out.println("Customer not found.");
        }
    }

    
    // 5. SORT BY ID
    

    private static void sortById() {

        System.out.println();
        System.out.println("---------- SORT BY ID ----------");

        if (customerQueue.isEmpty()) {

            System.out.println("The queue is empty.");

            return;
        }

        Customer[] customers =
                customerQueue.toArray();

        SortingAlgorithms.insertionSort(customers);

        customerQueue.rebuild(customers);

        System.out.println("Customers sorted by ID.");

        customerQueue.display();
    }

    
    // 6. SORT BY PRIORITY
    

    private static void sortByPriority() {

        System.out.println();
        System.out.println("---------- SORT BY PRIORITY ----------");

        if (customerQueue.isEmpty()) {

            System.out.println("The queue is empty.");

            return;
        }

        Customer[] customers =
                customerQueue.toArray();

        SortingAlgorithms.insertionSortByPriority(customers);

        customerQueue.rebuild(customers);

        System.out.println("Customers sorted by priority.");

        customerQueue.display();
    }


    // 7. DISPLAY CUSTOMERS
    

    private static void displayCustomers() {

        System.out.println();
        System.out.println("---------- ALL CUSTOMERS ----------");

        customerQueue.display();
    }

    
    // 8. QUEUE SIZE
    

    private static void displayQueueSize() {

        System.out.println();
        System.out.println("---------- QUEUE SIZE ----------");

        System.out.println(
                "Customers currently waiting: "
                        + customerQueue.size());
    }

    
    // SAFE INTEGER INPUT
    

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);
            System.out.flush();

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input.trim());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }
}
