/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return ans;
    }

    void traverse(TreeNode root) {
        if (root == null || !ans) {
            return;
        }
        traverse(root.left);

        if (prev != null && prev.val >= root.val) {
            ans = false;
        }
        prev = root;

        traverse(root.right);
    }
}