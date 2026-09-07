package Arrays2;

public class FindDuplicate {
    static void main() {
        find(new int[]{1,3,4,2,3});
    }

    static void find(int[] arr){
        int slow = 0, fast = 0;

        while(true){
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow == fast) break;
        }

        slow = 0;
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        System.out.println(slow);
    }
}
