class Element{
    int sum;
    TreeNode node;
    Element(TreeNode node , int sum){
        this.sum = sum;
        this.node = node;
    }
}



class Solution {

    // public boolean helper(TreeNode root, int sum, int targetSum) {
    //     if (root == null) return false;
    //     sum += root.val;
    //     if (root.left == null && root.right == null) {
    //         return sum == targetSum;
    //     }
    //     return helper(root.left, sum, targetSum) || helper(root.right, sum, targetSum);
    // }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // return helper(root, 0, targetSum);
        if(root == null) return false;
        Deque<Element> dq = new ArrayDeque<>();
        dq.offer(new Element(root, root.val));
        while(!dq.isEmpty()){
            Element curr = dq.poll();
            if(curr.node.left == null && curr.node.right == null && curr.sum == targetSum) return true;
            if(curr.node.left != null) dq.offer(new Element(curr.node.left, curr.sum+curr.node.left.val));
            if(curr.node.right != null) dq.offer(new Element(curr.node.right, curr.sum+curr.node.right.val));
        }
        return false;
    }
}