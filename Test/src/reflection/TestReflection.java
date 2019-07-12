package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import reflection.po.Person;

public class TestReflection {
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception, SecurityException {
//		Class claz = Class.forName("reflection.po.Person");
//		Person p = (Person) claz.newInstance();
		
		Class<Person> clazz = Person.class;
		Person p = clazz.newInstance();
		
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(p, "刘德华");
		
		Method method = clazz.getMethod("show");
		method.invoke(p);
		Method method1 = clazz.getMethod("display", String.class);
		method1.invoke(p,"中国");
		Method method2 = clazz.getMethod("toString");
		method2.invoke(p);
		
	}
	
	//反射之前创建一个对象，并调用其中的方法、属性
	@Test
	public void test1() {
		Person p = new Person("刘义",23);
		p.show();
		p.display("中国");
		System.out.println(p);
	}
}
