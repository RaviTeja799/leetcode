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
    public TreeNode insert(TreeNode root, int val) {
        TreeNode node = root;
        if(node == null){
                TreeNode temp = new TreeNode(val);
                return temp;
        }
        if (node.val < val) {
            node.right =  insert(node.right, val);
        }
        if (node.val > val) {
            node.left = insert(node.left, val);
        }
        return node;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val < val)
            root.right = insert(root.right, val);
        else
            root.left =  insert(root.left, val);
        return root;
    }
}