package com.felix.leecode;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author felix
 * @date 2021-03-29 11:05
 */
public class TestOptional {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(get2jinzhi(31)));
//        System.out.println(Boolean.TRUE&Integer.MAX_VALUE);
//        Grandpa grandpa1=new Grandpa();
//        Grandpa father=new Father();
//        Grandpa son=new Son();
//        grandpa1.setson(father);
//        father.setson(son);
//        testoptional(grandpa1);

    }
    public static void testoptional(Grandpa grandpa){

        System.out.println(Optional.ofNullable(grandpa.getson()).map(father -> father.getson()).map(son -> son.getname()).orElse("孙子不存在"));
    }

    static class Grandpa{
        Grandpa son;
        String name;
        public Grandpa(){
            name=""+ System.currentTimeMillis();
        }
        public void  setson(Grandpa grandpa){
            this.son=grandpa;

        }
        public Grandpa getson(){
            return son;
        }
        public String getname(){
            return name;
        }
    }
    static class Father extends Grandpa{

    }
    static class Son extends Father{

    }
    public static int[] get2jinzhi(int i){
        int[] result=new int[32];
        int a=1;
        while(i!=0){
            result[32-a]=i&1;
            a++;
            i>>=1;
        }
        return result;

    }}
