package com.bjpowernode.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-06 20:47
 */
public class KthNodeSolution {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    //给定一棵二叉搜索树，请找出其中的第k小的结点。
    TreeNode kthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        }
        preOrder(pRoot);
        if(k > list.size()){
            return null;
        }
        int[] nums = new int[list.size()];
        int index = 0;
        for (TreeNode node : list) {
            nums[index] = node.val;
            index++;
        }
        Arrays.sort(nums);
        int val = nums[k - 1];
        TreeNode resNode = null;
        for (TreeNode treeNode : list) {
            if(treeNode.val == val){
                resNode = treeNode;
            }
        }
        return resNode;


    }

    //中序遍历将各个节点添加到集合当中
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

}
