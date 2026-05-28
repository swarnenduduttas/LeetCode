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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> dec = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        TreeNode temp = root;
        while (temp != null) {
            asc.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            dec.push(temp);
            temp = temp.right;
        }

        TreeNode left = getSmall();
        TreeNode right = getBig();

        while (left != null && right != null && left.val < right.val) {
            int sum = left.val + right.val;

            if (sum == k) {
                return true;
            } else if (sum > k) {
                right = getBig();
            } else {
                left = getSmall();
            }
        }
        return false;
    }

    private TreeNode getSmall() {
        if (asc.isEmpty()) {
            return null;
        }
        TreeNode small = asc.pop();
        TreeNode right = small.right;

        while (right != null) {
            asc.push(right);
            right = right.left;
        }

        return small;
    }

    private TreeNode getBig() {
        if (dec.isEmpty()) {
            return null;
        }
        TreeNode big = dec.pop();
        TreeNode left = big.left;
        while (left != null) {
            dec.push(left);
            left = left.right;
        }
        return big;
    }
}