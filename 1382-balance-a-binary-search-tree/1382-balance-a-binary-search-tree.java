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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        convert(root, list);
        return build(list, 0, list.size() - 1);
    }

    private void convert(TreeNode node, ArrayList<Integer> list) {
        
        if (node == null)
            return;

        convert(node.left, list);
        list.add(node.val);
        convert(node.right, list);
    }

    private TreeNode build(ArrayList<Integer> list, int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low)/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, low, mid - 1);
        root.right = build(list, mid + 1, high);

        return root;
    }
}