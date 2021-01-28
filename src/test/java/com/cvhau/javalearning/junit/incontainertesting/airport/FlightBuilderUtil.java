package com.cvhau.javalearning.junit.incontainertesting.airport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FlightBuilderUtil {

    public static Flight buildFlightFromCsv() throws IOException {
        Flight flight = new Flight("AA12345", 20);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("flights_information.csv");
        if (inputStream == null) {
            throw new IOException("Cannot load data from flights_information.csv resource");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] passengerAttrs = line.split(";");
                Passenger passenger = new Passenger(passengerAttrs[0].trim(), passengerAttrs[1].trim());
                flight.addPassenger(passenger);
            }
        }
        return flight;
    }
}
