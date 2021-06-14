package com.felix.leecode;

import java.util.List;

/**
 * @author felix
 * @date 2021-06-12 23:43
 */
public class Lee083 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode result=head;
        int tmp=head.val;
        while (head.next!=null){
            if (tmp==head.next.val){
//                跳到下一个节点
                head.next=head.next.next;
            }else {
                tmp=head.next.val;
                head=head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(2);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        deleteDuplicates(listNode1);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }

}
