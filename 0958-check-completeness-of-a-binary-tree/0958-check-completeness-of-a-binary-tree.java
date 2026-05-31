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
    Queue<TreeNode> q = new LinkedList<>();
    boolean isNullFound = false;

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if(t == null){
                isNullFound = true;
            } else if(isNullFound){
                return false;
            } else {
                q.offer(t.left);
                q.offer(t.right);
            }
        }
        return true;
    }
}