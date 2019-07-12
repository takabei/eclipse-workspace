package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
 * 對象的序列化過程，將內存中的對象通過ObjectOutputStream轉換為二進制流 存儲在硬盤中
 * 
 * @author liuyi
 *
 */
public class TestObjectInputOutputStream {

	@Test
	public void testObjectInputStream() {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(
					new FileInputStream(
							new File("Object.txt")));
			Person p1 = (Person)objectInputStream.readObject();
			System.out.println(p1);
			Person p2 = (Person)objectInputStream.readObject();
			System.out.println(p2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objectInputStream != null)
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

	@Test
	public void testObjectOutputStream() {
		Person p1 = new Person("小米", 10);
		Person p2 = new Person("红米", 7);
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("Object.txt"));
			objectOutputStream.writeObject(p1);
			objectOutputStream.flush();
			objectOutputStream.writeObject(p2);
			objectOutputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null)
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}

class Person implements Serializable {
	String name;
	Integer age;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
