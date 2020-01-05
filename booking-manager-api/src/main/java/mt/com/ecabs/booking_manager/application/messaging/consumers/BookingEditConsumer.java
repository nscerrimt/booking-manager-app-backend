package mt.com.ecabs.booking_manager.application.messaging.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mt.com.ecabs.booking_manager.application.dto.BookingDto;
import mt.com.ecabs.booking_manager.domain.booking.BookingManager;
import mt.com.ecabs.booking_manager.utils.ObjectMapper;


@Component
public class BookingEditConsumer implements Consumer {
			
	@Autowired
	private BookingManager bookingManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	@RabbitListener(queues = "BookingEditQueue")
    public void receive(String message) throws InterruptedException {
    	Gson gson = new Gson();
    	BookingDto bookingDto = gson.fromJson(message, BookingDto.class);
    	bookingManager.updateBookingById(objectMapper.convertToDomainModel(bookingDto));
    }
    
}