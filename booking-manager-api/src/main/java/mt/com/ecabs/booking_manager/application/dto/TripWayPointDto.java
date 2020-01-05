package mt.com.ecabs.booking_manager.application.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;

import mt.com.ecabs.booking_manager.infrastructure.dao.BookingDao;

public class TripWayPointDto {

	@JsonView(View.Summary.class)
	private UUID tripWayPointId;
	private BookingDao booking;
	@JsonView(View.Summary.class)
	private Boolean lastStop;
	@JsonView(View.Summary.class)
	private String locality;
	@JsonView(View.Summary.class)
	private Double lat;
	@JsonView(View.Summary.class)
	private Double lng;
	
	public TripWayPointDto() {
		
	}
	
	public UUID getTripWayPointId() {
		return tripWayPointId;
	}
	
	public void setTripWayPointId(UUID tripWayPointId) {
		this.tripWayPointId = tripWayPointId;
	}

	public BookingDao getBooking() {
		return booking;
	}

	public void setBooking(BookingDao booking) {
		this.booking = booking;
	}

	public Boolean getLastStop() {
		return lastStop;
	}

	public void setLastStop(Boolean lastStop) {
		this.lastStop = lastStop;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
}