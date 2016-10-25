package com.commercehub.cashier;

@SuppressWarnings("WeakerAccess")
public class Register {

    private int runningTotal;

    public Register() {
        runningTotal = 0;
    }

    public Register(int startingTotal) {
        runningTotal = startingTotal;
    }

    public int outputTotal() {
        return runningTotal;
    }

    public void addToTotal(int valueToAdd) {
        runningTotal += valueToAdd;
    }

    public void applyAbsoluteDiscount(int discount) {
        runningTotal -= discount;
    }

    public void applyRelativeDiscount(double discount) {
        runningTotal -= runningTotal * discount;
    }
}
