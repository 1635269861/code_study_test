package com.bjpowernode.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @李永琪
 * @create 2020-10-06 20:06
 */
public class SerializeSolution {

    //使用层次遍历完成二叉树的序列化
    String Serialize(TreeNode root) {
        String result = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null){
                    result += "#,";
                    continue;
                }
                result += node.val + "!,";
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result;
    }

    //使用层次遍历完成二叉树的反序列化
    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        if(str.charAt(0) == '#'){
            return null;
        }
        String[] strs = str.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty() && index < strs.length){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if(node == null){
                    continue;
                }
                index++;
                if(index >= strs.length  || strs[index].equals("#")){
                    TreeNode leftNode = null;
                    node.left = leftNode;
                }else{
                    TreeNode leftNode = new TreeNode(Integer.valueOf(strs[index]));
                    node.left = leftNode;
                }
                index++;
                if(index >= strs.length || strs[index].equals("#")){
                    TreeNode rightNode = null;
                    node.right = rightNode;
                }else{
                    TreeNode rightNode = new TreeNode(Integer.valueOf(strs[index]));
                    node.right = rightNode;
                }
                if(index >= strs.length)
                    break;
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
        }

        //构造头结点

        return root;
    }

}
