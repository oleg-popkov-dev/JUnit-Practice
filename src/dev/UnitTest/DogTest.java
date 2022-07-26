package dev.UnitTest;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {


    static Dog dog;

//    @BeforeEach //выполняется перед каждым тестом
//    void prepareData() {
//        dog = new dev.UnitTest.Dog("Albert", 2);
//    }

    @BeforeAll //выполняется один раз перед всеми тестами
    static void prepareData() {
        dog = new Dog("Albert", 2);
    }


    @org.junit.jupiter.api.Test
    void testGetDogNameMethod() {
        assertEquals("Albert", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void testSetDogNameMethod() {
        dog.setName("Roman");
        assertEquals("Albert", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void testSetDogNameMethodIfEmpty() {
        Dog dog = new Dog("", 2);
        dog.setName("Roman");
        assertEquals("Roman", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
    }

    @org.junit.jupiter.api.Test
    void setAge() {
    }
}