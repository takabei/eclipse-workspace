package thread;

class Customer2 implements Runnable{
	Account account;

	public Customer2(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 3; i++) {
			account.saveBalance(1000.0);
//			account.saveMoney(1000.0);
		}
	}
	
}

class Customer1 extends Thread{
	Account account;

	public Customer1(Account account) {
		super();
		this.account = account;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 3; i++) {
			account.saveBalance(1000.0);
//			account.saveMoney(1000.0);
		}
	}
	
}

class Account {
	double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	public synchronized void saveMoney(double balance) {
		this.balance += balance;
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.balance);
	}
	
	public void saveBalance(double balance) {
		synchronized(this){
			this.balance += balance;
			try {//sleep即使阻塞当前线程也不会释放同步监视器
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + this.balance);
		}
	}
	
}

public class TestThreadExcreise {

	public static void main(String[] args) {
		//Thread
		Account account = new Account(0);
		Customer1 customer1 = new Customer1(account);
		Customer1 customer2 = new Customer1(account);
		customer1.setName("账户1");
		customer2.setName("账户2");
		customer1.start();
		customer2.start();
		
		//Runnable
//		Customer2 customer2 = new Customer2(new Account(0));
//		Thread t1 = new Thread(customer2);
//		Thread t2 = new Thread(customer2);		
//		t1.setName("账户1");
//		t2.setName("账户1");
//		t1.start();
//		t2.start();

	}
}
