package com.felix.leecode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author felix
 * @date 2021-04-14 15:40
 */
public class Lee149 {
    public static void main(String[] args) {
        String s="";
        System.out.println(Integer.valueOf('a')-48);
//        System.out.println(gcd(-2, -4));
//        int [][] nums={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int [][] nums={{3,10},{0,2}};
        int[][] nums={{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
        System.out.println(nums.length);
        System.out.println(func(nums));
    }
    public static int func(int[][] points){
        int result=0;
        Map<Ray_Core_Index,Integer> timesmap=new HashMap<>();
//        timesmap.getOrDefault()
        Ray_Core_Index xray = new Ray_Core_Index(1, 0, new BigDecimal(0));
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j <points.length ; j++) {
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                int ygap=y2-y1;
                int xgap=x2-x1;
                if (xgap==0){
                    if (timesmap.containsKey(xray)) {
                        timesmap.put(xray, timesmap.get(xray) + 1);
                    } else {
                        timesmap.put(xray, 1);
                    }
                    break;
                }
                int abs_ygap=Math.abs(ygap);
                int abs_xgap=Math.abs(xgap);

                int gys=abs_ygap>abs_xgap?gcd(abs_ygap,abs_xgap):gcd(abs_xgap,abs_ygap);
                int abs_gys=Math.abs(gys);
                int k_down=xgap/abs_gys;
                int k_up=ygap/abs_gys;
                BigDecimal b=new BigDecimal(y1).subtract(new BigDecimal(k_up).divide(new BigDecimal(k_down),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(x1)));

//              统一底为正数
                if (xgap>0){
                    Ray_Core_Index ray_core_index = new Ray_Core_Index(k_up, k_down, b);
                    if (timesmap.containsKey(ray_core_index)) {
                        timesmap.put(ray_core_index, timesmap.get(ray_core_index) + 1);
                    }
                    else {
                        timesmap.put(ray_core_index, 1);
                    }
                    }
                else {
//                   负数
                    Ray_Core_Index ray_core_index = new Ray_Core_Index(-k_up, -k_down, b);
                    if (timesmap.containsKey(ray_core_index)) {
                        timesmap.put(ray_core_index, timesmap.get(ray_core_index) + 1);
                    }
                    else {
                        timesmap.put(ray_core_index, 1);
                    }
                }

//                int k_up=ygap;



            }
        }
        for(Map.Entry entry:timesmap.entrySet()){
            result=Math.max(result, (Integer) entry.getValue());
        }

        BigDecimal bigDecimal=new BigDecimal(result);
        double tmpdou=result;

        return (int)Math.round(Math.sqrt(tmpdou*2+1/4)+1.0/2);
    }
    public static  int gcd(int x,int y){
        if (y==0){
            return x;
        }
        return gcd(y,x%y);
    }
}

class Ray_Core_Index{
        int k_up;
        int k_down;
        BigDecimal b;
        public Ray_Core_Index(){}
    public Ray_Core_Index(int k_up,int k_down,BigDecimal b){
            this.k_down=k_down;
            this.k_up=k_up;
            this.b=b;
    }
    @Override
    public int hashCode(){
            return k_up*31+k_down*31+b.hashCode();
    }
    @Override
    public boolean equals(Object other){
            if (other==null) {
                return false;
            }
            if (other instanceof Ray_Core_Index){
                Ray_Core_Index tmp= (Ray_Core_Index) other;
                return tmp.k_down==this.k_down&&tmp.k_up==this.k_up&&tmp.b.equals(this.b);
            }else {
                return false;
            }
        }
}

