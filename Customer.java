public class Customer {

    private int id;
    private String name;
    private String service;
    private int priority;

    public Customer(int id, String name, String service, int priority) {
        this.id = id;
        this.name = name;
        this.service = service;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Name: " + name
                + " | Service: " + service
                + " | Priority: " + priority;
    }
}