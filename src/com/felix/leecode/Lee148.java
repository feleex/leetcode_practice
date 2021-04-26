package com.felix.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-14 10:31
 */
public class Lee148 {
    public static void main(String[] args) {
        ListNode input=null;
//        ListNode input=new ListNode(4);
//        input.next=new ListNode(2);
//        input.next.next=new ListNode(1);
//        input.next.next.next=new ListNode(3);
        ListNode output=sortList(input);
        printlist(output);
    }

    private static void printlist(ListNode output) {
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head==null){
            return head;
        }
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int[] nums=new int[list.size()];
        for (int i = 0; i <nums.length ; i++) {
            nums[i]=list.get(i);
        }
        Arrays.sort(nums);
        ListNode result=new ListNode(nums[0]);
        ListNode tmp=result;
        for (int i = 1; i < nums.length; i++) {
            tmp.next=new ListNode(nums[i]);
            tmp=tmp.next;
        }
        return result;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      @Override
     public String toString(){
          ListNode tmp=this;
          StringBuffer sb=new StringBuffer();
          do {
              sb.append(tmp.val);
              tmp=tmp.next;
          }while (tmp!=null);
          return sb.toString();
      }
  }