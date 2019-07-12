package thread;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Test;

class IOThread implements Runnable{
	InputStream in;
	
	public IOThread(InputStream in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bufferedWriter = null;
		String str;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File("TesThreadANDIO.txt")));;
			while((str = bufferedReader.readLine()) != null) {
				bufferedWriter.write(str+"\n");
				bufferedWriter.flush();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
}

public class TesThreadANDIO {
	@Test
	public void test1() {
		Thread t1 = new Thread(new IOThread(System.in));
		t1.setDaemon(true);
		t1.start();
		for(int i = 0; i <10; i++) {
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("主线程: " + i);
		}
	}

}
