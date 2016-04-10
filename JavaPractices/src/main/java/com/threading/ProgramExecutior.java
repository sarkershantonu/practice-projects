package com.threading;

public class ProgramExecutior {

	public static void main(String[] args) {
		MyThread thread = new MyThread(); 
		System.out.println("Main started");
		thread.start();
		System.out.println("Main ended");
		//thread.run();
		//thread.yield();
	}

}
