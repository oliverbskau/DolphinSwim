package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {
    //Arrange
    Subscription subscription = new Subscription();
    Register register = new Register();
    Clubmember clubmember1 = new Clubmember(20, "Ungdom", "Jonas", "Aktiv", 0, "Ikke konkurrencesvømmer","Nej");
    Clubmember clubmember2 = new Clubmember(67, "Ungdom", "Kurt", "Aktiv", 0, "Ikke konkurrencesvømmer","Nej");

    @Test
    void calculateTotalOfSubcriptions() {
        //Arrange
        double testCal1;
        double testCal2;

        //Act
        testCal1 = subscription.calculateTotalOfSubcriptions(clubmember1.getAge(),clubmember1.getMemberType());
        testCal2 = subscription.calculateTotalOfSubcriptions(clubmember2.getAge(),clubmember2.getMemberType());

        //Assert
        assertEquals(1600.0,testCal1);
        assertEquals(1200.0,testCal2);
    }

    @Test
    void getTotalOfSubscriptions() {
        //Arrange
        double total;
        clubmember1.setSubscriptionPrice(1600.0);
        clubmember2.setSubscriptionPrice(1200.0);

        register.members.add(clubmember1);
        register.members.add(clubmember2);

        //Act
        total = subscription.getTotalOfSubscriptions(register.members);

        //Assert
        assertEquals(2800.0,total);
    }

}