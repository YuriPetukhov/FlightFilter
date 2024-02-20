# Flight Filter

**Author:** Yuri Petukhov

This project provides an easy-to-use filter for flights that can be used to filter flights by various criteria, such as departure date, arrival date, and flight duration.

## Installation

mvn install


## Usage

```java
import com.gridnine.testing.FlightFilter;

// Create a list of flights
List<Flight> flights = ...

// Apply the filter
List<Flight> filteredFlights = FlightFilter.filter(flights);
Filter Criteria
The filter supports the following filter criteria:

Departure date: Filters flights by departure date.
Arrival date: Filters flights by arrival date.
Flight duration: Filters flights by flight duration.
Examples
Filtering flights by departure date
List<Flight> filteredFlights = FlightFilter.filter(flights, FlightFilter.departureDateAfter(LocalDateTime.now()));
Filtering flights by arrival date
List<Flight> filteredFlights = FlightFilter.filter(flights, FlightFilter.arrivalDateBefore(LocalDateTime.now()));
Filtering flights by flight duration
List<Flight> filteredFlights = FlightFilter.filter(flights, FlightFilter.flightDurationLessThan(2));
```
Contributing
Contributions to this project are welcome.

License
This project is licensed under the Apache 2.0 license.
