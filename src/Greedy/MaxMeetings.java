package Greedy;

import java.util.*;

class Meeting{
    int start;
    int end;
    int pos;
}

class MeetingCompare implements Comparator<Meeting>{
    public int compare(Meeting m1, Meeting m2){
        return Integer.compare(m1.end,m2.end);
    }
}

public class MaxMeetings {
    static void main() {
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(s, f));
    }
    static ArrayList<Integer> maxMeetings(int[] s, int[] f){
        ArrayList<Meeting> store = new ArrayList<>();
        for(int i = 0; i<s.length; i++){
            Meeting temp = new Meeting();
            temp.start = s[i];
            temp.end = f[i];
            temp.pos = i+1;
            store.add(temp);
        }
        store.sort(new MeetingCompare());
//        for(Meeting i : store){
//            System.out.print("start: " + i.start + " end: " + i.end + " pos: "+i.pos);
//            System.out.println();
//        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(store.getFirst().pos);
        int lastFree = store.getFirst().end;
//        for(Meeting i : store){
//            if(i.start >= lastFree){
//                ans.add(i.pos);
//                lastFree = i.end;
//            }
//        }
        for(int i = 1; i<store.size(); i++){
            Meeting ele = store.get(i);
            if(ele.start >= lastFree){
                ans.add(ele.pos);
                lastFree = ele.end;
            }
        }
        ans.sort(null);

        return ans;
    }
}
