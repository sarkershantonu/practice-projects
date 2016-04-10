package com.threading;

public class MyThread extends Thread{
	
	public static void yield(){
		  
	}
	public void run(){
		for(int i=0;i<=1000;i++){
			 System.out.println("My Extended Thread  "+i);
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
	private void printInfoInconsole(){
		
	}

}
