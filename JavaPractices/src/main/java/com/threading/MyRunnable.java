package com.threading;

public class MyRunnable implements Runnable{

	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=10000;i++){
		 System.out.println("My Runnable "+i);
		
		}
	}

}
