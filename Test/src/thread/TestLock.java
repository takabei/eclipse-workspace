package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Lock
 * 	lock()获得锁
 * 	unlock()释放锁
 * @author liuyi
 *
 */
class window4 implements Runnable {
	int num = 100;// 共享数据
	private ReentrantLock lock = new ReentrantLock();
//	Object obj = new Object();//同步监视器

	public void run() {
		while(true) {
			//获取锁
			lock.lock();
			if (num > 0) {
				try {
					Thread.currentThread().sleep(10);
					TimeUnit.MILLISECONDS.sleep(100);
					System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
				} catch (InterruptedException e) {
					System.out.println(e);
				}finally {
					//释放锁
					lock.unlock();
				}	
			} 	
		}
	}
}
class Lock {
	
}
class Lock1{
	
}
class DeadLock implements Runnable{

	@Override
	public void run() {
		synchronized(Lock.class) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "第一层");
			
			synchronized(Lock1.class) {
				System.out.println(Thread.currentThread().getName()+"第二层");
			}
		}
	}
	
}
class DeadLock1 implements Runnable{

	@Override
	public void run() {
		synchronized(Lock1.class) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "第一层");
			
			synchronized(Lock.class) {
				System.out.println(Thread.currentThread().getName()+"第二层");
			}
		}
	}
	
}

public class TestLock {

//	@Test
//	public void testdeadLock() {
//		DeadLock1 deadLock1 = new DeadLock1();
//		DeadLock deadLock = new DeadLock();
//		Thread t1 = new Thread(deadLock);
//		Thread t2 = new Thread(deadLock1);
//		t1.setName("对象1");
//		t2.setName("对象2");
//		
//		t1.start();
//		t2.start();
//	}
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();
	
	public static void main(String[] args) {
//		DeadLock1 deadLock1 = new DeadLock1();
//		DeadLock deadLock = new DeadLock();
//		Thread t1 = new Thread(deadLock);
//		Thread t2 = new Thread(deadLock1);
//		t1.setName("对象1");
//		t2.setName("对象2");
//		
//		t1.start();
//		t2.start();
		new Thread() {
			public void run() {
				synchronized(sb1) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A");
					synchronized(sb2) {
						System.out.println("B");
					}
				}
			};
		}.start();

		new Thread() {
			public void run() {
				synchronized(sb2) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("C");
					synchronized(sb1) {
						System.out.println("D");
					}
				}
			};
		}.start();
	}
	
//	public static void main(String[] args) {
//		window4 ww1 = new window4();
//		Thread t1 = new Thread(ww1);
//		Thread t2 = new Thread(ww1);
//		Thread t3 = new Thread(ww1);
//
//		t1.setName("窗口1");
//		t2.setName("窗口2");
//		t3.setName("窗口3");
//
//		t1.start();
//		t2.start();
//		t3.start();
//	}
}
