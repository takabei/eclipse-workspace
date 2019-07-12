package reflection;

import org.junit.Test;

import reflection.po.Person;
public class TestClass {
	
	/**
	 * 如何获取Class的实例
	 * 
	 */
	@Test
	public void test() {
		//1.调用运行时类本身的.class属性
		Class clazz = String.class;
		System.out.println(clazz);
		//2.调用运行时类的实例的getClass()方法
		Person p = new Person();
		Class<? extends Person> class1 = p.getClass();
		System.out.println(class1);
	}
}
