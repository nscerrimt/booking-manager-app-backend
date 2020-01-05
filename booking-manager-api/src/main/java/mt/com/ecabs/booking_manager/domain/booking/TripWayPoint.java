package mt.com.ecabs.booking_manager.domain.booking;

import java.time.Instant;
import java.util.UUID;

public class TripWayPoint {

	private UUID tripWayPointId;
	private Booking booking;
	private Boolean lastStop;
	private String locality;
	private Double lat;
	private Double lng;
	private Instant tripWayPointTimestamp;
	
	public TripWayPoint() {
		
	}
	
	public UUID getTripWayPointId() {
		return tripWayPointId;
	}
	
	public void setTripWayPointId(UUID tripWayPointId) {
		this.tripWayPointId = tripWayPointId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
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

	public Instant getTripWayPointTimestamp() {
		return tripWayPointTimestamp;
	}

	public void setTripWayPointTimestamp(Instant tripWayPointTimestamp) {
		this.tripWayPointTimestamp = tripWayPointTimestamp;
	}
	
}