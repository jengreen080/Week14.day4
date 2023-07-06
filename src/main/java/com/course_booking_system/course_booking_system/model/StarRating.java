package com.course_booking_system.course_booking_system.model;

public enum StarRating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

    public int getValue() {
        return value;
    }

    StarRating(int value) {
        this.value = value;

    }
}
