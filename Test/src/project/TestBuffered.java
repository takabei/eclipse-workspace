package project;
/*
 * * 1.IO的体系
 * 抽象基类			节点流（文件流）		缓冲流(处理流的一种)
 * InputStream		FileInputStream		BufferedInputStream
 * OutputStream		FileOutputStream	BufferedOutputStream  flush()）
 * Reader			FileReader			BufferedReader
 * Writer			FileWriter			BufferedWriter		（flush()）
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestBuffered {

	@Test
	public void testBufferedReader() {
		File file = new File("hello1.txt");
		File file1 = new File("newBufferedWriter.txt");
		FileReader fileInputStream = null;
		FileWriter fileWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileInputStream = new FileReader(file);
			bufferedReader = new BufferedReader(fileInputStream);
			fileWriter = new FileWriter(file1);
			bufferedWriter = new BufferedWriter(fileWriter);
//			char[] c = new char[1024];
//			int len;
//			while((len = bufferedReader.read(c)) != -1) {
//				String str = new String(c,0,len);
//				System.out.println(str);
//			}
			String str = null;
			while((str = bufferedReader.readLine()) != null) {
				System.out.println(str);//打印到控制台
				bufferedWriter.write(str + "\n");
//				bufferedWriter.newLine();//重新起一行
				bufferedWriter.flush();//保险操作
			}
			
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testCopyFile() {//190
		long start = System.currentTimeMillis();//获取当前豪秒数
		String src = "qqq.wmv";
		String dest = "bbb.wmv";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("花费的时间 = " + new SimpleDateFormat("mm:ss").format(new Date(end-start)));
		System.out.println(end-start);
	}
	
	public void copyFile(String src, String dest) {
		File input = new File(src);
		File output = new File(dest);
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(input));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(output));
			byte[] b = new byte[1024];
			int len;
			while((len = bufferedInputStream.read(b)) != -1) {
				bufferedOutputStream.write(b, 0, len);
				bufferedOutputStream.flush();//保险操作
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e );
		} finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testBufferedInputOutputtream() {
		File input = new File("IMG_20100101_124239.jpg");
		File output = new File("Bufferedliuyi.jpg");
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(input));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(output));
			byte[] b = new byte[1024];
			int len;
			while((len = bufferedInputStream.read(b)) != -1) {
				bufferedOutputStream.write(b, 0, len);
				bufferedOutputStream.flush();//保险操作
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e );
		} finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
