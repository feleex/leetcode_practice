package com.felix.leecode;

/**
 * @author felix
 * @date 2021-05-29 22:12
 */
public class Lee034 {
    public static void main(String[] args) {
        int [] nums={5,7,7,8,8,10};
//        int[] nums={};
        CommonUtil.printintarray(dividesearchRange(nums,8));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        int start=-1;
        int end=-1;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==target&&start==-1){
                start=i;
                end=i;
            }else if (nums[i]==target){
                end=i;
            }
        }
        result[0]=start;
        result[1]=end;
    return result;
    }
//    二分法
    public static int[] dividesearchRange(int[] nums, int target){
        int[] result=new int[2];
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int start=findtargetstart(nums,0,nums.length-1,target);
        int end=findtargetend(nums,0,nums.length-1,target);
        result[0]=start;
        result[1]=end;
        return result;
    }
    public static int findtargetstart(int [] nums,int low, int high,int target){
        if (low==high){
            if (nums[low]==target){
                return low;
            }
            return -1;
        }
        else {
            int mid=(low+high)/2;
            int di =findtargetstart(nums,low,mid,target);
            if (di!=-1){
                return di;
            }else {
                return findtargetstart(nums,mid+1,high,target);
            }
        }

    }
    public static int findtargetend(int [] nums,int low, int high,int target){
        if (low==high){
            if (nums[low]==target){
                return low;
            }
            return -1;
        }
        else {
            int mid=(low+high)/2;
            int gao=findtargetend(nums,mid+1,high,target);
            if (gao!=-1){
                return gao;
            }else {
                return findtargetend(nums,low,mid,target);
            }
        }

    }
    public static int[] newdividesearchRange(int[] nums, int target){
        int[] result=new int[2];
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int start=findtargetstart(nums,0,nums.length-1,target);
        int end=start;
        for (int i = start+1; i <nums.length ; i++) {
            if (nums[i]==target){
                end=i;
                continue;
            }
            break;
        }
        result[0]=start;
        result[1]=end;
        return result;
    }

}
