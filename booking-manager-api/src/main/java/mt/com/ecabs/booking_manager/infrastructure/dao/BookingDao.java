package mt.com.ecabs.booking_manager.infrastructure.dao;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "BOOKINGS")
public class BookingDao {

	@Id
    @Column(name = "bookingId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID bookingId;
    @Column(name = "passengerName")
    @NotNull
	private String passengerName;
    @Column(name = "passengerContactNumber")
    @NotNull
	private String passengerContactNumber;
    @Column(name = "pickupTime")
    @NotNull
	private OffsetDateTime pickupTime;
    @Column(name = "asap")
    @NotNull
	private Boolean asap = true;
    @Column(name = "waitingTime")
    @NotNull
	private Integer waitingTime;
    @Column(name = "noOfPassengers")
    @NotNull
	private Integer noOfPassengers;
    @Column(name = "price")
    @NotNull
	private BigDecimal price;
    @Column(name = "rating")
    @NotNull
	private Integer rating;
    @Column(name = "createdOn")
    @NotNull
    private Instant createdOn;
    @Column(name = "lastModifiedOn")
    @NotNull
	private Instant lastModifiedOn;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<TripWayPointDao> tripWayPoints;
    
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
	public List<TripWayPointDao> getTripWayPoints() {
		return tripWayPoints;
	}
	public void setTripWayPoints(List<TripWayPointDao> tripWayPoints) {
		this.tripWayPoints = tripWayPoints;
	}
    public BookingDao setTripWayPointBooking(BookingDao booking) {
    	this.getTripWayPoints().stream().forEach(tripWayPoint -> tripWayPoint.setBooking(booking));
    	return this;
    }
	
}
