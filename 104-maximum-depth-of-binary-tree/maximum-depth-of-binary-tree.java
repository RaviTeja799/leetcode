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
    public int maxDepth(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null) return list.size();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = dq.remove();
                level.add(node.val);
                if(node.left!=null) dq.add(node.left);
                if(node.right!=null) dq.add(node.right);
            }
            list.add(level);
        }
        return list.size();
    }
}