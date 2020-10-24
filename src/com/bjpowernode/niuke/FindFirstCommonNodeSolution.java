package com.bjpowernode.niuke;

import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-06 23:10
 */
public class FindFirstCommonNodeSolution {

    //找出两个链表中的第一个公共节点
    //算法复杂度太高，不符合要求
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead1;
        while (cur != null){
            set.add(cur);
        }
        cur = pHead2;
        while (cur != null){
            if(set.contains(cur)){
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null){
                    p1 = pHead2;
                }
                if(p2 == null){
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

}



