package com.threading;

public class Stock {

	private int Qonhand, rol; 
	public synchronized void getQonhand(int qneed){
		if(qneed>Qonhand){
			try {
				wait();//release lock and get to wait pool
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.Qonhand-=qneed;
	}
	public synchronized void setQonhand(int x){
		this.Qonhand+=x;
		notify();//releases the wait state to resume(same pool) 
	}
}
