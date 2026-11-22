package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    static void main() {

    }

    static List<String> paths(TreeNode root){
        return build(root, Integer.toString(root.val), new ArrayList<>());
    }

    static List<String> build(TreeNode node, String s, List<String> ans){
        if(node.left == null && node.right == null){
            ans.add(s);
            return ans;
        }

        if(node.left != null){
            build(node.left, s + "->" + node.left.val, ans);
        }

        if(node.right != null){
            build(node.right, s+"->"+node.right.val, ans);
        }

        return ans;
    }
}
