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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0, nums.length - 1);
    }

    public TreeNode build(int[] arr, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = st + (end-st) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = build(arr,st, mid - 1);
        node.right = build(arr,mid + 1, end);

        return node;
    }
}