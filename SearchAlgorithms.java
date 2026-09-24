public class SearchAlgorithms {

    // Linear search by customer ID
    public static Customer linearSearch(Customer[] customers, int id) {

        if (customers == null) {
            return null;
        }

        for (Customer customer : customers) {

            if (customer != null &&
                customer.getId() == id) {

                return customer;
            }
        }

        return null;
    }
}