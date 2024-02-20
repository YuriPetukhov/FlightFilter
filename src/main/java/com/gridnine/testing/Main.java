package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;
import com.gridnine.testing.entity.FlightFilter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.DepartureDateFilter;
import com.gridnine.testing.filter.impl.GroundTimeFilter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);

        // Apply the departure date filter
        flightFilter.addFilter(new DepartureDateFilter());
        List<Flight> filtered1 = flightFilter.executeFilter();
        System.out.println("Flights with departure date after current moment:");
        filtered1.forEach(System.out::println);

        // Apply the arrival before departure filter
        flightFilter.addFilter(new ArrivalBeforeDepartureFilter());
        List<Flight> filtered2 = flightFilter.executeFilter();
        System.out.println("\nFlights with segments where arrival date is before departure date:");
        filtered2.forEach(System.out::println);

        // Apply the ground time filter
        flightFilter.addFilter(new GroundTimeFilter());
        List<Flight> filtered3 = flightFilter.executeFilter();
        System.out.println("\nFlights where total time spent on the ground does not exceed two hours:");
        filtered3.forEach(System.out::println);
    }

}
