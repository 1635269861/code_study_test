package leetcode;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * @李永琪
 * @create 2020-10-16 21:56
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode listNode2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stackOfl1 = new Stack<>();
        Stack<Integer> stackOfl2 = new Stack<>();
        ListNode cur = l1;
        while (cur != null){
            stackOfl1.add(cur.val);
            cur = cur.next;
        }

        cur = l2;
        while (cur != null){
            stackOfl2.add(cur.val);
            cur = cur.next;
        }

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        while (!stackOfl1.isEmpty()){
            str1.append(stackOfl1.pop());
        }

        while (!stackOfl2.isEmpty()){
            str2.append(stackOfl2.pop());
        }


        int res1 = Integer.parseInt(new String(str1));
        int res2 = Integer.parseInt(new String(str2));

        int res = res1 + res2;
        String s = String.valueOf(res);
        ListNode resNode = new ListNode();
        ListNode temp = resNode;
        for (int i = s.length() - 1; i >= 0; i--) {
            String substring = s.substring(i, i + 1);
            int parseInt = Integer.parseInt(substring);
            ListNode listNode = new ListNode();
            listNode.val = parseInt;
            resNode.next = listNode;
            resNode = resNode.next;
        }

        return temp.next;
    }

    @Test
    public void test1(){
        StringBuilder stringBuilder = new StringBuilder("123456789");
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
