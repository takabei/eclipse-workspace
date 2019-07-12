package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;

public class TestOtherStream {

	@Test
	public void testDataInput() {
		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		try {
			fileInputStream = new FileInputStream("dataoutput.txt");
			dataInputStream = new DataInputStream(fileInputStream);
//			byte[] b = new byte[20];
//			int len;
//			while((len = dataInputStream.read(b)) != -1) {
//				System.out.println(new String(b,0,len));
//			}
			/**
			 * 必须按照写入的顺序进行读取
			 */
			System.out.println(dataInputStream.readUTF());
			System.out.println(dataInputStream.readUTF());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readBoolean());
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (null != dataInputStream)
				try {
					dataInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/*
	 * 数据流 DataInputStream DataOutputStream
	 */
	@Test
	public void testDataInputOutputStream() {
		File file = new File("dataoutput.txt");
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			dataOutputStream = new DataOutputStream(fileOutputStream);
			// 输出
			dataOutputStream.writeUTF("你猜猜我是谁？我在干什么");
			dataOutputStream.writeUTF("你能看见这句话吗？很好");
			dataOutputStream.writeDouble(2.333);
			dataOutputStream.writeBoolean(false);
			dataOutputStream.flush();
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (null != dataOutputStream)
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@Test
	public void test4() throws Exception {
		PrintWriter pw = new PrintWriter(new File("aaaa.txt"));
		/*
		 *  public PrintWriter(File file) throws FileNotFoundException {
        		this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))),
             	false);
    }
		 */
		pw.println();
		PrintWriter pw1 = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								new File("aaaa.txt"))));
	}

	/*
	 * 打印流 字节流：PrintStream 字符流:PrintWriter
	 */
	@Test
	public void test3() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("hello1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// 创建打印输出流，
		// 设置为自动刷新模式（写入换行符或者字节'\n',时都会刷新输出缓冲区
		PrintStream ps = new PrintStream(fos, true);
		if (ps != null) {// 设置输出位置
			System.setOut(ps);
		}
		for (int i = 0; i <= 255; i++) {
			System.out.print((char) i);
			if (i % 50 == 0)// 每50个数据一行
				System.out.println();
		}
		// ps.flush();//PrintStream ps = new PrintStream(fos, true);
		// 打印流具有自动flush()功能
		ps.close();// 打印流关闭不会抛出异常
	}

	/*
	 * 标准的输入输出流： 输出:System.out 打印到控制台 输入流：System.in 从键盘输入
	 */
	@Test
	public void test2() throws IOException {
		/*
		 * 将字符串中的小写字母转换成大写 除非遇到e/exit否则不退出
		 */
		InputStream in = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inputStreamReader);
		try {
			inputStreamReader = new InputStreamReader(in);
			br = new BufferedReader(inputStreamReader);
			String str;
			while (true) {
				System.out.println("请输入字符串");
				str = br.readLine();
				if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					break;
				} else {
					String str1 = str.toUpperCase();
					System.out.println(str1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			br.close();
		}

	}

	/*
	 * 转换流: InputStreamReader OutputStreamWriter 编码：由字符串--》字节数组 解码：由字节数组--》字符串
	 */
	@Test
	public void test1() {
		File file = new File("hello1.txt");
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		File file1 = new File("OutputStreamWriterhello2.txt");
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			// 解码
			fileInputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
			bufferedReader = new BufferedReader(inputStreamReader);

			// 编码
			fileOutputStream = new FileOutputStream(file1);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
			bufferedWriter = new BufferedWriter(outputStreamWriter);

//			char[] c = new char[1024];
//			int len;
//			while((len = inputStreamReader.read(c)) != -1) {
//				String str = new String(c, 0, len);
//				System.out.println(str);
//				bufferedWriter.write(c, 0, len);
//			}

			String str;
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
				bufferedWriter.write(str + "\n");
				bufferedWriter.flush();// 保险操作
			}

		} catch (Exception e) {
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
}
