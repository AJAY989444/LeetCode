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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return Create(inorder,0,inorder.length - 1, postorder, 0,postorder.length - 1);
    }

    public TreeNode Create(int[] in,int ilo,int ihi,int[] post,int plo, int phi) {
        if(plo > phi || ilo > ihi) {
            return null;
        }

        TreeNode node = new TreeNode(post[phi]);

        int idx = search(in,ilo,ihi,post[phi]);

        int noe = idx - ilo;

        node.left = Create(in,ilo,idx - 1, post,plo,plo + noe - 1);
        node.right = Create(in,idx + 1, ihi, post, plo + noe,phi - 1);

        return node;

    }

    public int search(int[] in, int ilo, int ihi, int item) {
        for(int i = ilo; i <= ihi; i++) {
            if(item == in[i]) {
                return i;
            }
        }
        return -1;
    }
}