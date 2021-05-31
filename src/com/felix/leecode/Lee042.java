package com.felix.leecode;

/**
 * @author felix
 * @date 2021-05-30 16:16
 */
public class Lee042 {

    public static void main(String[] args) {
        int[] height={4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        if (height.length<=2){
            return 0;
        }else {
            return recrusionTrap(height,0,height.length-1);
        }

    }
    public static int recrusionTrap(int[] height,int start,int end){
        if (end-start<=1){
            return 0;
        }
        if (height[end]<=height[end-1]){
            return recrusionTrap(height,0,end-1);
        }else {
            int tmp=end;
            int maxhighindex=Integer.MIN_VALUE;
            int maxhigh=Integer.MIN_VALUE;
            for (int i = start; i <end; i++) {
                if (maxhigh<height[i]){
                    maxhighindex=i;
                    maxhigh=height[i];
                }
            }

            for (int i = end-1; i >=start ; i--) {
                if (height[i]>=height[end]){
                    tmp=i;
                    break;
                }
            }
//          最新值比之前的所有列都大
            if (tmp==end){
//                求出之前最大值到新值之间的雨水量
                int lastrain=0;
                int sum_to_delete=0;
                for (int i = maxhighindex+1; i <end ; i++) {
                    sum_to_delete+=height[i];
                }
                int sum_rain=(end-maxhighindex-1)*maxhigh;
                lastrain=sum_rain-sum_to_delete;
                return recrusionTrap(height,start,maxhighindex)+lastrain;
            }
//          最新值比之前某个值小
            else {
                int lastrain=0;
                int sum_to_delete=0;
                for (int i = tmp+1; i <end ; i++) {
                    sum_to_delete+=height[i];
                }
                int sum_rain=(end-tmp-1)*height[end];
                lastrain=sum_rain-sum_to_delete;
                return recrusionTrap(height,start,tmp)+lastrain;
            }
        }
    }
}
