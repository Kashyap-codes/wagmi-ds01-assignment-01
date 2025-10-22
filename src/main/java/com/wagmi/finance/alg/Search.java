package main.java.com.wagmi.finance.alg;
/*
 TODO[Student]: Binary search by Transaction ID
 - Array must be sorted by `Transaction.getId()` ascending.
 - Handle null array (throw NPE) and null id (return -1) per tests.
 - See `SearchTest` for target indices and edge cases.
*/

import main.java.com.wagmi.finance.model.Transaction;

public final class Search {
    private Search() {
    }

    public static int binarySearchById(Transaction[] sortedById, String id) {
    
        if (sortedById == null) {
        throw new NullPointerException("null array");
        }
        if (id == null) {
            return -1;
        }
        int mid, start = 0, end = sortedById.length - 1;

        while (start <= end) {
            mid = (start + end)/2;
            String ID = sortedById[mid].getId();

            int compare = ID.compareTo(id);
            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
