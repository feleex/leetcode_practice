package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-13 14:49
 */
public class Lee152 {

    public static void main(String[] args) {
        int[] nums={2,3,-2,4};

        int[] maxdp=new int[nums.length];
        int[] mindp=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            maxdp[i]=nums[i];
            mindp[i]=nums[i];
        }
        for (int i = 0; i <nums.length ; i++) {
            getmaxdp(nums,i,maxdp,mindp);
        }
//        getmaxdp(nums,nums.length-1,maxdp,mindp);
        int result=Integer.MIN_VALUE;
        for (int num:maxdp){

            result=Math.max(result,num);
        }
        System.out.println(result);
    }
//
    public static  int func(int[] nums){
        int result=0;



        return result;
    }

    /**
     *
     * @param nums  数组
     * @param index 以index位数结尾
     * @return  返回数组以index位数结尾的最大值
     */
    public static void getmaxdp(int[] nums,int index,int maxdp[],int mindp[]){
        if (index==0){
            maxdp[index]=nums[index];
            mindp[index]=nums[index];
            return;
        }
        if (nums[index]>0){
            maxdp[index]=Math.max(maxdp[index-1]*nums[index],nums[index]);
            mindp[index]=Math.min(mindp[index-1]*nums[index],nums[index]);
        }else if (nums[index]<0){
            maxdp[index]=Math.max(mindp[index-1]*nums[index],nums[index]);
            mindp[index]=Math.min(maxdp[index-1]*nums[index],nums[index]);
        }else {
            maxdp[index]=0;
            mindp[index]=0;
        }
    }

}
