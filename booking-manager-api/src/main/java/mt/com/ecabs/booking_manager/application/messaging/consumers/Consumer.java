package mt.com.ecabs.booking_manager.application.messaging.consumers;

public interface Consumer {	
	
	public void receive(String message) throws InterruptedException;
	
}