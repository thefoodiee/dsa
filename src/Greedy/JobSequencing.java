package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    static void main() {
        int[] deadline = {4,1,1,1};
        int[] profit = {20, 10, 40, 30};
        System.out.println(sequence(deadline, profit));
    }
    static ArrayList<Integer> sequence(int[] deadline, int[] profit){
        ArrayList<Job> store = new ArrayList<>();
        int maxDeadline = 0;
        for(int i = 0; i<deadline.length; i++){
            store.add(new Job(deadline[i], profit[i]));
            maxDeadline = Math.max(deadline[i], maxDeadline);
        }

        store.sort(new JobCompare().reversed());
//        System.out.println(store);

        int[] arr = new int[maxDeadline+1];
        Arrays.fill(arr, -1);

        int count = 0, sum = 0;
        for(int i = 0; i<store.size(); i++){
            Job curr = store.get(i);
            for(int j = curr.deadline; j>0; j--){
                if(arr[j] == -1){
                    arr[j] = curr.profit;
                    count++;
                    sum += curr.profit;
                    break;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(count, sum));
    }
}

class JobCompare implements Comparator<Job> {
    public int compare(Job j1, Job j2){
        return Integer.compare(j1.profit, j2.profit);
    }
}

class Job{
    int deadline;
    int profit;
    Job(int deadline, int profit){
        this.profit = profit;
        this.deadline = deadline;
    }

    public String toString(){
        return "deadline: " + deadline + " profit: " + profit;
    }
}
