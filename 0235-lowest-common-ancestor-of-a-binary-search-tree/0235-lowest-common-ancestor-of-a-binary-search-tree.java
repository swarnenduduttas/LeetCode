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
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return res;
        }
        if((p.val<=root.val && q.val >= root.val) || (q.val<=root.val && p.val >= root.val)){
            res = root;
            return res;
        }
        if(root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right,p,q);
        }
        return res;
    }
}