package mt.com.ecabs.booking_manager.application.messaging.consumers;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mt.com.ecabs.booking_manager.domain.booking.BookingManager;

@Component
public class BookingDeleteConsumer implements Consumer {
			
	@Autowired
	private BookingManager bookingManager;
	
	@Override
	@RabbitListener(queues = "BookingDeleteQueue")
    public void receive(String message) throws InterruptedException {
    	Gson gson = new Gson();
    	UUID id = gson.fromJson(message, UUID.class);
    	bookingManager.deleteBookingById(id);
    }
    
}