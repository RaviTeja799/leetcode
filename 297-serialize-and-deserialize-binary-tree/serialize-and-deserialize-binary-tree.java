/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    if (root == null) return "";
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    
    while (!q.isEmpty()) {
        TreeNode node = q.poll();
        if (node == null) {
            sb.append("&,");
        } else {
            sb.append(node.val).append(",");
            q.offer(node.left);   // offer even if null
            q.offer(node.right);
        }
    }
    return sb.toString();
}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (!arr[i].equals("&")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("&")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));