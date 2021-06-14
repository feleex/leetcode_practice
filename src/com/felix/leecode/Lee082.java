package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-12 23:53
 */
public class Lee082 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(2);
//        ListNode listNode4=new ListNode(3);
//        ListNode listNode5=new ListNode(4);
//        ListNode listNode6=new ListNode(4);
//        ListNode listNode7=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        listNode5.next=listNode6;
//        listNode6.next=listNode7;
        ListNode result=newdeleteDuplicates(listNode1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode tmpresult=new ListNode();
        ListNode lastresult=tmpresult;
        ListNode tmpnode=head;
        boolean flag=false;
        int tmp=Integer.MIN_VALUE;
        while (head!=null){
//            重新开始计数
            if (tmp==Integer.MIN_VALUE){
                if (head.next==null){
                    tmpresult.next=tmpnode;
                }else if (head.val==head.next.val){
                    tmp=head.val;
                    head=head.next.next;
                    tmpnode=tmpnode.next.next;
                }
            }else {
                if (head.val==tmp){
                        head=head.next;
                        tmpnode=tmpnode.next;

                }else {
                    if (head.next!=null){
                        if (head.val!=head.next.val){
                            tmpresult.next=tmpnode;
                            head=head.next;
                            tmpnode=tmpnode.next;
                            tmp=Integer.MIN_VALUE;
                        }else {
                            head=head.next.next;
                            tmpnode=tmpnode.next.next;
                        }
                    }else {
                        tmpresult.next=tmpnode;
                    }
                }
            }
        }
        return lastresult.next;
    }
    public static ListNode newdeleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode tmpresult=new ListNode();
        ListNode lastresult=tmpresult;
        ListNode tmpnode=head;
        boolean flag=false;
        int tmp=Integer.MIN_VALUE;
        while (head!=null){
//            重新开始计数
//          没有前驱限制
            if (tmp==Integer.MIN_VALUE&&head.next==null){
                tmpresult.next=tmpnode;
                tmpresult=tmpresult.next;
                head=head.next;
//                结束
            }else if (tmp!=Integer.MIN_VALUE&&head.next==null){
                if (head.val!=tmp){
                    tmpresult.next=tmpnode;
                    tmpresult=tmpresult.next;

                }
                head=head.next;
            }else if(tmp==Integer.MIN_VALUE&&head.next!=null){
                if (head.val!=head.next.val){
                    tmpresult.next=tmpnode;
                    tmpresult=tmpresult.next;
                }else {
                    tmp=head.val;
                }
                head=head.next;
                tmpnode=tmpnode.next;
//                有前驱有后继
            }else {
                if (head.val!=tmp){
                    if (head.next.val!=head.val){
                        tmpresult.next=tmpnode;
                        tmpresult=tmpresult.next;
                        tmp=Integer.MIN_VALUE;
                    }else {
                        tmp=head.val;
                    }
                }
                head=head.next;
                tmpnode=tmpnode.next;
            }
        }
        if (tmp!=Integer.MIN_VALUE){
            tmpresult.next=null;
        }
        return lastresult.next;
    }
}
