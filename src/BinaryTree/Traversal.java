package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
    static void main() {

    }

    static void inorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    static void preorder(TreeNode node){
        if(node == null){
            return;
        }

        System.out.println(node.val);
        inorder(node.left);
        inorder(node.right);
    }

    static void postorder(TreeNode node){
        if(node == null){
            return;
        }

        inorder(node.left);
        inorder(node.right);
        System.out.println(node.val);
    }

    static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int len = queue.size();

            for(int i = 0; i<len; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    queue.add(node.left);
                    queue.add(node.right);
                    temp.add(node.val);
                }
            }
            if(!temp.isEmpty()){
                ans.add(temp);
            }
        }
        System.out.println(ans);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}