package main.java.com.wagmi.finance.recursion;

/*
 TODO[Student]: Recursive utilities
 - `isValidDateRecursive`: parse YYYY-MM-DD without regex; handle ranges + leap years.
 - `categoryTotalRecursive`: sum amounts for a category (expenses only) recursively.
 - `generateBudgetReportRecursive`: build a non-empty string summarizing items recursively.
 - See `RecursionUtilsTest` for behavior and edge cases.
*/

import main.java.com.wagmi.finance.model.Transaction;

public final class RecursionUtils {
    private RecursionUtils() {
    }

    public static boolean isValidDateRecursive(String date) {
       if(date==null||date.length()!=10){return false;}
        if(date.charAt(4)!='-' || date.charAt(7)!='-'){return false;}
        int mm=Integer.parseInt(date.substring(5, 7));
        if (mm>12||mm<=0) {return false;}
        int yy=Integer.parseInt(date.substring(0, 4));
        if(yy<=0){return false;}
        int dd=Integer.parseInt(date.substring(8));
        if(dd>=32 || dd<=0){return false;}
        if((yy%4==0 && yy%100!=0 || yy%400==0) && mm==2 && dd>29){return false;}
        else if(yy%4!=0 && mm==2 && dd>28){return false;}
        if(mm<7 && mm%2==0 && dd>=31){return false;}
        if(mm>7 && mm%2!=0 && dd>=31){return false;}
        return true;
    }

    public static double categoryTotalRecursive(Transaction[] arr, String category) {
       if(arr.length==0 || category==null ||category=="Unknown"){
            return 0.0;
        }
        return total(arr,category,0);

    }

    public static String generateBudgetReportRecursive(Transaction[] arr) {
        // stub
        if(arr==null||arr.length==0){return "empty array given";}
        return report(arr,0).trim();
    }

    public static double total(Transaction[]arr,String category,int i){
        if(i>=arr.length){return 0.0;}
        double cur_amt=0.0;
        if(arr[i].getCategory().equals(category)){
            cur_amt=arr[i].getAmount();
        }
        return cur_amt+total(arr,category,i+1);
    }
    public static String report(Transaction[] arr,int i){
        if(i>=arr.length){return "";}
        String repo="";
        repo=repo+"  "+arr[i].getDate().toString()+" "+arr[i].getCategory()+Double.toString(arr[i].getAmount())+" ";
        return repo+report(arr,i+1);
    }
}
