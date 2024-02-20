package com.gridnine.testing.filter.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.Filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filters out flights where the arrival date and time of any segment is before the departure date and time.
 */
public class ArrivalBeforeDepartureFilter implements Filter {

    /**
     * Filters the given list of flights and returns only the flights where the arrival date and time of each segment
     * is after the departure date and time.
     *
     * @param flights the list of flights to filter
     * @return the filtered list of flights
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

}


