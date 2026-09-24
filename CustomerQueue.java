public class CustomerQueue {

    private class Node {
        Customer customer;
        Node next;

        Node(Customer customer) {
            this.customer = customer;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public CustomerQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add customer
    public void enqueue(Customer customer) {

        Node newNode = new Node(customer);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove customer from front
    public Customer dequeue() {

        if (front == null) {
            return null;
        }

        Customer customer = front.customer;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return customer;
    }

    // View next customer
    public Customer peek() {

        if (front == null) {
            return null;
        }

        return front.customer;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Queue size
    public int size() {
        return size;
    }

    // Convert queue to array
    public Customer[] toArray() {

        Customer[] customers = new Customer[size];

        Node current = front;
        int index = 0;

        while (current != null) {

            customers[index] = current.customer;

            current = current.next;
            index++;
        }

        return customers;
    }

    // Rebuild queue
    public void rebuild(Customer[] customers) {

        front = null;
        rear = null;
        size = 0;

        for (Customer customer : customers) {

            if (customer != null) {
                addWithoutMessage(customer);
            }
        }
    }

    private void addWithoutMessage(Customer customer) {

        Node newNode = new Node(customer);

        if (rear == null) {

            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Display customers
    public void display() {

        if (front == null) {

            System.out.println();
            System.out.println("The queue is empty.");
            return;
        }

        System.out.println();
        System.out.println("========== CUSTOMER QUEUE ==========");

        Node current = front;

        while (current != null) {

            System.out.println(current.customer);

            current = current.next;
        }

        System.out.println("______________________________________");
        System.out.println("Total customers: " + size);
    }
}