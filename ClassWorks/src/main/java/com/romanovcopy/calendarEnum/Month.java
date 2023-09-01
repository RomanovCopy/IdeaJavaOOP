package com.romanovcopy.calendarEnum;

public enum Month {
    JAN(1), FEB(2), MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    private int number;

    Month(int number) {
        this.number = number;
    }

    Month() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
