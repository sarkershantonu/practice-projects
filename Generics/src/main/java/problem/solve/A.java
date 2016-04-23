package problem.solve;

public class A<T extends B> {

	public A() {		
	}
	public void add(T t){
		System.out.println("Printing from A with T -> ");
	}

}
