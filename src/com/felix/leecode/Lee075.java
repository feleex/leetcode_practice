package com.felix.leecode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author felix
 * @date 2021-06-10 23:04
 */
public class Lee075 {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        method3(nums);
        CommonUtil.printintarray(nums);
    }
    public  static  void sortColors(int[] nums) {
        List<Integer> list0=new LinkedList<>();
        List<Integer> list1=new LinkedList<>();
        List<Integer> list2=new LinkedList<>();
        for (int i = 0; i <nums.length; i++) {
            switch (nums[i]){
                case 0:
                    list0.add(0);
                    break;
                case 1:
                    list1.add(1);
                    break;
                default:
                    list2.add(2);
                    break;
            }
        }
        list0.addAll(list1);
        list0.addAll(list2);
        for (int i = 0; i <nums.length ; i++) {
            nums[i]=list0.get(i);
        }
    }
    public  static  void method2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int index=0;
        for (int i = 0; i <3 ; i++) {
            int times=map.getOrDefault(i,0);
            for (int j = 0; j <times ; j++) {
                nums[index]=i;
                index++;
            }
        }

    }
    public static void method3(int[] nums){
        if (nums.length==0){
            return;
        }
        int[] result=new int[nums.length];
        guibing(nums,0,nums.length-1,result);
//        System.arraycopy(result,0,nums,0,nums.length);
    }
    public static void guibing(int[] nums,int low,int high,int[] result){
        if (high-low<=0){
            return;
        }else if (high-low==1){
            if (nums[low]>nums[high]){
                int tmp=nums[low];
                nums[low]=nums[high];
                nums[high]=tmp;
            }
            return;
        }
        int mid=low+(high-low)/2;
        guibing(nums,low,mid,result);
        guibing(nums,mid+1,high,result);
        int tmplow1=low;
        int tmplow2=mid+1;
        int index=low;
        while (tmplow1<=mid&&tmplow2<=high){
            if (nums[tmplow1]<nums[tmplow2]){
                result[index]=nums[tmplow1];
                tmplow1++;
            }else {
                result[index]=nums[tmplow2];
                tmplow2++;
            }
            index++;
        }
        while (tmplow1<=mid){
            result[index]=nums[tmplow1];
            tmplow1++;
            index++;
        }
        while (tmplow2<=high){
            result[index]=nums[tmplow2];
            tmplow2++;
            index++;
        }
        System.arraycopy(result,low,nums,low,high-low+1);
    }
}
