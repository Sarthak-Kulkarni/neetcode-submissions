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
    int ans = Integer.MIN_VALUE;

    private int calcSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(calcSum(root.left), 0);
        int right = Math.max(calcSum(root.right), 0);

        ans = Math.max(ans, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        calcSum(root);
        return ans;
    }
}
