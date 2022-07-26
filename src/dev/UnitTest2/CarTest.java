package dev.UnitTest2;

import dev.UnitTest2.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;


    @BeforeEach
    public void createCar() {
        car = new dev.UnitTest2.Car("Skoda", "ABC-1234", 2019, "Dmitry F.");
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

    @ParameterizedTest
    @CsvSource({"'ABCD-123', 'ABCD-123'", "'DEF-456', 'DEF-456'"})
    void testSetNumberMultipleValues(String number, String x) {
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"1, 5", "8, 12", "32, 36"})
    void testInt(int input, int output) {
        assertEquals(car.testInt(input), output);
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
        assertArrayEquals(new String[]{"Dmitry F."}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOwners() {
        car.setOwner("Andrey K.");
        assertArrayEquals(new String[]{"Dmitry F.", "Andrey K."}, car.getOwners().toArray());
    }

    @Test
    public void testPrivateMethod() {

        try {
            Method method = dev.UnitTest2.Car.class.getDeclaredMethod("testMethod", null);

            method.setAccessible(true);
            assertEquals(method.invoke(car).toString(), "abc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPrivateMethodWithArgument() {

        try {
            Method method = Car.class.getDeclaredMethod("testMethod", String.class);

            method.setAccessible(true);
            assertEquals(method.invoke(car, "abd").toString(), "abd");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ParameterizedTest
    @EnabledOnOs({OS.LINUX, OS.MAC})
    @EnabledOnJre(JRE.JAVA_11)
    //@DisabledOnJre(JRE.JAVA_8)
    @DisplayName("Test demonstrates how test data could be loaded from file")
    @CsvFileSource(resources = "/dev/UnitTest2/test-data.csv", delimiter = '|', numLinesToSkip = 1)
    public void testNumbers(String input, String expected) {
        car.setNumber(input);
        assertEquals(expected, car.getNumber());
    }

    @Test
    void getTestData() {
        assertThrows(Exception.class, () -> {
            car.getDataFromRemoteServer();
        });
    }

}