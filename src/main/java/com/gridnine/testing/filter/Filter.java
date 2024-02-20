package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;

import java.util.List;

/**
 * Interface for flight filters.
 * A filter takes a list of flights and returns a filtered list of flights,
 * that satisfy the filter criteria.
 */
public interface Filter {

    /**
     * Filters the given list of flights.
     *
     * @param flights the list of flights to filter
     * @return the filtered list of flights
     */
    List<Flight> filter(List<Flight> flights);

}


