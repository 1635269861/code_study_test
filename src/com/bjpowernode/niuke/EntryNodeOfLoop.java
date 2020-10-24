package com.bjpowernode.niuke;

import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-06 19:55
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null){
            if(set.contains(cur)){
                break;
            }else{
                set.add(cur);
            }
            cur = cur.next;
        }
        return cur;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
