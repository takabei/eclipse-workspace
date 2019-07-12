package project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestIO {

	@Test
	public void test4() throws IOException {
		/*
		 * 文件操作/目录操作相关
		 * createNewFile()
		 * delete()
		 * mkDir()
		 * mkDirs()
		 * list()
		 * listFiles()
		 */
		File file = new File("io1/hello1.txt");
		File directory = new File("io1");
		if(file.exists())
			System.out.println("file.delete() = " + file.delete());
		System.out.println("file.createNewFile() = " + file.createNewFile());
		if(!directory.exists())
			System.out.println(directory.mkdir());
		System.out.println("file.list() = " + file.list());
//		System.out.println("directory.list() = " + directory.list());
		for(String str : directory.list())
			System.out.println(str);
	}
	
	@Test
	public void test3() {
		/*
		 * 文件检测
		 * 获取文件常规信息
		 */
		File file = new File("io1");
		System.out.println("file.exists() = " + file.exists());
		System.out.println("file.canWrite() = " + file.canWrite());
		System.out.println("file.canRead() = " + file.canRead());
		System.out.println("file.isFile() = " + file.isFile());
		System.out.println("file.isDirectory() = " + file.isDirectory());
		//返回文件最后修改日期
		System.out.println("file.lastModified() = " + file.lastModified());
		System.out.println(new SimpleDateFormat("yyyy/MM/dd hh/mm/ss").format(new Date(file.lastModified())));
		System.out.println("file.length() = " + file.length());
	}
	
	@Test
	public void test2() throws IOException {
		/*
		 * 获取文件名
		 * /home/liuyi/eclipse-workspace/Test/src/asdf.txt
		 * /home/liuyi/eclipse-workspace/src/asdf.txt
		 */
		File file = new File("src/asdf.txt");
		File file2 = new File("/home/liuyi/eclipse-workspace/Test/io2");
		System.out.println("文件名 = " + file.getName());
		System.out.println("目录名 = " + file2.getName());
		System.out.println("上层目录 = " + file.getParent());
		System.out.println("上层目录 = " + file2.getParent());
		System.out.println("相对路径 = " + file.getPath());
		System.out.println("相对路径 = " + file2.getPath());
		System.out.println("绝对路径 = " + file.getAbsolutePath());
		System.out.println("绝对路径 = " + file2.getAbsolutePath());
		System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());
		System.out.println("file2.getAbsoluteFile() = " + file2.getAbsoluteFile());
//		System.out.println(file.renameTo(new File("qwe11r.txt")));
		
		System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
		System.out.println("file2.getCanonicalPath() = " + file2.getCanonicalPath());
//		System.out.println(file2.renameTo(new File("io1")));
	}
	
	@Test
	public void test1() {
		Set set = new TreeSet();
		File file = new File("src/hello.txt");
		System.out.println(file.canWrite());
		System.out.println(file.canExecute());
		System.out.println(file.canRead());
		System.out.println(file.exists());
		/*
		 * public boolean equals(Object obj) {
		        if ((obj != null) && (obj instanceof File)) {
		            return compareTo((File)obj) == 0;
		        }
		        return false;
	    	}
		 */
		System.out.println(file.compareTo(null));
	}
	
	@Test
	public void test77() {
		System.out.println(new SimpleDateFormat("yyMMddmmssSS").format(new Date()));
	}
}
