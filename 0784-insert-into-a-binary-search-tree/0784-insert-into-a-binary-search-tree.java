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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Base case: if the root is null, create a new node with the given value
        if (root == null) {
            return new TreeNode(val);
        }

        // If the value to insert is less than the root's value, insert into the left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } 
        // If the value to insert is greater than the root's value, insert into the right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the unchanged root node pointer
        return root;
    }
}