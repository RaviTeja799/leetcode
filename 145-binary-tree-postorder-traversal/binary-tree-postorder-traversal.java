class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        Collections.reverse(list);
        return list;
    }
}