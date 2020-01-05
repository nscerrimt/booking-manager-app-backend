package mt.com.ecabs.booking_manager.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mt.com.ecabs.booking_manager.infrastructure.dao.BookingDao;

@Repository
public interface BookingRepository extends JpaRepository <BookingDao, UUID> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE BOOKINGS SET "
    		+ "passengerName = :passengerName"
    		+ " WHERE bookingId = :bkId", nativeQuery = true)
    int updateBooking(@Param("bkId") UUID bkId, @Param("passengerName") String passengerName);
	
}