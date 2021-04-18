package com.felix.leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author felix
 * @date 2021-03-28 13:59
 */

public class Demo328 {
    public static void main(String[] args) throws Exception {
//        int[] intlist=new int[]{1,2,3,4};
//        Random random=new Random();
//        int length=intlist.length;
//        for (int i = 0; i <10 ; i++) {
//            for (int j = 0; j <length ; j++) {
//                intlist[j]=random.nextInt(10);
//
//            }
//            Thread.sleep(random.nextInt(1000));
//            System.out.print("\r"+ Arrays.toString(intlist));

//        }
        printresourceload();
    }
//    @Test
    public   void test1() throws InterruptedException {
        int[] intlist=new int[]{1,2,3,4};
        Random random=new Random();
        int length=intlist.length;
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <length ; j++) {
                intlist[j]=random.nextInt(10);

            }
            Thread.sleep(random.nextInt(1000));
            System.out.print("\r"+ Arrays.toString(intlist));
        }

    }

    public static void printresourceload() throws  Exception{
        ExecutorService service= Executors.newFixedThreadPool(10);
        Random random=new Random();
        CountDownLatch latch=new CountDownLatch(10);
        String[] stringlist=new String[10];
        int length=stringlist.length;
        for (int j = 0; j <length ; j++) {
            int k=j;
            service.submit(()->{
                for (int i = 0; i <100 ; i++) {
                    stringlist[k]=i+1+"%";
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("");
                    System.out.print("\r"+Arrays.toString(stringlist));
                }
                latch.countDown();
            });
        }

        service.shutdown();
        latch.await();
        System.out.println("加载完成");
    }

}
