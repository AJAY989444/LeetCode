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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        pre(ll,root);
        return ll;
    }

    public void pre(List<Integer> ll, TreeNode root) {

        if(root == null) {
            return;
        }

        ll.add(root.val);

        pre(ll,root.left);
      
        pre(ll,root.right);
    }
}