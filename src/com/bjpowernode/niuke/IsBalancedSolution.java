package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-10-07 11:46
 */
public class IsBalancedSolution {

    public boolean isBalanced_Solution(TreeNode root) {

        return depth(root) != -1;
    }

    //求出树的高度
    public int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        if(left == -1){
            return -1;
        }
        int right = depth(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }else{
            return 1 + (left > right ? left : right);
        }
    }

}
