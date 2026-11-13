package BinaryTree;

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