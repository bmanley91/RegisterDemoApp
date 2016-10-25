package com.commercehub.cashier

import spock.lang.Specification

class RegisterSpec extends Specification {

    def 'Checkout Multiple Items' () {
        final int firstItem = 40
        final int secondItem = 60
        final int expectedTotal = 100

        setup: 'A Register exists'
        Register register = new Register()

        when: 'Two Items are added to the Register'
        register.addToTotal(firstItem)
        register.addToTotal(secondItem)

        then: 'The output will be the sum of their prices.'
        register.outputTotal() == expectedTotal
    }

    def 'Apply Absolute then Relative Discount' () {
        final int initialTotal = 100
        final int absoluteDiscount = 10
        final int expectedTotalAfterAbsoluteDiscount = 90
        final double relativeDiscount = 0.5
        final int expectedFinalTotal = 45

        setup: 'A Register exists with an initial total'
        Register register = new Register(initialTotal)

        when: 'an Absolute Discount is applied'
        register.applyAbsoluteDiscount(absoluteDiscount)

        then: 'the total should reflect the discount'
        int actualTotalAfterAbsoluteDiscount = register.outputTotal()
        expectedTotalAfterAbsoluteDiscount == actualTotalAfterAbsoluteDiscount

        when: 'a Relative Discount is then applied'
        register.applyRelativeDiscount(relativeDiscount)

        then: 'the total should reflect both discounts'
        int actualFinalTotal = register.outputTotal()
        actualFinalTotal == expectedFinalTotal
    }

    def 'Apply Relative then Absolute Discount' () {
        final int initialTotal = 10
        final double relativeDiscount = 0.4
        final int expectedTotalAfterRelativeDiscount = 6
        final int absoluteDiscount = 4
        final int expectedFinalTotal = 2

        setup: 'A Register exists with an initial total'
        Register register = new Register(initialTotal)

        when: 'a Relative Discount is applied'
        register.applyRelativeDiscount(relativeDiscount)

        then: 'the total should reflect the discount'
        int actualTotalAfterRelativeDiscount = register.outputTotal()
        expectedTotalAfterRelativeDiscount == actualTotalAfterRelativeDiscount

        when: 'an Absolute Discount is then applied'
        register.applyAbsoluteDiscount(absoluteDiscount)

        then: 'the total should reflect both discounts'
        int actualFinalTotal = register.outputTotal()
        actualFinalTotal == expectedFinalTotal
    }
}
