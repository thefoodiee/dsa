package Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class FractionalKnapsack {
    static void main() {
        int[] val = {60,100,120};
        int[] wt = {10,20,30};
        System.out.println(knapsack(val, wt, 50));
    }
    static double knapsack(int[] val, int[] wt, int capacity){
        ArrayList<Fraction> store = new ArrayList<>();

        for(int i = 0; i<val.length; i++){
            store.add(new Fraction(val[i], wt[i]));
        }

        store.sort(new FractionCompare());
//        System.out.println(store);
        double sumVal = 0;
        int sumWt = 0;
        for(Fraction i : store){
            int currWt = i.wt;
            int currVal = i.val;
            int remainingWt = capacity - sumWt;

            if(currWt > remainingWt){
                sumVal += (remainingWt * ( (double) currVal/currWt));
                break;
            }
            else{
                sumVal += currVal;
                sumWt += currWt;
            }
        }
        return sumVal;
    }
}

class FractionCompare implements Comparator<Fraction>{
    public int compare(Fraction f1, Fraction f2){
        return Double.compare((double) f2.val / f2.wt, (double) f1.val / f1.wt);
    }
}

class Fraction {
    int val;
    int wt;
    Fraction(int val, int wt){
        this.val = val;
        this.wt = wt;
    }
    public String toString(){
        return "val: " + val + " wt: " + wt;
    }
}
