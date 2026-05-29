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
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        int sum = 0;
        traverse(root, sum, target);
        return result;
    }

    void traverse(TreeNode root, int sum, int target){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum+=root.val;
            if(sum == target){
                result = true;
            }
        }

        sum += root.val;

        traverse(root.left, sum, target);
        traverse(root.right, sum, target);
    }
}