package mt.com.ecabs.booking_manager.application;
  
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import mt.com.ecabs.booking_manager.application.dto.BookingDto;
import mt.com.ecabs.booking_manager.application.dto.View;
import mt.com.ecabs.booking_manager.domain.booking.Booking;
import mt.com.ecabs.booking_manager.domain.booking.BookingManager;
import mt.com.ecabs.booking_manager.domain.event_publishing.EventPublishingManager;
import mt.com.ecabs.booking_manager.utils.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("bookings") 
public class  BookingController {
	
	public BookingManager bookingManager;
	
	public EventPublishingManager eventPublishingManager;
	
	public ObjectMapper objectMapper; 
	
	@Autowired
	public BookingController(BookingManager bookingManager, EventPublishingManager eventPublishingManager, ObjectMapper objectMapper) {
		this.bookingManager = bookingManager;
		this.eventPublishingManager = eventPublishingManager;
		this.objectMapper = objectMapper;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(View.Summary.class)
	@PostMapping(value = "")
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) { 
		Booking booking = objectMapper.convertToDomainModel(bookingDto);
		BookingDto bookingDtoResponse = objectMapper.convertToDto(bookingManager.save(booking));
		return ResponseEntity.ok().body(bookingDtoResponse);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(View.Summary.class)
	@GetMapping(value = "") 
	public ResponseEntity<List<BookingDto>> getBookings() {
		List<BookingDto> dtoBookings = bookingManager.getAllBookings().parallelStream()
				.map(booking -> objectMapper.convertToDto(booking))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoBookings);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@JsonView(View.Summary.class)
    @GetMapping(value = "/{id}") 
    public ResponseEntity<BookingDto> getBookingById(@PathVariable UUID id) {
		BookingDto bookingDtoResponse = objectMapper.convertToDto(bookingManager.getBookingById(id));
		return ResponseEntity.ok().body(bookingDtoResponse);
    }
    
	@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("")
    public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto) {
		Booking booking = objectMapper.convertToDomainModel(bookingDto);
		bookingManager.updateBookingById(booking);
		return ResponseEntity.ok().body(bookingDto); //TO DO: return well-defined object
    }
    
	@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}") 
    public ResponseEntity<UUID> deleteBooking(@PathVariable UUID id) {
    	bookingManager.deleteBookingById(id);
    	return ResponseEntity.ok().body(id); //TO DO: return well-defined object
    }
  
}