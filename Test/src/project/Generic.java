package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

class A{
	
}
class B extends A{
	
}


public class Generic {
	
	public  void add(List<? extends A> list) {
		
	}
	public List<? extends A>  getA() {
		return null;
		
	}
	public void add1(List<? super A> list) {
		
	}
	public List<? super A>  getA1() {
		return null;
		
	}
	@Test
	public void test1() {
		List<?> list = null;
		List<? extends A> list1 = new ArrayList<A>();
		List<? super A> list2 = new ArrayList<>();
		List<A> list3 = new ArrayList<A>();
		List<B> list4 = new ArrayList<B>();
		List<Object> list5 = new ArrayList<Object>();
		
		Generic generic = new Generic();
//		generic.add(list);
		generic.add(list1);
//		generic.add(list2);
		generic.add(list3);
		generic.add(list4);
//		generic.add(list5);
		list = generic.getA();
		list1 = generic.getA();
//		list2 = generic.getA();
//		list3 = generic.getA();
//		list4 = generic.getA();
//		list5 = generic.getA();
		
//		generic.add1(list);
//		generic.add1(list1);
		generic.add1(list2);
		generic.add1(list3);
//		generic.add1(list4);
		generic.add1(list5);
		list = generic.getA1();
//		list1 = generic.getA1();
		list2 = generic.getA1();
//		list3 = generic.getA1();
//		list4 = generic.getA1();
//		list5 = generic.getA1();
		
	}
	@Test
	public void test66() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put(null, "");
		map = new Hashtable<String, Object>();
		map.put(null,"111");
		map = new TreeMap<String, Object>();
//		map.put(null, "");

	}
}
