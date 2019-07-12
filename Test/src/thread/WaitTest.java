package thread;

//WaitTest.java的源码
class ThreadA extends Thread{
	Object obj = new Object();
 public ThreadA(String name) {
     super(name);
 }

 public void run() {
     synchronized (obj) {
         System.out.println(Thread.currentThread().getName()+" call notify()");
         // 唤醒当前的wait线程
//         notify();
     }
 }
 public synchronized void play() {
	 System.out.println("test");
 }
}



public class WaitTest {

 public static void main(String[] args) {

     ThreadA t1 = new ThreadA("t1");
     synchronized(t1.obj) {
         try {
             // 启动“线程t1”
             System.out.println(Thread.currentThread().getName()+" start t1");
             t1.start();

             // 主线程等待t1通过notify()唤醒。
             System.out.println(Thread.currentThread().getName()+" wait()");
             t1.obj.wait();

             System.out.println(Thread.currentThread().getName()+" continue");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

class ThreadQ extends Thread{
	  ThreadA t1;
	  
	public ThreadQ(ThreadA t1) {
		super();
		this.t1 = t1;
	}

	public void run() {
		synchronized(t1) {
	         try {
	             // 启动“线程t1”
	             System.out.println(Thread.currentThread().getName()+" start t1");
	             t1.start();

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