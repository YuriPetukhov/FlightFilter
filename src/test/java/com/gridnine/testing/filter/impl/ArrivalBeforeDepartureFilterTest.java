package com.gridnine.testing.filter.impl;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ArrivalBeforeDepartureFilterTest {

    private final ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

    @Test
    public void testFilter() {
        // Create a list of flights
        List<Flight> flights = Arrays.asList(
                // Flight with correct dates
                new Flight(Arrays.asList(new Segment(LocalDateTime.of(2024, 1, 1, 10, 0),
                        LocalDateTime.of(2024, 1, 1, 12, 0)),
                        new Segment(LocalDateTime.of(2024, 1, 2, 10, 0),
                                LocalDateTime.of(2024, 1, 2, 12, 0)))),
                // Flight with incorrect dates
                new Flight(Arrays.asList(new Segment(LocalDateTime.of(2024, 1, 1, 12, 0),
                        LocalDateTime.of(2024, 1, 1, 10, 0)),
                        new Segment(LocalDateTime.of(2024, 1, 2, 12, 0),
                                LocalDateTime.of(2024, 1, 2, 10, 0)))));

        // Apply the filter
        List<Flight> filteredFlights = filter.filter(flights);

        // Check the result
        Assertions.assertEquals(1, filteredFlights.size());
        Assertions.assertEquals(flights.get(0), filteredFlights.get(0));
    }

}