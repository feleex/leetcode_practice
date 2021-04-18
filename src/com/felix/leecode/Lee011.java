package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-08 17:11
 */
public class Lee011 {
    public static void main(String[] args) {
        int[]  a={1,8,6,2,5,4,8,3,7};
        int[] b=new int[a.length-1];
        System.arraycopy(a,0,b,0,a.length-1);
//        System.out.println(Arrays.toString(b));
//        System.out.println(new Lee011().maxArea(a));
        System.out.println(newmax(a));
    }
    public static int func(int[] height){
        if (height.length<=1){
            return 0;
        }else if (height.length==2){
            return Math.min(height[0],height[1]);

        }else {

            int[] preheight = new int[height.length - 1];

            System.arraycopy(height,0,preheight,0,height.length-1);
            int result=func(preheight);
            for (int i = 0; i <preheight.length ; i++) {
                result=Math.max((preheight.length-i)*Math.min(height[height.length-1],height[i]),result);
            }

            return result;
        }

    }
    public int maxArea(int[] height) {
        if (height.length<=1){
            return 0;
        }else if (height.length==2){
            return Math.min(height[0],height[1]);

        }else {
            int[] preheight = new int[height.length - 1];
            System.arraycopy(height,0,preheight,0,height.length-1);
            int result=func(preheight);
            for (int i = 0; i <preheight.length ; i++) {
                result=Math.max((preheight.length-i)*Math.min(height[height.length-1],height[i]),result);
            }

            return result;
        }
    }
    public static  int newmax(int[] height){
        if (height.length<=1){
            return 0;
        }else if (height.length==2){
            return Math.min(height[0],height[1]);

        }else {
            int low_index=0;
            int high_index=height.length-1;
            int low=height[low_index];
            int high=height[high_index];
            int result=Math.min(low,high)*(high_index-low_index);
            while (low_index<high_index){
                if (low<high){
                    if (height[++low_index]>low){
                        low=height[low_index];
                        result=Math.max(result,Math.min(low,high)*(high_index-low_index));
                    }
                }else {
                    if (height[--high_index]>high){
                        high=height[high_index];
                        result=Math.max(result,Math.min(low,high)*(high_index-low_index));
                    }
                }
            }
            return result;
        }
    }
}
