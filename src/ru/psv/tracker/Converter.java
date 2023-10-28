package ru.psv.tracker;

public class Converter {
    final static  float stepsToDistance = 0.75F;
    final static int stepsToСalories = 50;
    public static double convertToDistance(int steps) {
        return steps*stepsToDistance/1000;
    }
    public static double convertToCalories (int steps) {
        return steps*stepsToСalories/1000;
    }
}
