package thread;

public class MyThread implements Runnable {

	private int ticket = 100;

	public void run() {
//synchronized(ticket){ 为什么不用这个同步块命令
		while (ticket > 0) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ticket-- + " is saled by " + Thread.currentThread().getName());
		}
//}

	}

	public static void main(String[] args) {
		MyThread m = new MyThread();
		Thread t1 = new Thread(m, "Window 1");
		Thread t2 = new Thread(m, "Window 2");
		Thread t3 = new Thread(m, "Window 3");
		t1.start();
		t2.start();
		t3.start();
	}
}