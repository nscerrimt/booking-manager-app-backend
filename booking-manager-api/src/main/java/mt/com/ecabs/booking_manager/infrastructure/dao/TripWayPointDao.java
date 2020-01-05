package mt.com.ecabs.booking_manager.infrastructure.dao;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRIP_WAY_POINTS")
public class TripWayPointDao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID tripWayPointId;
    @ManyToOne
    @JoinColumn(name = "bookingId")
	private BookingDao booking;
	@NotNull
	private Boolean lastStop;
	@NotNull
	private String locality;
	@NotNull
	private Double lat;
	@NotNull
	private Double lng;
	@NotNull
	private Instant tripWayPointTimestamp;
	

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

	public Instant getTripWayPointTimestamp() {
		return tripWayPointTimestamp;
	}

	public void setTripWayPointTimestamp(Instant tripWayPointTimestamp) {
		this.tripWayPointTimestamp = tripWayPointTimestamp;
	}
		
}