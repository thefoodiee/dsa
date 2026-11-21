package BinaryTree;

import java.util.*;

class VNode{
    TreeNode node;
    int hd;
    int level;
    VNode(TreeNode node, int hd, int level){
        this.node = node;
        this.hd = hd;
        this.level = level;
    }
}

public class VerticalTraversal {
    static void main() {

    }

    static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<VNode> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        //      vertical         levels       elements

        VNode rt = new VNode();
        rt.node = root;
        rt.hd = 0;
        rt.level = 0;
        queue.add(rt);

        while (!queue.isEmpty()){
            VNode curr = queue.poll();
            TreeNode node = curr.node;
            int level = curr.level;
            int hd = curr.hd;

            if(!map.containsKey(hd)){
                map.put(hd, new TreeMap<>());
            }

            if(!map.get(hd).containsKey(level)){
                map.get(hd).put(level, new PriorityQueue<>());
            }
            map.get(hd).get(level).add(node.val);

            if(node.left != null){
                queue.add(new VNode(node.left, hd-1, level+1));
            }
            if(node.right != null){
                queue.add(new VNode(node.right, hd+1, level+1));
            }
        }

        //feed ans to an AL
        for(TreeMap<Integer, PriorityQueue<Integer>> m1: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : m1.values()){
                while(!nodes.isEmpty()){
                    ans.getLast().add(nodes.poll());
                }
            }
        }

        return ans;
    }
}
