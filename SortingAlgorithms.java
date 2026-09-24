public class SortingAlgorithms {

    // Insertion sort by customer ID
    public static void insertionSort(Customer[] customers) {

        if (customers == null) {
            return;
        }

        for (int i = 1; i < customers.length; i++) {

            Customer current = customers[i];

            int j = i - 1;

            while (j >= 0 &&
                   customers[j].getId() > current.getId()) {

                customers[j + 1] = customers[j];

                j--;
            }

            customers[j + 1] = current;
        }
    }

    // Insertion sort by priority
    // Priority 1 = highest
    public static void insertionSortByPriority(Customer[] customers) {

        if (customers == null) {
            return;
        }

        for (int i = 1; i < customers.length; i++) {

            Customer current = customers[i];

            int j = i - 1;

            while (j >= 0 &&
                   customers[j].getPriority() > current.getPriority()) {

                customers[j + 1] = customers[j];

                j--;
            }

            customers[j + 1] = current;
        }
    }
}