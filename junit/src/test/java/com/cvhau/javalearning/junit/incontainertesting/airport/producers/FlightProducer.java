package com.cvhau.javalearning.junit.incontainertesting.airport.producers;

import com.cvhau.javalearning.junit.incontainertesting.airport.Flight;
import com.cvhau.javalearning.junit.incontainertesting.airport.FlightBuilderUtil;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class FlightProducer {

    @Produces
    public Flight createFlight() throws IOException {
        return FlightBuilderUtil.buildFlightFromCsv();
    }
}
