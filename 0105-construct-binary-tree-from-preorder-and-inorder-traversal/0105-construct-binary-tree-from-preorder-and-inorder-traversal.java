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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Create(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    public TreeNode Create(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
        if(plo > phi || ilo > ihi) {
            return null;
        }

        TreeNode node = new TreeNode(pre[plo]);
        int idx = Search(in,ilo,ihi,pre[plo]);

        int noe = idx - ilo;

        node.left = Create(pre,plo + 1, plo + noe,in,ilo, idx - 1);
        node.right = Create(pre, plo + noe + 1,phi,in,idx + 1, ihi);

        return node;

    }

    public int Search(int[] in, int ilo, int ihi, int item) {
        for(int i = ilo; i <= ihi; i++) {
            if(in[i] == item) {
                return i;
            }
        }

        return 0; // Never runs
    } 
}