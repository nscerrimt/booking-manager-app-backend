package mt.com.ecabs.booking_manager.domain.booking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mt.com.ecabs.booking_manager.infrastructure.dao.BookingDao;
import mt.com.ecabs.booking_manager.infrastructure.repositories.BookingRepository;
import mt.com.ecabs.booking_manager.utils.ObjectMapper;

@Component
public class BookingManager {
	
	private BookingRepository bookingRepository;
	
	private ObjectMapper objectMapper;
	
	@Autowired
	public BookingManager(BookingRepository bookingRepository, ObjectMapper objectMapper) {
		this.bookingRepository = bookingRepository;
		this.objectMapper = objectMapper;
	}
	
	public Booking save(Booking booking) {
		BookingDao bookingDao = this.bookingRepository.save(objectMapper.convertToDao(booking));
		return objectMapper.convertToDomainModel(bookingDao);
	}

	public List<Booking> getAllBookings() {
		return this.bookingRepository.findAll().parallelStream()
				.map(bookingDao -> objectMapper.convertToDomainModel(bookingDao))
				.collect(Collectors.toList());
	}
	
	public Booking getBookingById(UUID id) {
		Optional<BookingDao> bookingDao = this.bookingRepository.findById(id);
		
		if(bookingDao.isPresent()) {
			return objectMapper.convertToDomainModel(bookingDao.get());
		} else return null;
	}
	
	public void updateBookingById(Booking booking) {
		this.bookingRepository.updateBooking(booking.getBookingId(), booking.getPassengerName());
	}
	
	public void deleteBookingById(UUID id) {
		this.bookingRepository.deleteById(id);
	}
	
}