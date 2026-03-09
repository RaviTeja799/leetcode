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
    // public void helper (TreeNode root,List<Integer> list) {
    //     if(root == null ) return;
    //     list.add(root.val);
    //     helper(root.left,list);
    //     helper(root.right,list);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
    // List<Integer> list =  new ArrayList<>();
    //     helper(root,list);
    //     return list;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.empty()){
            while(curr!=null){
                list.add(curr.val); 
                if(curr.right!= null) stack.push(curr.right);
                curr = curr.left;
            }
            if(!stack.empty()){
                TreeNode node = stack.pop();
                if(node.right!=null) stack.add(node.right);
                list.add(node.val);
                curr = node.left;
            }
        }
        return list;
    }
}