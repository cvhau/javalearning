package com.cvhau.javalearning.junit.incontainertesting.airport;

import com.cvhau.javalearning.junit.incontainertesting.airport.producers.FlightProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Arquillian.class)
public class FlightWithPassengersTest {

    /************************************************************************************
     * TODO             Waiting Arquillian extension for JUnit5 version                 *
     ************************************************************************************/

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Passenger.class, Flight.class, FlightProducer.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    Flight flight;

    @Test
    public void givenFlight_whenCapabilityOfSeatsExceeded_throwRuntimeException() {
        Passenger additionalPassenger = new Passenger("1247890", "Michael Johnson");
        assertAll(
                () -> assertEquals(20, flight.getNumberOfPassengers()),
                () -> assertThrows(RuntimeException.class, () -> flight.addPassenger(additionalPassenger))
        );
    }

    @Test
    public void givenFlight_whenAddAndRemovePassenger_thenCorrect() {
        flight.setSeats(21);
        Passenger additionalPassenger = new Passenger("1247890", "Michael Johnson");

        assertAll(
                () -> {
                    flight.addPassenger(additionalPassenger);
                    assertEquals(21, flight.getNumberOfPassengers());
                },
                () -> {
                    flight.removePassenger(additionalPassenger);
                    assertEquals(20, flight.getNumberOfPassengers());
                },
                () -> assertEquals(21, flight.getSeats())
        );
    }
}