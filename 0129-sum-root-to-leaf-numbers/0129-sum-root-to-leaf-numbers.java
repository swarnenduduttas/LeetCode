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

    int res = 0;
    
    public int sumNumbers(TreeNode root) {
        // if(root == null){
        //     return result;
        // }
        int sum = 0;
        traverse(root, sum);
        return res;
    }

    void traverse(TreeNode root, int sum){
        if(root == null){
            return;
        }

        sum = sum*10+root.val;

        if(root.left == null && root.right == null){
            res = res+sum;
        }

        traverse(root.left, sum);
        traverse(root.right, sum);
    }
}