package org.practice.Generics;

import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Function;

import javax.swing.event.ListSelectionEvent;

public class Program {

	public static void main(String[] args) {
		ArrayList<String> obj = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
		ArrayList<String> obj2 = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
		ArrayList<String> obj3 = (ArrayList<String>) Arrays.asList("Pratap", "Peter", "Harsh");
		List<String> obj5 = Arrays.asList("Pratap", "Peter", "Harsh");
		System.out.println("Elements are:"+obj);
	}
	
	public <SHANTONU extends App , InterfaceA , InterfaceB> void doit(SHANTONU aT){
		//List<int> items = new ArrayList<>();
		//SHANTONU a = new SHANTONU(); 
		
		Hashtable< String, Integer> set = new Hashtable< String, Integer>(); 
	}
	
	public<T,K> K doSome(T aT, K aK){		
		return aK;
	}
	
	public <T extends InterfaceA> T doSomeWork(List<T> items){
		
		return null;
	}
	
	public static <T, U, K extends Comparable<? super K>> Comparator<T> doCompare(Function<? super U, ? super T> extraction){
		return null;
		
	}
	public <T, U, K > Comparator<T> compare(Function<T, U> extraction){
		
		
		
		return null;
		
	}
	
	public <T extends AbastractA> void doATask(T t){
		
	}
	
	public List<?>  doS(List<? extends App> t){		
		return null;
	}
	
	private class House {
		
	}
	
	public List<? extends Comparable<?>> shortThisList(List<? extends Comparable<?>> items){
		
		
		return null;
		
	}
	public <T extends InterfaceA > Collection<? extends Comparable<? extends T>> shortThis(Collection<? extends Comparable<? extends T>> items){

		return null;
		
	}
	
	public void printInUI(Collection<?> items){
		
	}
	public <T> T getM(Collection<T> items){
		return null;
	} 
	public <T extends Comparable<T>> T getMM(Collection<T> items){
		return null;
	}
	
	public <T extends Comparable<? super T>> T getMMM(Collection<T> items){
		return null;
	}
	public <T extends Comparable<? super T>> T getMMMMM(Collection<? extends T> items){
		return null;
	}
	
	public <T extends Object & Comparable<? extends T>> T getMMMM(Collection<Comparable<? extends T>> items){
		return null; 
	}
	
	public <T extends Object & Comparable<? super T>> T getMax(Collection<Comparable<? extends T>> items){
		return null; 
	}

}
