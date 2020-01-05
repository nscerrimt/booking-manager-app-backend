package mt.com.ecabs.booking_manager.utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import mt.com.ecabs.booking_manager.application.dto.BookingDto;
import mt.com.ecabs.booking_manager.domain.booking.Booking;
import mt.com.ecabs.booking_manager.domain.booking.TripWayPoint;
import mt.com.ecabs.booking_manager.infrastructure.dao.BookingDao;

public class ObjectMapper {
	
	public static int WAITING_TIME = 5;
	public static int RATING = 5;
	
    @Autowired
    private ModelMapper modelMapper;
    
	public BookingDto convertToDto(Booking booking) {
		return modelMapper.map(booking, BookingDto.class);
	}
	
	public Booking convertToDomainModel(BookingDto bookingDto) {
		Booking booking = modelMapper.map(bookingDto, Booking.class);
		
		booking.setCreatedOn(Instant.now());
		booking.setLastModifiedOn(Instant.now());
		booking.setRating(RATING);
		booking.setWaitingTime(WAITING_TIME);
		List<TripWayPoint> tripWayPoints = new ArrayList<>();
		
		for(TripWayPoint tripWayPoint:booking.getTripWayPoints()) {
			tripWayPoint.setBooking(booking);
			tripWayPoint.setTripWayPointTimestamp(Instant.now());
			tripWayPoints.add(tripWayPoint);
		}
		booking.setTripWayPoints(tripWayPoints);
		return booking;
	}
	
	public BookingDao convertToDao(Booking booking) {
		BookingDao bookingDao = modelMapper.map(booking, BookingDao.class);
		return bookingDao;
	}
	
	public Booking convertToDomainModel(BookingDao bookingDao) {
		Booking booking = modelMapper.map(bookingDao, Booking.class);
		return booking;
	}
}