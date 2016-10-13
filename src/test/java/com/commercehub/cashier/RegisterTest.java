package com.commercehub.cashier;

import org.junit.Test;

public class RegisterTest {

    @Test
    public void testOutputTotal() {
        final int expectedTotal = 0;

        Register register = new Register();

        int baseTotal = register.outputTotal();

        assert expectedTotal == baseTotal;
    }

    @Test
    public void testConstructorWithValue() {
        final int expectedTotal = 5;

        Register register = new Register(expectedTotal);

        int actualTotal = register.outputTotal();

        assert expectedTotal == actualTotal;
    }

    @Test
    public void testAddToTotal() {
        final int expectedTotal = 5;

        Register register = new Register();

        register.addToTotal(expectedTotal);
        int actualTotal = register.outputTotal();

        assert expectedTotal == actualTotal;
    }

    @Test
    public void testApplyAbsoluteDiscount() {
        final int expectedTotal = 6;
        final int originalTotal = 10;
        final int discount = 4;

        Register register = new Register(originalTotal);
        register.applyAbsoluteDiscount(discount);
        int actualTotal = register.outputTotal();

        assert expectedTotal == actualTotal;
    }

    @Test
    public void testApplyRelativeDiscount() {
        final int expectedTotal = 7;
        final int originalTotal = 10;
        final double discount = .3;

        Register register = new Register(originalTotal);
        register.applyRelativeDiscount(discount);
        int actualTotal = register.outputTotal();

        assert expectedTotal == actualTotal;
    }
}
