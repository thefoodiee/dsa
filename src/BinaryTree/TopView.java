package BinaryTree;

import java.util.*;

public class TopView {
    static void main() {

    }
    static ArrayList<Integer> top(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.level = 0;
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int hd = node.level;
            if(!map.containsKey(hd)){
                map.put(hd, node.val);
            }

            if(node.left!= null){
                node.left.level = hd -1;
                queue.add(node.left);
            }
            if(node.right!= null){
                node.right.level = hd -1;
                queue.add(node.right);
            }
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
