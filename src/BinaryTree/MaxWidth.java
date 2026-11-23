package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode node;
    long idx;
    Pair(TreeNode node, long idx){
        this.node = node;
        this.idx = idx;
    }
}

public class MaxWidth {
    static void main() {

    }
    static int width(TreeNode root){
        Deque<Pair> deque = new LinkedList<>();
        deque.add(new Pair(root, 0));
        int max = -1;

        while(!deque.isEmpty()){
            int len = deque.size();
            long start = deque.getFirst().idx;
            long end = deque.getLast().idx;
            max = Math.max(max, (int) (end-start+1));

            for(int i = 0; i<len; i++){
                Pair curr = deque.poll();
                if(curr != null){
                    TreeNode node = curr.node;
                    if(node.left != null){
                        deque.push(new Pair(node.left, 2*curr.idx+1));
                    }

                    if(node.right != null){
                        deque.push(new Pair(node.right, 2*curr.idx+2));
                    }
                }

            }
        }

        return max;
    }
}
