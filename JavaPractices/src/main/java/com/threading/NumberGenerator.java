package com.threading;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;

public class NumberGenerator extends Thread{

	private DataOutputStream dos; 
	
	public NumberGenerator(PipedOutputStream pipedOutputStream) {
	 dos = new DataOutputStream(pipedOutputStream); 
	}
	@Override
	public void run(){
		Random rand = new Random(); 
		double d; 
		while(true){
			d=rand.nextDouble(); 
			try {
				dos.writeDouble(d);
				System.out.println("New number =" +d); 
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
