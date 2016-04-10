package com.threading;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

public class RunningAverage extends Thread{
		private DataInputStream din; 
	public RunningAverage(PipedInputStream pipedInputSteam) {
		din = new DataInputStream(pipedInputSteam);
	}
	@Override
	public void run()
	{
		int counter=0;
		double total=0.0; 
		while(true){
			try {
				total += din.readDouble();
				counter++; 
				System.out.println("Avg = "+total/counter);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
