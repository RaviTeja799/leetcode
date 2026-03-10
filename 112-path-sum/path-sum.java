class Solution {

    public boolean helper(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        return helper(root.left, sum, targetSum) || helper(root.right, sum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }
}