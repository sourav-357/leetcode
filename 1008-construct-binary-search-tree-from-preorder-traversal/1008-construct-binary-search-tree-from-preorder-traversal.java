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
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int upperBound) {

        if (idx == preorder.length)
            return null;

        if (preorder[idx] > upperBound)
            return null;

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;

        root.left = build(preorder, root.val);
        root.right = build(preorder, upperBound);

        return root;
    }
}