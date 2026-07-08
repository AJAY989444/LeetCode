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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        post(ll,root);
        return ll;
    }

    public void post(List<Integer> ll, TreeNode root) {

        if(root == null) {
            return;
        }

        post(ll,root.left);

        post(ll,root.right);

        ll.add(root.val); 
    }
}