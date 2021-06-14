package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-13 09:31
 */
public class Lee086 {
    public  static  ListNode partition(ListNode head, int x) {
        ListNode firsttmp=new ListNode();
        ListNode secondtmp=new ListNode();
        ListNode first=new ListNode();
        ListNode second=new ListNode();
        ListNode result;
        first.next=firsttmp;
        second.next=secondtmp;
        while (head!=null){
            if (head.val<x){
                firsttmp.next=head;
                firsttmp=firsttmp.next;
            }else {
                secondtmp.next=head;
                secondtmp=secondtmp.next;
            }
            head=head.next;
        }
        secondtmp.next=null;

        firsttmp.next=second.next.next;
        result=first.next.next;
        return result;

    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(4);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(2);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(2);
//        ListNode listNode7=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
//        listNode6.next=listNode7;
        ListNode result=partition(listNode1,3);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
