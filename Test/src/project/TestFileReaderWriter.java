package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {

	@Test
	public void testFileReaderWriter() {
		File input = new File("liuyi.txt");
		File output = new File("newliuyiWriter.txt");
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader(input);
			fileWriter = new FileWriter(output);
			char[] cbuf = new char[1024];
			int len;
			while((len = fileReader.read(cbuf)) != -1) {
				fileWriter.write(cbuf, 0, len);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test2() {
		File file = new File("liuyiReader.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write("我去你马的");
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			
		} finally {
			if(null != fileWriter)
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void test3() {
		File file = new File("liuyi1.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			char[] cbuf = new char[1024];
			int len;
			while((len = fileReader.read(cbuf)) != -1) {
//				for(int i = 0; i < len; i++)
//					System.out.print(cbuf[i]);
				String str = new String(cbuf,0,len);
				System.out.println(str);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test1() {
		File file = new File("liuyi1.txt");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			int len;
			while((len = fileReader.read()) != -1) {
				System.out.print((char)len);
			}
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			
		} finally {
			if(null != fileReader)
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
