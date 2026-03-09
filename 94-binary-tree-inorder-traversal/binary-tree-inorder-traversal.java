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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        while(curr!=null || !stack.empty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            curr = node.right;
        }
        return list;
    }
}