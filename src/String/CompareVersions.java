package String;

import java.util.ArrayList;

public class CompareVersions {
    static void main() {
        System.out.println(version("1.0.1", "1"));
    }

    static int version(String v1, String v2){
        int l1 = 0, r1 = 1;
        int l2 = 0, r2 = 1;
        int subInt = -1;
        ArrayList<Integer> c1 = new ArrayList<>();
        ArrayList<Integer> c2 = new ArrayList<>();

        while(r1<=v1.length() && r2 <= v2.length()){
            while(r1<=v1.length()){
                if(r1<v1.length() && v1.charAt(r1) == '.'){
                    subInt = Integer.parseInt(v1.substring(l1, r1));
                    r1++;
                    l1 = r1;
                    c1.add(subInt);
                }
                else if(r1 == v1.length()){
                    subInt = Integer.parseInt(v1.substring(l1, r1));
                    c1.add(subInt);
                }
                r1++;
            }

            while(r2<=v2.length()){
                if(r2<v2.length() && v2.charAt(r2) == '.'){
                    subInt = Integer.parseInt(v2.substring(l2, r2));
                    r2++;
                    l2 = r2;
                    c2.add(subInt);
                }
                else if(r2 == v2.length()){
                    subInt = Integer.parseInt(v2.substring(l2, r2));
                    c2.add(subInt);
                }
                r2++;
            }
        }

        boolean isC1Small = c1.size()<c2.size();
        if(isC1Small){
            while(c1.size() != c2.size()){
                c1.add(0);
            }
        }
        else{
            while(c2.size() != c1.size()){
                c2.add(0);
            }
        }

        for(int i = 0; i<c1.size(); i++){
            if(c1.get(i)<c2.get(i)){
                return -1;
            }
            else if(c1.get(i) > c2.get(i)){
                return 1;
            }
        }
        return 0;
    }
}
