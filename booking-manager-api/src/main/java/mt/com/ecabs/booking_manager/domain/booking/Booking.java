package mt.com.ecabs.booking_manager.domain.booking;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.List;

import com.google.gson.Gson;
import mt.com.ecabs.booking_manager.domain.booking.TripWayPoint;

public class Booking {
   
	private UUID bookingId;
	private String passengerName;
	private String passengerContactNumber;
	private OffsetDateTime pickupTime;
	private Boolean asap = true;
	private Integer waitingTime;
	private Integer noOfPassengers;
	private BigDecimal price;
	private Integer rating;
	private Instant createdOn;
	private Instant lastModifiedOn;
	private List<TripWayPoint> tripWayPoints;
	
	public UUID getBookingId() {
		return bookingId;
	}
	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerContactNumber() {
		return passengerContactNumber;
	}
	public void setPassengerContactNumber(String passengerContactNumber) {
		this.passengerContactNumber = passengerContactNumber;
	}
	public OffsetDateTime getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(OffsetDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}
	public Boolean getAsap() {
		return asap;
	}
	public void setAsap(Boolean asap) {
		this.asap = asap;
	}
	public Integer getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(Integer waitingTime) {
		this.waitingTime = waitingTime;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Instant getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}
	public Instant getLastModifiedOn() {
		return lastModifiedOn;
	}
	public void setLastModifiedOn(Instant lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	public List<TripWayPoint> getTripWayPoints() {
		return tripWayPoints;
	}
	public void setTripWayPoints(List<TripWayPoint> tripWayPoints) {
		this.tripWayPoints = tripWayPoints;
	}
	
	public String toJson() {
        return new Gson().toJson(this);
	}
}
