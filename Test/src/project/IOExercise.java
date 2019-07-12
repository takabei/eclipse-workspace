package project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class IOExercise {

	@Test
	public void ReaderWriter() {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		//写入到指定文件
		try {
			fileWriter = new FileWriter("io4/test.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("我雕尼玛的 还让我打一堆字呢");
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedWriter != null)
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		//读取 打印到屏幕
		//复制文件
		try {
			fileReader = new FileReader("io4/test.txt");
			bufferedReader = new BufferedReader(fileReader);
			fileWriter = new FileWriter("io4/test");
			bufferedWriter = new BufferedWriter(fileWriter);
			
//			char[] c = new char[1024];
//			int len;
//			while((len = bufferedReader.read(c)) != -1) {
//				String str = new String(c,0,len);
//				System.out.println(str);
//				bufferedWriter.write(str);
//			}
			
			String str;
			while((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
				bufferedWriter.write(str);
				/*
				 *  public void write(String str) throws IOException {
				        write(str, 0, str.length());
				    }
				 */
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null != bufferedReader)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	@Test
	public void InputOutput() {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			
			fileOutputStream = new FileOutputStream("io3/test.txt");
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			
			bufferedOutputStream.write(new String("我去尼玛的 让我打一大堆文字 你想屁吃呢").getBytes());
			
		} catch(FileNotFoundException e) {
			
		} catch(IOException e){
			
		}finally {
			
			if(bufferedOutputStream != null)
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		try {
			fileInputStream = new FileInputStream("io3/test.txt");
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			fileOutputStream = new FileOutputStream("io3/test1.txt");
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			
			byte[] b = new byte[1024];
			int len;
			while((len = bufferedInputStream.read(b)) != -1) {
//				String str = new String(b,0,len);
//				System.out.println(str);
				
//				for(int i = 0; i < len; i++)
//					System.out.print((char)b[i]);
				
				bufferedOutputStream.write(b, 0, len);
				bufferedOutputStream.flush();//保险操作
			} 
		}catch(Exception e) {
			System.out.println(e);
		} finally {
			if(bufferedInputStream != null)
				try {
					bufferedInputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if(bufferedOutputStream != null)
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
}
