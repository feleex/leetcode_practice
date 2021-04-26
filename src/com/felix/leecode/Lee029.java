package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-25 15:34
 */
public class Lee029 {
    public static void main(String[] args) {
//        System.out.println(divide_new(-2147483648, -1));
//        System.out.println(-2147483648^-1);
        System.out.println(-2147483648==Integer.MIN_VALUE);
        System.out.println(-(-2147483648));
//        System.out.println(2147483647+1);
        System.out.println(Math.abs(-2147483648));
    }
    public static int divide(int dividend, int divisor) {
        String flag="";
        if ((dividend^divisor)<0){
//            一正一负
            flag="-";
        }
        int result=0;
        long tmp_result=0;
        long longdividend=dividend;
        long longdivisor=divisor;
        longdividend=Math.abs(longdividend);
        longdivisor=Math.abs(longdivisor);
        long tmp=0;
        while ((tmp=longdividend-longdivisor)>=0){
            tmp_result++;
            result++;
            longdividend=tmp;
        }
        if (tmp_result>Integer.MAX_VALUE||tmp_result<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        result=Integer.valueOf(flag+result);
        return result;
    }
    public static int divide_new(int dividend, int divisor) {
        String flag="";
        if ((dividend^divisor)<0){
//            一正一负
            flag="-";
        }
        int result=0;
        long tmp_result=0;
        long longdividend=dividend;
        long longdivisor=divisor;
        longdividend=Math.abs(longdividend);
        longdivisor=Math.abs(longdivisor);

        long element=longdivisor;
        while ((longdividend-element)>=0){
            int bitsize=0;
            if (longdividend>=element){
                while (longdividend>=(element<<1)){
                    element=element<<1;
                    bitsize++;
                }
                longdividend-=(long)longdivisor<<bitsize;
                result+=1<<bitsize;
                tmp_result+=(long)1<<bitsize;
                element=longdivisor;
            }
        }
        long real_result=Long.valueOf(flag+tmp_result);
        if (real_result>Integer.MAX_VALUE||real_result<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        result=Integer.valueOf(flag+Math.abs(tmp_result));
        return result;
    }
}
