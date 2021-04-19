package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-19 20:51
 */
public class Lee019 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        System.out.println(removeNthFromEnd(listNode1, 2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode=new ListNode();
        int times=0;

        ListNode quicknode=head;
        ListNode slownode=head;

//      双指针，1条速度1，1条速度2，2到达终点时经过t步，如果t>n，则1再经t-n，如果t<n，指针3从头开始，经2t-n
        while (quicknode.next!=null&&quicknode.next.next!=null){
            times++;
            slownode=slownode.next;
            quicknode=quicknode.next.next;
        }
//      剩下一半
        int rest_half=times;
        if (quicknode.next!=null){
//      链表长度为偶数
            rest_half++;
        }
        int rest_times=0;
//      在后半段
        if (rest_half>=n){
            rest_times=rest_half-n+1;
            while (rest_times>1){
                slownode=slownode.next;
                rest_times--;
            }
            slownode.next=slownode.next.next;
            listNode=head;
        }else if (rest_half+times+1>n){
            rest_times=times+rest_half-n+1;
            ListNode newnode=head;
            while (rest_times>1){
                newnode=newnode.next;
                rest_times--;
            }
            newnode.next=newnode.next.next;
            listNode=head;
        }else {
            listNode=head.next;
        }
        return listNode;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString(){
            StringBuffer sb=new StringBuffer();
            sb.append(val);
            ListNode tmp=this;
            while (tmp.next!=null){
                sb.append(tmp.next.val);
                tmp=tmp.next;
            }
            return sb.toString();
        }
    }
}
