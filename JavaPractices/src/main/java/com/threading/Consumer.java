package com.threading;

public class Consumer extends Thread{
	private Stock mySt; 
	public Consumer(Stock s){
		this.mySt=s;
	}
	
	@Override
	public void run(){
		mySt.getQonhand(10);
	}

}
