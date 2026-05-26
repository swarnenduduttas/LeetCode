/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor(root, p, q);
        return result;
    }

    int ancestor(TreeNode root, TreeNode p, TreeNode q){
        int sum = 0;
        int left = 0;
        int right = 0;
        int self = 0;

        if(root == null){
            return 0;
        }

        left = ancestor(root.left, p, q);
        right = ancestor(root.right, p, q);

        if(root.val == p.val || root.val == q.val){
            self++;
        }
        
        sum = self+left+right;

        if(sum == 2 && result == null){
            result = root;
        }

        return sum;
    }
}