package com.gridnine.testing.filter.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filters out where the departure date and time of the first segment is before the current date and time.
 */
public class DepartureDateFilter implements FlightFilter {

    /**
     * Filters the given list of flights and returns only the flights where the departure date and time of the first segment
     * is after the current date and time.
     *
     * @param flights the list of flights to filter
     * @return the filtered list of flights
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().get(0).getDepartureDate().isAfter(now))
                .collect(Collectors.toList());
    }

}


