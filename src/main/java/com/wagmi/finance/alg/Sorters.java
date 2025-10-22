package main.java.com.wagmi.finance.alg;

import java.util.ArrayList;

/*
 TODO[Student]: Sorting algorithms
 - Implement Quick Sort by amount (ascending).
 - Implement Merge Sort by date (ascending), stable.
 - Implement Insertion Sort by category using provided comparator.
 - See `SortersTest` for exact expectations and edge cases.
*/

import java.util.Comparator;

import main.java.com.wagmi.finance.model.Transaction;

public final class Sorters {
    private Sorters() {
    }

    public static void quickSortByAmount(Transaction[] arr) {

        if (arr == null || arr.length < 2) return;
        int h=arr.length-1;
        quicksort(arr,0,h);
        
    }

    public static void mergeSortByDate(Transaction[] arr) {
        // stub for mergesort
        if (arr == null || arr.length < 2) return;
        mergeSort(arr,0, arr.length-1);
        
    }

    public static void insertionSortByCategory(Transaction[] arr, Comparator<String> categoryComparator) {
        // stub for insertion sort by category string
        if (arr == null || arr.length < 2) return;
        int n=arr.length;
        for(int j=1;j<n;j++){
            Transaction k=arr[j];
            int i=j-1;
            while(i>=0 && (categoryComparator.compare(arr[i].getCategory(), k.getCategory())>0)){
                arr[i+1]=arr[i];
                i=i-1;
            }
            arr[i+1]=k;
        
    }
}
    public static void quicksort(Transaction[] arr,int low,int high){
        if(low<high){
            int p=partition(arr,low,high);
            quicksort(arr,low,p-1);
            quicksort(arr,p+1,high);
        }
    }
    public static int partition(Transaction[]arr,int low,int high){
        double pivot=arr[high].getAmount();
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].getAmount()<=pivot){
                i=i+1;
                swap(arr, i, j);
            }
            
        }
        swap(arr,i+1,high);
        return i+1;
    }
    public static void swap(Transaction[] arr, int i, int j) {
        
        Transaction temp = arr[i]; // Store the value at index i in a temporary variable
        arr[i] = arr[j];   // Assign the value at index j to index i
        arr[j] = temp;     // Assign the temporary value (original value at i) to index j
    }
    public static void mergeSort(Transaction[] arr, int low, int high) {
        if (low < high){
            int mid = (low + high) / 2 ;
            mergeSort(arr, low, mid);  // left half
            
            mergeSort(arr, mid + 1, high); // right half
            merge(arr, low, mid, high); 
            
        }
    }
    public static void merge(Transaction[]arr,int low,int mid,int high){
        ArrayList<Transaction> temp = new ArrayList<>(); 
        int left = low;
        int right = mid + 1; 
        while (left <= mid && right <= high) {
            if (arr[left].getDate().isBefore(arr[right].getDate())) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
