package thread;

class Clerk{
	private int num = 20;

	public Clerk(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public synchronized  void get() {
		if(num > 0) {
			notify();
			System.out.println(Thread.currentThread().getName() + "消費了第: " + num + "產品");
			num--;
		}else{
			try {
				System.out.println("num = " + num);
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
//		if(num <= 0) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}else {
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + "消費了了第: " + num + "產品");
//			num--;
//			notify();
//		}
	}
	
	public synchronized  void save() {
		if(num < 20) {
			notify();
			++num;
			System.out.println(Thread.currentThread().getName() + "生產了第: " + num + "產品");
		}else {
			try {
				System.out.println("num = " + num);
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
//		if(num >= 20) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}else {
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			num++;
//			System.out.println(Thread.currentThread().getName() + "生產了第: " + num + "產品");
//			notify();
//		}
	}
}

class Customer implements Runnable{
	private Clerk clerk;
	
	public Customer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}
	@Override
	public void run() {
		while(true) {
			clerk.get();
		}
	}
	
}

class Productor implements Runnable{
	private Clerk clerk;
	
	public Productor(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while(true) {
			clerk.save();
		}
	}
	
}

public class TestExcirse {
	public static void main(String[] args) {
		Clerk clerk = new Clerk(10);
		Productor productor = new Productor(clerk);
		Customer customer = new Customer(clerk);
		
		
		Thread t1 = new Thread(productor);
		Thread t2 = new Thread(customer);
		
		t1.setName("生產者");
		t2.setName("消費者");
		
		t1.start();
		t2.start();
	}
}
