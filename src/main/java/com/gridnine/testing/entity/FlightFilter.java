package com.gridnine.testing.entity;

import com.gridnine.testing.filter.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a filter for flights.
 * <p>
 * A flight filter can be used to filter a list of flights based on a set of criteria.
 * The filter criteria are specified using a list of {@link Filter} objects.
 * <p>
 * To use a flight filter, first create a new instance of the class and set the list of flights to be filtered using the {@link #setFlights(List)} method.
 * Then, add one or more filter criteria to the filter using the {@link #addFilter(Filter)} method.
 * Finally, call the {@link #executeFilter()} method to apply the filter criteria to the list of flights and return the filtered list.
 */
public class FlightFilter {
    /**
     * The list of filter criteria to be applied to the flights.
     */
    private List<Filter> filters;

    /**
     * The list of flights to be filtered.
     */
    private List<Flight> flights;

    /**
     * Creates a new flight filter.
     */
    public FlightFilter() {
        this.filters = new ArrayList<>();
    }

    /**
     * Sets the list of flights to be filtered.
     *
     * @param flights The list of flights to be filtered.
     */
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Adds a filter criterion to the filter.
     *
     * @param filter The filter criterion to be added.
     */
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    /**
     * Applies the filter criteria to the list of flights and returns the filtered list.
     *
     * @return The filtered list of flights.
     */
    public List<Flight> executeFilter() {
        List<Flight> filteredFlights = flights;
        for (Filter filter : filters) {
            filteredFlights = filter.filter(filteredFlights);
        }
        return filteredFlights;
    }
}
