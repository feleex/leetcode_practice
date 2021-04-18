
import java.util.concurrent.locks.LockSupport;

/**
 * @author felix
 * @date 2021-03-20 10:13
 */
public class Niming {

    public static void main(String[] args) throws  Exception {
        jiaoti();
//        Thread.sleep(4000);
//        Object o = new Object();
////        System.out.println((ClassLayout.parseInstance(o).toPrintable()));
//        log.debug((ClassLayout.parseInstance(o).toPrintable()));
//        o.hashCode();
//        log.debug((ClassLayout.parseInstance(o).toPrintable()));
//        synchronized (o){
//            log.debug((ClassLayout.parseInstance(o).toPrintable()));
//        }
//        log.debug((ClassLayout.parseInstance(o).toPrintable()));
    }
    public static void jiaoti(){
        Thread t1=null,t2 = null;

        int a=100;
        t1=new Thread(()->{
            int b=a;

            LockSupport.park();
            System.out.println(++b);
//        LockSupport.unpark(finalT2);
            System.out.println("hhhh");
        });
//        t2=new Thread(()->{
//            LockSupport.park();
//            System.out.println(1);
//            LockSupport.unpark(finalT1);
//        });
//        Thread finalT1 = t1;
//        Thread finalT2 = t2;
        t1.start();
//        t2.start();
        LockSupport.unpark(t1);

    }}
