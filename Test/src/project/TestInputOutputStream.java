package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/*
 * 1.IO的体系
 * 抽象基类			节点流（文件流）
 * InputStream		FileInputStream
 * OutputStream		FileOutputStream
 * Reader			FileReader
 * Writer			FileWriter
 */
public class TestInputOutputStream {

	@Test
	public void testCopyFile() {//270
		long start = System.currentTimeMillis();//获取当前豪秒数
		String src = "qqq.wmv";
		String dest = "bbb.wmv";
		copyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("花费的时间 = " + new SimpleDateFormat("mm:ss").format(new Date(end-start)));
		System.out.println(end-start);
	}
	
	public void copyFile(String src, String desc) {
//		File input = new File("IMG_20100101_124239.jpg");
		File input = new File(src);
//		File output = new File("liuyi.jpg");
		File output = new File(desc);
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(input);
			fileOutputStream = new FileOutputStream(output);
			byte[] b = new byte[1024];
			int len;
			while((len = fileInputStream.read(b)) != -1) {
				//实现文件复制
				fileOutputStream.write(b, 0, len);
				//错误形式: fileOutputStream.write(b);
				//错误形式2: fileOutputStream.write(b,0,b.length);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} finally {
			if(null != fileInputStream)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(null != fileOutputStream)
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileInputOutputStream1() {
//		File input = new File("IMG_20100101_124239.jpg");
		File input = new File("liuyi.txt");
//		File output = new File("liuyi.jpg");
		File output = new File("liuyi1.txt");
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(input);
			fileOutputStream = new FileOutputStream(output);
			byte[] b = new byte[20];
			int len;
			while((len = fileInputStream.read(b)) != -1) {
				//实现文件复制
				fileOutputStream.write(b, 0, len);
				//错误形式: fileOutputStream.write(b);
				//错误形式2: fileOutputStream.write(b,0,b.length);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} finally {
			if(null != fileInputStream)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(null != fileOutputStream)
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileInputOutStream() {
		//创建一个File对象，表明要写入的文件位置
		File file = new File("liuyi.txt");
		//创建一个输出流对象（FileOutPutStream)，将File对象作为形参传递
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			//写入操作
			fileOutputStream.write(new String("liuyi的测试文本").getBytes());
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} finally {
			if(null != fileOutputStream)
				try {//关闭输出流
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void test4() {
		File file = new File("hello1.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int len = 0;
			int taotal = 0;
			while( (len = fileInputStream.read(b,taotal,10)) != -1) {
				taotal += len;
			}
			for(int i = 0; i < taotal; i++)
				System.out.print((char)b[i]);
		} catch(Exception e) {
			
		} finally {
			try {
				if(fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//对test2进行改进
	@Test
	public void test3(){
		File file = new File("src/asdf.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byte[] b = new byte[5];//读取数据要写入的数组
			int len;//每次读入到byte【】中的字节的长度        
			while((len = fileInputStream.read(b)) != -1) {
				//不能使用b.length 否则会造成重复读
//				for(byte b1 : b)
//					System.out.print((char)b1);
				
//				for(int i = 0; i < len; i++)
//					System.out.print((char)b[i]);
				
				String str = new String(b,0,len,"UTF-8");
				System.out.print(str);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//对test进行改进
	@Test
	public void test2() {
		File file = new File("src/asdf.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			int b;
			while ((b = fileInputStream.read()) != -1) {
				System.out.print((char)b);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {//关闭稀缺资源
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 从硬盘存在的一个文件中读取其内容到程序中
	 * FileInputStream
	 */
	@Test
	public void test() throws IOException {
		File file = new File("/home/liuyi/eclipse-workspace/Test/src/asdf.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		int i = -1;
		while((i = fileInputStream.read()) != -1) {
			System.out.print((char)i);
		}
		//关闭相应的流
		fileInputStream.close();
	}
	
	@Test
	public void test1() throws IOException {
		//FileInputStream无法处理中文 处理的字节最大为256，中文比这个大
		//FileReader可以处理字符 故用于处理中文
		File file = new File("/home/liuyi/eclipse-workspace/Test/src/asdf.txt");
		FileReader fileReader = new FileReader(file);
		int i = -1;
		while((i = fileReader.read()) != -1) {
			System.out.print((char)i);
		}
		//关闭相应的流
		fileReader.close();
	}
}
