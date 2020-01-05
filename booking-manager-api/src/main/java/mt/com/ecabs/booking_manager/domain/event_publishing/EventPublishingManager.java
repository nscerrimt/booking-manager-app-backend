package mt.com.ecabs.booking_manager.domain.event_publishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mt.com.ecabs.booking_manager.infrastructure.messaging.BookingProducer;
import mt.com.ecabs.booking_manager.infrastructure.messaging.EventType;

@Component
public class EventPublishingManager {
	
	public BookingProducer bookingProducer;
	
	@Autowired
	public EventPublishingManager(BookingProducer bookingProducer) {
		this.bookingProducer = bookingProducer;
	}
	
	public void publishEvent(EventType eventType, String message) {
		bookingProducer.send(eventType, message);
	}
	
}