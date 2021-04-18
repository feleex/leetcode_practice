package com.felix.leecode;
import java.util.List;
import java.util.Scanner;
/**
 * @author felix
 * @date 2021-04-05 09:36
 */
public class Rongyao {


        public static void main(String[] args) {
            function();
//            String example="Note that the only valid version of the GPL as far as this project is concerned is _this_ particular version of the license (ie v2, not v2.2 or v3.x or whatever), unless explicitly otherwise stated.";
//            Scanner in = new Scanner(System.in);
//            String input="";
//            input=in.nextLine();
//
//            String origin=input.split(",")[0];
//            int index=input.indexOf(",")+1;
//
//            String newone=input.substring(index);
//            System.out.println("newone.size()="+newone.length()+"======"+newone);
//            if (example.contains(origin)){
//                System.out.println(example.replaceAll(origin,newone));
//            }else {
//                System.out.println("warning:is not find!");
//            }


    }
    public static void demo2(){
        Scanner in = new Scanner(System.in);
        String[] aarra=in.nextLine().split(",");
        String[] barra=in.nextLine().split(",");
//        List<String> alist=
    }
//    public static boolean dp(String[] array){
//
//
//    }
    public static int getzhuanzhe(int[] array){
            if (array.length<=1){
//                无转折
                return 0;

            }
            int result=0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>=array[i+1]){
                result++;
            }
        }
        return result;
    }
    public static int getfirstzhuanzhe(int[] array){
        if (array.length<=1){
//                无转折
            return -1;

        }

        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>=array[i+1]){
                return i;
            }
        }
        return -1;
    }
    public static int gettransfernum(int[] array){
            int result=0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i]>=array[j]){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    public static void function(){
        Scanner in = new Scanner(System.in);

    String firstinput=in.nextLine();
    String secondinput=in.nextLine();
    String[] firstarray=firstinput.split(",");
    String[] secondarray=firstinput.split(",");
    int[] first=new int[firstarray.length];
    int[] second=new int[secondarray.length];
        for (int i = 0; i < firstarray.length; i++) {
        try {
            first[i]=Integer.valueOf(firstarray[i].substring(1));
        }
        catch (Exception e){
            String string=firstarray[i].substring(1);
            if ("J".equals(string)){
                first[i]=11;
            }else if("Q".equals(string)){
                first[i]=12;
            }else {
                first[i]=13;
            }
        }
    }
        for (int i = 0; i < secondarray.length; i++) {
        try {
            second[i]=Integer.valueOf(secondarray[i].substring(1));
        }catch (Exception e){
            String string=firstarray[i].substring(1);
            if ("J".equals(string)){
                first[i]=11;
            }else if("Q".equals(string)){
                first[i]=12;
            }else {
                first[i]=13;
            }
        }
    }
    int aresult=gettransfernum(first);
    int aindex=getfirstzhuanzhe(first);
        if ((aresult+aindex+1)%2==1){
        System.out.println("Y");
    }else {
        System.out.println("N");
    }
    int bresult=gettransfernum(second);
    int bindex=getfirstzhuanzhe(second);
        if ((bresult+aindex+1)%2==1){
        System.out.println("Y");
    }else {
        System.out.println("N");
    }
}
}
