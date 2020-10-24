package com.bjpowernode.niuke;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @李永琪
 * @create 2020-10-06 18:56
 */
public class Print {

    //思路：将每一层的节点加入到队列中
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //标记是否是正序打印
        boolean reverse = false;
        //将根节点放入到队列的尾部
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                //正序打印
                if(!reverse){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                //将队列的左右孩子加入队列
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(list.size() > 0){
                result.add(list);
            }
            //取反
            reverse = !reverse;
        }
        return result;
    }

}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
