package thread;

/**
 * 同步方法
 * @author liuyi
 *
 */
class window3 implements Runnable {
	int num = 100;// 共享数据
//	Object obj = new Object();//同步监视器

	public void run() {
		while(true) {
			show();
		}
	}
	
	public synchronized void show() {
		if (num > 0) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
		} 		
	}

}

/**
 * 同步代码块：
 * 
 */
class window2 implements Runnable {
	int num = 100;// 共享数据
//	Object obj = new Object();//同步监视器

	public void run() {
		while (true) {
			synchronized (this) {
				if (num > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
				} else {
					break;
				}
			}
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class window extends Thread {
	static int num = 100;// 共享数据
	static Object obj = new Object();// 同步监视器

//	public void run() {
//		while(true) {
//			show();
//		}
//	}
//	
//	public synchronized void show() {
//		if (num > 0) {
//			try {
//				Thread.currentThread().sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
//		} 		
//	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (window.class) {

				if (num > 0) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
				} else {
					break;
				}

			}
		}
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		return true;
	}
}

class PrintNum1 implements Runnable {
	public void run() {
		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "线程de: = " + i);
		}
	}

}

class window1 implements Runnable {
	int num = 100;

	public void run() {
		while (true) {
			if (num > 0) {
//				try {
//					Thread.currentThread().sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(Thread.currentThread().getName() + "" + "售票: " + num--);
			} else {
				break;
			}
		}
	}

}

public class TestThread1 {
	public static void main(String[] args) {
		window w1 = new window();
		window w2 = new window();
		window w3 = new window();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();

//		PrintNum1 p = new PrintNum1();
//		Thread t1 = new Thread(p);
//		t1.start();
//		Thread t2 = new Thread(p);
//		t2.start();
		window3 ww1 = new window3();
		Thread t1 = new Thread(ww1);
		Thread t2 = new Thread(ww1);
		Thread t3 = new Thread(ww1);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

//		t1.start();
//		t2.start();
//		t3.start();
	}
}
