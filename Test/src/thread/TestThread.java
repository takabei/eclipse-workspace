package thread;

import org.junit.Test;

class test implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());	
	}
	
}

class SubThread extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + "线程de: = " + i);
		}
			
	}
}

public class TestThread {
	
	/*
	 * Thread的常用方法
	 * 1.start():启动线程；执行run方法
	 * 2.run():子线程要执行的代码
	 * 3.currentThread():static 获取当前线程
	 * 	4.getName():获取线程的名字
	 * 	5.setName():设置线程的名字
	 * 	6.yield(): 调用此方法的线程释放当前CPU的执行权
	 * 	7.join():在A线程中调用B线程的join()方法，表示：
	 * 		当执行到此方法是，A线程停止执行，直至B线程执行完毕，
	 * 		A线程再接着join()方法之后的代码执行
	 * 	8.isAlive():判断线程是否存活
	 * 	9.sleep(long l):显示的让当前线程睡眠l毫秒
	 * 10.线程通信：wait() notify() notifyAll() 
	 * 
	 * 11.设置线程优先级
	 * 	getPriority()
	 * 	setPriority(int newPriority):改变线程的优先级
	 */
	@Test
	public void test1() {
		Thread t1 = new Thread(new test());
		t1.setName("a");
		Thread t2 = new Thread(new test());
		t2.setName("b");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
	}
	
//	@Test
//	public void test() throws InterruptedException {
//		
//		SubThread subThread = new SubThread();
//		subThread.setName("22222");
//		subThread.setDaemon(true);
////		subThread.setPriority(Thread.MIN_PRIORITY);
//		
//		
//		SubThread subThread1 = new SubThread();
//		subThread1.setName("33333");
//
//		System.out.println("subThread.start();前");
//		subThread.start();
//		System.out.println("subThread.start();后");
//		subThread.join();
//		System.out.println("subThread1.start();前");
//		subThread1.start();
//		System.out.println("subThread1.start();后");
//		
//		for(int i = 0; i <= 10; i++) {
//			System.out.println(Thread.currentThread().getName() + "主线程: = " + i);
////			if(i % 10 == 0)
////				Thread.currentThread().yield();
////			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
////			if(i == 20)
////				subThread.join();
//			
//		}
//		
//	}
//	
}
