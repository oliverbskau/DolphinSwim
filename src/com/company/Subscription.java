package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rasmus
 */
public class Subscription {

    //navigate in the class with a switch
    public void subscriptionNavigation(ArrayList<Clubmember> members) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nKontigenter");
        System.out.println("------------------");
        System.out.println("1. Tilbage til menu\n2. Se medlemmers status\n3. Se totalet af kontigenter");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: //Tilbage til menu
                break;
            case 2: //Se medlemmer status
                subscriptionStatus(members);
                break;
            case 3: //Se totalet af kontigenter
                System.out.println("Totalet af alle kontigenter: " + getTotalOfSubscriptions(members));
                break;
        }
    }

    //Defines what the monthly subscribssionprice is according to the agegroup you belong
    public double calculateTotalOfSubcriptions(int age, String memberType) {

        double totalOfPrice = 0;

        if(memberType == "Aktiv"){
            if (age < 18) {
                totalOfPrice = 1000;
            } else if (age > 18 && age < 60) {
                totalOfPrice = 1600;
            } else if (age > 60) {
                totalOfPrice = 1600 * 0.75;
            }
        } else { //Membertype = Passiv
            totalOfPrice = 500;
        }

        return totalOfPrice;
    }

    //Get the total price of subcriptions
    public double getTotalOfSubscriptions(ArrayList<Clubmember> members) {

        double total = 0;

        for (int i = 0; i < members.size(); i++) {
            total += members.get(i).getSubscriptionPrice();
        }
        System.out.println("\nDen totale indtjening er: " + total);
        return total;
    }

    public void subscriptionStatus(ArrayList<Clubmember> members){
        for (int i =0; i < members.size(); i ++){
            System.out.println("Navn: " + members.get(i).getName() + ", Betalt kontigent: "
                    + members.get(i).getHasPayed() + ", Pris: " + members.get(i).getSubscriptionPrice() + " Kr.");
        }
    }
}
