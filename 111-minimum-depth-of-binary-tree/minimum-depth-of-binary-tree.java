class Solution {
    public int minDepth(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null) return list.size();
        dq.add(root);
        int depth = 1;
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = dq.remove();
                if(node.left == null && node.right==null) return depth;
                level.add(node.val);
                if(node.left!=null) dq.add(node.left);
                if(node.right!=null) dq.add(node.right);
            }
            list.add(level);
            depth++;
        }
        return list.size();
    }
}