package mt.com.ecabs.booking_manager.infrastructure.messaging;

public interface Producer {
	
	public void send(EventType eventType, String message);

}