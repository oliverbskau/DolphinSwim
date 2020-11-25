package com.company;

public class Subscription {
    public double calculateTotalOfSubcriptions(int age, String memberType) {
        double totalOfPrice = 0;

        if (age < 18){
            totalOfPrice = 1000;
        }else if(age > 18 && age < 60){
            totalOfPrice = 1600;
        } else if (age > 60 ) {
            totalOfPrice = 1600 * 0.75;
        }else if(memberType == "Passiv") {
            totalOfPrice = 500;
        }


        return totalOfPrice;
    }





















}
