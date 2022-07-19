package dev.UnitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;


    @BeforeEach
    public void createCar() {
        car = new Car("Skoda", "ABC-1234", 2019, "Dmitry F.");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC-1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("ABCD-1234");
        assertEquals("ABCD-1234", car.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Dmitry F.", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Andrey K.");
        assertEquals("Andrey K.", car.getOwner());
    }

    @Test
    void getListOfOwners() {
        assertArrayEquals(new String[] {"Dmitry F."}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Andrey K.");
        assertArrayEquals(new String[] {"Dmitry F.", "Andrey K."}, car.getOwners().toArray());
    }
}