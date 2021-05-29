package com.felix.leecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author felix
 * @date 2021-05-20 16:47
 */
public class Lee056 {
    public static void main(String[] args) {
        int[][] ints={{15,18},{2,6},{1,3},{8,10}};
        int[][] intslist=merge(ints);
        for (int[] ints1 : intslist) {
            String result="";
            for (int i = 0; i <ints1.length ; i++) {
                result+=ints1[i];
            }
            System.out.println(result);
        }
    }
//    先按数组首位排序，再遍历
    public static int[][] merge(int[][] intervals) {
        List<int[]> intslist=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intslist.add(intervals[i]);
        }
        intslist.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> resultlist=new ArrayList<>();
        int[] tmp=intslist.get(0);
        for (int i = 1; i <intervals.length ; i++) {
            if (tmp[1]>=intslist.get(i)[0]){
                tmp[1]=Math.max(tmp[1],intslist.get(i)[1]);
            }else {
                resultlist.add(tmp);
                tmp=intslist.get(i);
            }
        }
        resultlist.add(tmp);
        int[][] resultints=new int[resultlist.size()][2];
        for (int i = 0; i <resultlist.size() ; i++) {
            resultints[i]=resultlist.get(i);
        }
        return resultints;
    }
}
