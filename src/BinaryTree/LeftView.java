package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    static void main() {

    }

    ArrayList<Integer> leftView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root== null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    if(i == 0) ans.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
            }
        }

        return ans;
    }
}
