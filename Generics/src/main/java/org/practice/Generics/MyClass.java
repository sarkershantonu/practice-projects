package org.practice.Generics;

import java.util.ArrayList;
import java.util.List;

class MyClass<T, U> {

	private T first;
	private List<T> values = new ArrayList<T>();
	private NastedClass<Integer> myNested = new NastedClass<Integer>(); 
	private U second;
	


	private MyClass<T, U> items = new MyClass<T, U>(null,null);
	
	public  <K> MyClass(K key, T first, U second, List<? extends K> items) {
		this.first = first;
		this.second = second;
		
		
	}
	public MyClass(T first, U second) {
		this.first = first;
		this.second = second;
	}
	private static class NastedClass<V>{
		
	}

}
