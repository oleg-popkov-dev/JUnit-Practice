package dev.UnitTest3;

public class Car {

    private int weight;
    private String color;
    private int year;
    private int maxSpeed;

    public Car(int weight, String color, int year, int maxSpeed) {
        this.weight = weight;
        this.color = color;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

}
