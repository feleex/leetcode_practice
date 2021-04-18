package com.felix.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author felix
 * @date 2021-03-27 15:55
 */
public class HW2 {
    public static void main(String[] args) {
        List<Integer> cost=new ArrayList<>();

        String[] timecost;

        int cpu=0;
        int mission=0;
        Scanner sc = new Scanner(System.in);
        String inputstring;
        String[] first=sc.nextLine().split(" ");
        cpu=Integer.valueOf(first[0]);
        int [] result=new int[cpu];
        mission=Integer.valueOf(first[1]);
        timecost=sc.nextLine().split(" ");
        int length=timecost.length;
        int[] costint=new int[length];
        int[] sortedint=new int[length];
        for (int i = 0; i < length; i++) {
            costint[i]=Integer.valueOf(timecost[i]);
        }
         Arrays.sort(costint);

            for (int i = 0; i <length ; i++) {
                int flag=i%cpu;
                result[flag]+=costint[i];
            }
            Arrays.sort(result);

        System.out.println(result[cpu-1]);


//        while((inputstring=sc.nextLine())!=null&&!"".equals(inputstring)){
//            String[] array=inputstring.split(",");
//            list.add(array);
//        }
    }
}
