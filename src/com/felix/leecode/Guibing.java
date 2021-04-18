package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-03-29 15:30
 */
public class Guibing {
    public static void main(String[] args) {
        int[] ints = {5, 12, 4, 323, 5, 1};
        int[] result=new_guibingsort(ints,0,5);

        System.out.println(Arrays.toString(result));

    }
    public static int[] paixu(int[] array){
        int length=array.length;
        if (length<=1){
            return array;
        }

        return array;
    }
    public static int[] guibingsort(int[] array){

        int length=array.length;
        if (length<=1){
            return array;
        }
        int mid=length/2;
        int[] resultarry = new int[length];
        int[] left=new int[mid];
        int[] right=new int[length-mid];
        for (int i = 0; i <length ; i++) {
            int p=0,q=0;
            if (p<left.length&&left[p]<=right[q]){
                resultarry[i]=left[p];
                p++;
            }else {
                resultarry[i]=right[q];
                q++;
            }
        }
        return resultarry;

    }
    public static void new_guibingsort_abandon(int[] array,int low,int high){
        if (low>=high){
            return;
        }else if(high-low==1){
            if (array[low]>array[high]){
                int tmp=array[low];
                array[low]=array[high];
                array[high]=tmp;
            }
            return;
        }
        int mid=(high-low)/2+low;
        new_guibingsort(array,low,mid);
        new_guibingsort(array,mid+1,high);
        int high_start=mid+1;
        while (low<=mid|high_start<=high){
            if (array[low]<=array[high_start]){
                low++;
            }else {

                int tmp=array[low];
                array[low]=array[high_start];
                array[high_start]=tmp;
                high_start++;
            }
        }
    }
    public static int[] new_guibingsort(int[] array,int low,int high){
        if (low>=high){
            return new int[]{array[low]};
        }else if(high-low==1){
            if (array[low]>array[high]){
                int tmp=array[low];
                array[low]=array[high];
                array[high]=tmp;
            }
            return new int[]{array[low],array[high]};
        }
        int mid=(high-low)/2+low;
        int[] left=new_guibingsort(array,low,mid);
        int[] right=new_guibingsort(array,mid+1,high);
        int[] resultarray=new int[high-low+1];
        int leftsize=left.length;
        int rightsize=right.length;
        int i=0,j=0;
        while(i<leftsize&&j<rightsize){
            if (left[i]<=right[j]){
                resultarray[i+j]=left[i];
                i++;
            }else {
                resultarray[i+j]=right[j];
                j++;
            }
        }
        while(i==leftsize&&j<rightsize){
            resultarray[i+j]=right[j];
            j++;
        }
        while(j==rightsize&&i<leftsize){
            resultarray[i+j]=left[i];
            i++;
        }
        return resultarray;
    }
}
