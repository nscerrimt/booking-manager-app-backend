
# Booking Manager App

## Before Start Backend
- Set "spring.rabbitmq.host" property in application.properties to point to the local rabbit-mq instance

```docker run -d --hostname ecabs-rabbit --name rabbit-assignment -e RABBITMQ_DEFAULT_VHOST=/ -p 4369:4369 -p 5672:5672 -p 15672:15672 -p 25672:25672 rabbitmq:3-management```

## Assumptions
- "Waiting Time" and "Rating" and "tripWayPointTimestamp" were not included in the front-end data object since it was not clear on how/when these values would be inserted.
- Multiple equivalent bookings are allowed

## TO DO
**Due to time constraints and other personal commitments, more work is still required**
- Angular Form Validation
- Server-side validation
- Unit testing
- Front-end only accepts one trip way point.  This must be extended to accept more than one point.  Backend already accepts more than one point.
- Order of tripWayPoints is not yet  considered
- Improve structure of UI components
- Exception handling
- Logging
- NgRX state management
- Enable update functionality in front-end

## Notes
- Update component was not created in front-end.  This works in the backend.  Needs more work.
- The Angular front-end sends rest requests to backend, which in turn produces the respective messages which are later consumed accordingly.  
  **Ideally, a thin backend layer would support the ui, which would include the producer, rather than including this logic in the current booking-manager-api backend app**
- **MessageBookingController** and **BookingController** represent asynchronous and synchronous flows respectively.