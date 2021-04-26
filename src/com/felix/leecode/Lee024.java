package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-25 14:20
 */
public class Lee024 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
//        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(swapPairs(head));
    }
    public static ListNode swapPairs(ListNode head) {

        ListNode result_new=new ListNode();
        result_new.next=head;
        ListNode tmp=result_new.next;
        ListNode begin=result_new;
        while (tmp!=null){
            if (tmp.next!=null){
                ListNode node=tmp.next;
                tmp.next=node.next;
                node.next=tmp;
                begin.next=node;
                begin=tmp;
            }
            tmp=tmp.next;
        }
        return result_new.next;
    }
}
