package BinaryTree;

import java.util.*;

class Node{
    int val;
    int level;
    Node left;
    Node right;
}

public class BottomView {
    static void main() {

    }
    static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.level = 0;
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            int level = temp.level;
            map.put(level, temp.val);

            if(temp.left != null){
                temp.left.level = level-1;
                queue.add(temp.left);
            }
            if(temp.right != null){
                temp.right.level = level+1;
                queue.add(temp.right);
            }
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
