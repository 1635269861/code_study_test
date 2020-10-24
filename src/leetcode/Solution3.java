package leetcode;

/**
 * @李永琪
 * @create 2020-10-18 13:33
 */

public class Solution3 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = removeNthFromEnd(listNode, 2);
        System.out.println(listNode1);
    }

    //删除倒数第k个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0){
            return head;
        }

        //获取链表的长度
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }

        ListNode temp = head;
        //求删除第几个就是把指针往后移 len-n-1 个单位
        if(n == len){
            return head.next;
        }

        for (int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }
        if(n == 1){
            temp.next = null;
        }else{
            temp.next = temp.next.next;
        }
        return head;
    }

}
