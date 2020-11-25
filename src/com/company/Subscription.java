package com.company;

import java.util.ArrayList;

/**
 * @author
 */
public class Subscription {
    public double calculateTotalOfSubcriptions(int age, String memberType) {
        double totalOfPrice = 0;

        if (age < 18) {
            totalOfPrice = 1000;
        } else if (age > 18 && age < 60) {
            totalOfPrice = 1600;
        } else if (age > 60) {
            totalOfPrice = 1600 * 0.75;
        } else if (memberType == "Passiv") {
            totalOfPrice = 500;
        }


        return totalOfPrice;
    }

public double getTotalOfSubscriptions(ArrayList<Clubmember> members){
        double total = 0;
        for (int i = 0; i < members.size(); i++){
            total += members.get(i).getSubscriptionPrice();
        }
      return total;
    }

}
