package org.example.ws.service;

import java.util.concurrent.Future;

import org.example.ws.model.Greeting;

public interface EmailService {
	Boolean send(Greeting greeting); 
	void sendAsync(Greeting greeting); 
	Future<Boolean> sendAsyncWithResult(Greeting greeting); 
}
