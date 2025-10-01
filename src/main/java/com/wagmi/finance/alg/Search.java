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
    
        if(sortedById.length==0){
            return -1;
        }
        int start=0;
        int end=sortedById.length;

        while(start<=end){
            int mid=(start+end)/2;
            if(sortedById[mid].equals(id))
            {
                return mid;
            }
            else if(sortedById[mid]>id)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return -1;
        throw new UnsupportedOperationException("Not implemented");
    }
}
