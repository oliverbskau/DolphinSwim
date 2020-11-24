package com.company;

public class Subscription {
    public static double calculateTotalOfSubcribtions(Clubmember clubmember) {
        double totalOfPrice = 0;

        if (clubmember.age < 18){
            totalOfPrice = 1000;
        }else if(clubmember.age > 18 && clubmember.age < 60){
            totalOfPrice = 1600;
        } else if (clubmember.age > 60 ) {
            totalOfPrice = 1600 * 0.75;
        }else if(clubmember.memberType == "Passiv") {
            totalOfPrice = 500;
        }


        return totalOfPrice;
    }





















}
