package dev.UnitTest3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    public void getCarWeight() {
        Car car = new Car(2000, "blue", 2020, 240);
        assertEquals(2000, car.getWeight());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getCarColor() {
        Car car = new Car(2000, "blue", 2020, 240);
        assertEquals("blue", car.getColor());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getCarYear() {
        Car car = new Car(2000, "blue", 2020, 240);
        assertEquals(2020, car.getYear());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void getCarMaxSpeed() {
        Car car = new Car(2000, "blue", 2020, 240);
        assertEquals(240, car.getMaxSpeed());
    }

}