package com.threading;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

	public static void main(String[] args) throws IOException{
		PipedInputStream pi = new PipedInputStream();
		PipedInputStream p2 = new PipedInputStream();
		PipedOutputStream po = new PipedOutputStream();
		pi.connect(po);
		
		//p2.connect(po);
		NumberGenerator ng = new NumberGenerator(po);
		RunningAverage avg = new RunningAverage(pi);
		
		ng.start();
		avg.start();
		
	}
}
