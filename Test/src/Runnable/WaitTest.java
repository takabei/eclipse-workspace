package Runnable;

//WaitTest.java的源码
class ThreadA extends Thread{
	Object obj = new Object();

 public ThreadA(String name) {
     super(name);
 }

 public void run() {
     synchronized (this) {
         System.out.println(Thread.currentThread().getName()+" call notify()");
         // 唤醒当前的wait线程
//         obj.notify();
     }
 }
}
//class ThreadB extends Thread{
//	ThreadA threadA;
//	public ThreadB(String str, ThreadA threadA) {
//		super(str);
//		this.threadA = threadA;
//	}
//	@Override
//	public void run() {
//		while(true) {
//			synchronized(threadA) {
//				try {
//					Thread.currentThread().sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				try {
//					threadA.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName());
//			}
////			threadA.notify();
//		}
//	}
//}
public class WaitTest {

 public static void main(String[] args) {

     ThreadA t1 = new ThreadA("t1");
//     ThreadB t2 = new ThreadB("t2", t1);

     synchronized(t1) {
         try {
             // 启动“线程t1”
             System.out.println(Thread.currentThread().getName()+" start t1");
             t1.start();
//             t2.start();
             // 主线程等待t1通过notify()唤醒。
             System.out.println(Thread.currentThread().getName()+" wait()");
             t1.wait();

             System.out.println(Thread.currentThread().getName()+" continue");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}