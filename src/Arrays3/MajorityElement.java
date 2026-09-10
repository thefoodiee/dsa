package Arrays3;

public class MajorityElement {
    static void main() {
        System.out.println(majority(new int[]{2,2,1,1,1,2,2}));
    }

    static int majority(int[] arr){
        int ele = arr[0];
        int count = 1;
        for(int i = 1; i<arr.length; i++){
            if(count == 0){
                count = 1;
                ele = arr[i];
            }
            else if(arr[i] == ele){
                count++;
            }
            else{
                count--;
            }
        }

        //verify
        int v = 0;
        for(int i: arr){
            if(i == ele) v++;
        }
        if(v > arr.length/2) return ele;
        return -1;
    }
}
