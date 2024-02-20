package com.gridnine.testing.filter.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filters out flights where the total time spent on the ground exceeds two hours.
 */
public class GroundTimeFilter implements FlightFilter {

    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

    /**
     * Filters the given list of flights and returns only the flights where the total time spent on the ground does not exceed two hours.
     *
     * @param flights the list of flights to filter
     * @return the filtered list of flights
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    Duration totalGroundTime = Duration.ZERO;
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        Segment currentSegment = flight.getSegments().get(i);
                        Segment nextSegment = flight.getSegments().get(i + 1);
                        totalGroundTime = totalGroundTime.plus(Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()));
                    }
                    return totalGroundTime.compareTo(MAX_GROUND_TIME) < 0;
                })
                .collect(Collectors.toList());
    }

}


