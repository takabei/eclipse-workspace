package thread;

class PrintNum implements  Runnable{
	int num = 1;
	Object obj = new Object();
	@Override
	public void run() {
		while(true) {
			synchronized(obj) {
				notify();
				if(num <= 10) {
					System.out.println(Thread.currentThread().getName() + ":" + num++);
				}else
					break;
				try {
					obj.wait();
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				System.out.println(Thread.currentThread().getName() + "= wait之後");
				System.out.println("你真的在執行馬");
			}
		}
	}
	
}

public class TestWait {
	public static void main(String[] args) {
		PrintNum printNum = new PrintNum();
		Thread t1 = new Thread(printNum);
		Thread t2 = new Thread(printNum);
		
		t1.setName("線程1");
		t2.setName("線程2");
		
		t1.start();
		t2.start();
	}
}
