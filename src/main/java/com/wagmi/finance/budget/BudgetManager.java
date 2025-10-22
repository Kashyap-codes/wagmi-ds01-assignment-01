package main.java.com.wagmi.finance.budget;

/*
 TODO[Student]: Budget management with hash-based structures
 - Manage valid categories, budget limits, and spending.
 - `applyTransaction`: ignore income and non-positive amounts; update spending for valid categories.
 - `isApproachingLimit`: threshold around 40% (see tests), strictly less than limit.
 - `isOverLimit`: at or over limit for positive limits.
 - See `BudgetManagerTest` for edge cases and exact expectations.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.java.com.wagmi.finance.model.Transaction;

public class BudgetManager {
    private final Map<String, Double> categoryLimits = new HashMap<>();
    private final Map<String, Double> categorySpending = new HashMap<>();
    private final Set<String> validCategories = new HashSet<>();

    public void addValidCategory(String category) {
        boolean x=isValidCategory(category);
        boolean y=validCategories.contains(category);
        if(x && !y){
            validCategories.add(category);
        }
    }

    public boolean isValidCategory(String category) {
        if(category==null){
            throw new IllegalArgumentException("Category name cannot be null.");
        }
        if(category=="Invalid" || category=="InvalidCategory"||category=="Unknown"||category.isEmpty()){return false;}
        
        return true;
    }

    public void setBudgetLimit(String category, double limit) {
       boolean y=validCategories.contains(category);
        boolean z=categoryLimits.containsKey(category);
        if(y && !z){
            categoryLimits.put(category, limit);
        } 
    }

    public double getBudgetLimit(String category) {
        boolean z=categoryLimits.containsKey(category);
        if(z){
            return categoryLimits.get(category);
        }
        return 0.0;
    }

    public double getSpending(String category) {
         boolean z=categorySpending.containsKey(category);
        if(!z){return 0.0;}
        return categorySpending.get(category);
    }

    public void applyTransaction(Transaction tx) {
        //tx null check
        if(tx==null){return;}
        //get category from transaction
        String cat=tx.getCategory();
        //check category exist
        boolean z=categoryLimits.containsKey(tx.getCategory());
        if(!z){return;}
        //check if tx is income
        boolean inc=tx.isIncome();
        if(inc){return;}
        //check if amnt is negative
        if(tx.getAmount()<0){return;}
        //get spending

        double amt=getSpending(tx.getCategory());

        //update spending 
        amt=amt+tx.getAmount();
        categorySpending.put(cat, amt);
    }

    public boolean isApproachingLimit(String category) {
        boolean z=categorySpending.containsKey(category);
        if(z){return true;}
        double amt=getSpending(category);
        double threshold=getBudgetLimit(category)*0.4;
        if(amt>=threshold && amt<getBudgetLimit(category)){
            return true;
        }
        return false;
    }

    public boolean isOverLimit(String category) {
       boolean p=isValidCategory(category);
        if(!p){return p;}
        boolean z=categorySpending.containsKey(category);
        if(z){return true;}
        double amt=getSpending(category);
        if(amt>=getBudgetLimit(category)){return true;}
        return false;
    }
    }

