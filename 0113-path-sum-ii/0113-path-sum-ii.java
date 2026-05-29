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
    List<List<Integer>> res = new ArrayList<>();
    int target = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return res;
        }
        int sum = 0;
        target = targetSum;
        List<Integer> diary = new ArrayList<>();
        traverse(root, sum, diary);
        return res;
    }

    void traverse(TreeNode root, int sum, List<Integer> diary) {
        if(root == null){
            return;
        }

        sum += root.val;
        diary.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == target){
                res.add(new ArrayList<>(diary));
            }
        }

        traverse(root.left, sum, diary);
        traverse(root.right, sum, diary);
        diary.removeLast();
    }
}