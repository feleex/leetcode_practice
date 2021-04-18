package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
/**
 * @author felix
 * @date 2021-03-27 15:07
 */
public class HW {
    public static void main(String[] args) {

        int money=300;
        int realmoney=300;
        List<String[]> list=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String inputstring;
        int cishu=3;
        while((inputstring=sc.nextLine())!=null&&!"".equals(inputstring)){

            String[] array=inputstring.split(",");
            list.add(array);
//            cishu--;
//            if (cishu==0){
//                break;
//            }
        }

//        while(sc.hasNextLine()){
//
//             inputstring=sc.nextLine();
//             if ("\n".equals(inputstring)){
//                 break;
//             }
//            String[] array=inputstring.split(",");
//            list.add(array);
//        }
        int booknum=list.size();
        for (int i = 0; i < booknum; i++) {
            int[] temp=new int[2];
            temp=newpredictborrowleft_start(Integer.valueOf(list.get(i)[0]),Integer.valueOf(list.get(i)[1]),Integer.valueOf(list.get(i)[2]),money,realmoney);
            money=temp[0];
            realmoney=temp[1];
        }
        System.out.println(realmoney);

//        System.out.println(ans);
    }

    public static int getcost(int value,int days){
        int predictcost=0;
         if (value>=100){
            if (days>=15) {
                predictcost=15*5+(days-15)*3;
            }else {
                predictcost=days*5;
            }
//          50-100
        }else if(value>=50){
            if (days>=15) {
                predictcost=15*3+(days-15)*2;
            }else {
                predictcost = days * 3;
            }
        }
//        小于50
        else {
            predictcost=days*1;
        }
        return predictcost;
    }

    public static int[] newpredictborrowleft_start(int value,int predictdays,int realdays,int restmoney,int realmoney){
        int[] start_end_rest=new int[2];
        int realrestmoney=0;
        int predictrestmoney=0;
        int predictcost=0;
        int realcost=0;
        if (value>restmoney){
            start_end_rest[0]=restmoney;
            start_end_rest[1]=restmoney;
//           100以上
        }else {
            predictcost=getcost(value,predictdays);
            if (realdays>predictdays){
                realcost=getcost(value,realdays)+(realdays-predictdays);
            }else {
                realcost=getcost(value,realdays);
            }
        }
        predictrestmoney=restmoney-Math.min(value,predictcost);
        realrestmoney=realmoney-Math.min(value,realcost);
        start_end_rest[0]=predictrestmoney;
        start_end_rest[1]=realrestmoney;
        return start_end_rest;
    }
}
