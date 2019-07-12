package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {

	/*
	 * 实现文本文件的修改
	 */
	@Test
	public void test2() {
		File file = new File("aaaa.txt");
//		File file2 = new File("bbbb.txt");
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.seek(4);
			StringBuffer sb = new StringBuffer();
			byte[] b = new byte[1024];
			int len;
			while((len = randomAccessFile.read(b)) != -1) {
				sb.append(new String(b,0,len));
			}
			randomAccessFile.seek(4);
			randomAccessFile.write("之前是我错了 对不起".getBytes());
			randomAccessFile.write(sb.toString().getBytes());
//			randomAccessFile.writeBoolean(true);
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} finally {
			if(randomAccessFile != null)
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/*
	 * RandomAccessFile r
	 */
	@Test
	public void test1() {
		File file = new File("aaaa.txt");
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
//			System.out.println(randomAccessFile.readBoolean());
			byte[] b = new byte[1024];
			int len;
			while((len = randomAccessFile.read(b)) != -1) {
				System.out.println(new String(b,0,len));
				
//				for(int i = 0; i < len; i++)
//					System.out.println((char)b[i]);
			}
		}catch(IOException e) {
			System.out.println(e);
		} finally {
			if(randomAccessFile != null)
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
