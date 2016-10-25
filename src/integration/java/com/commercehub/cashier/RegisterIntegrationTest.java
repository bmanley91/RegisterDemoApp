package com.commercehub.cashier;

import org.junit.Test;

public class RegisterIntegrationTest {

    @Test
    public void checkoutMultipleItems() {
        final int firstItem = 40;
        final int secondItem = 60;
        final int expectedTotal = 100;
        Register register = new Register();

        register.addToTotal(firstItem);
        register.addToTotal(secondItem);

        int actualTotal = register.outputTotal();

        assert actualTotal == expectedTotal;
    }
}
