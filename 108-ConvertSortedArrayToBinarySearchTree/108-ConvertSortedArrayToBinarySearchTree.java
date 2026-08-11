// Last updated: 11/08/2026, 20:59:25
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
        return Convert(nums,0,nums.length-1);
    }
    public TreeNode Convert(int arr[],int st,int end){
        if(st>end) return null;
        int mid=(st+end)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=Convert(arr,st,mid-1);
        root.right=Convert(arr,mid+1,end);
        return root;
    }
}