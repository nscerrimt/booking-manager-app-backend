package mt.com.ecabs.booking_manager.application.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;

public class BookingDto {

	@JsonView(View.Summary.class)
	private UUID bookingId;
	@JsonView(View.Summary.class)
	private String passengerName;
	@JsonView(View.Summary.class)
	private String passengerContactNumber;
	@JsonView(View.Summary.class)
	private OffsetDateTime pickupTime;
	@JsonView(View.Summary.class)
	private Boolean asap = true;
	@JsonView(View.Summary.class)
	private Integer noOfPassengers;
	@JsonView(View.Summary.class)
	private BigDecimal price;
	@JsonView(View.Summary.class)
	private List<TripWayPointDto> tripWayPoints;
	
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
	public List<TripWayPointDto> getTripWayPoints() {
		return tripWayPoints;
	}
	public void setTripWayPoints(List<TripWayPointDto> tripWayPoints) {
		this.tripWayPoints = tripWayPoints;
	}
	public String toJson() {
        return new Gson().toJson(this);
	}
}