package mt.com.ecabs.booking_manager.application;
  
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import mt.com.ecabs.booking_manager.application.dto.BookingDto;
import mt.com.ecabs.booking_manager.application.dto.View;
import mt.com.ecabs.booking_manager.domain.booking.BookingManager;
import mt.com.ecabs.booking_manager.domain.event_publishing.EventPublishingManager;
import mt.com.ecabs.booking_manager.infrastructure.messaging.EventType;
import mt.com.ecabs.booking_manager.utils.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("messaging/bookings") 
public class  MessageBookingController {
	
	public BookingManager bookingManager;
	
	public EventPublishingManager eventPublishingManager;
	
	public ObjectMapper objectMapper; 
	
	@Autowired
	public MessageBookingController(BookingManager bookingManager, EventPublishingManager eventPublishingManager, ObjectMapper objectMapper) {
		this.bookingManager = bookingManager;
		this.eventPublishingManager = eventPublishingManager;
		this.objectMapper = objectMapper;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(View.Summary.class)
	@PostMapping(value = "")
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) { 
		eventPublishingManager.publishEvent(EventType.ADD, bookingDto.toJson());	
		return ResponseEntity.ok().body(bookingDto); //TO DO: return well-defined object
	}
	   
	@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("")
    public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto) {
		eventPublishingManager.publishEvent(EventType.EDIT, bookingDto.toJson());	
		return ResponseEntity.ok().body(bookingDto); //TO DO: return well-defined object
    }
    
	@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}") 
    public ResponseEntity<UUID> deleteBooking(@PathVariable UUID id) {
		eventPublishingManager.publishEvent(EventType.DELETE, id.toString());	
        return ResponseEntity.ok().body(id); //TO DO: return well-defined object
    }
  
}