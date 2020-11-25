package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Oliver Brücker Skau
 * @author Jonas Kunert
 */

public class Register {
    ArrayList<Clubmember> members = new ArrayList<>();
    ArrayList<Competitionswimmers> competitionswimmers = new ArrayList<>();


    //Se konkurrencesvømmere og fjern dem igen
    public void printCompetitionswimmers(){
        int memberNumber = 0;
        for(int i = 0 ; i < competitionswimmers.size() ; i++) {
            System.out.println();
            memberNumber++;
            System.out.println(memberNumber + ". " + competitionswimmers.get(i).toString());
        }
        System.out.println("\n1. Tilbage til menuen\n2. Fjern medlem fra konkurrence svømmere");
        System.out.print("Vælg: ");
        Scanner scanner = new Scanner(System.in);
        int choice4 = 0;
        choice4 = scanner.nextInt();
        switch(choice4){
            case 1:
                break;
            case 2:
                memberNumber = 0;
                for(int i = 0 ; i < competitionswimmers.size() ; i++) {
                    System.out.println();
                    memberNumber++;
                    System.out.println(memberNumber + ". " + competitionswimmers.get(i).toString());
                }
                System.out.println("\nFjern medlem fra kokurrence svømmere ved at skrive tallet foran navnet" +
                                " og tryk enter");
                System.out.print("Vælg: ");
                int removeCompetitionSwimmer = scanner.nextInt()-1;
                competitionswimmers.remove(removeCompetitionSwimmer);
                break;
        }
    }

    //Se medlemmer, opret medlemmer fra medlemsoplysningermenuen eller tilføj medlem til konkurrence svømmere
    public void printAll(){
        int memberNumber = 0;
        for(int i = 0 ; i < members.size() ; i++) {
            System.out.println();
            memberNumber++;
            System.out.println(memberNumber + ". " + members.get(i).toString());
        }
        System.out.println("\n1. Tilbage til menu\n2. Tilføj medlem\n3. Tilføj medlem til konkurrence svømmere");
        System.out.print("Vælg: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                registerAdd();
                break;
            case 3:
                int memberNumber2 = 0;
                System.out.println("Konkurrence svømmere");
                System.out.println("--------------------");
                for(int i = 0 ; i < members.size() ; i++) {
                    System.out.println();
                    memberNumber2++;
                    System.out.println(memberNumber2 + ". " + members.get(i).toString());
                }
                System.out.print("\nTilføj medlem til kokurrence svømmere ved at skrive tallet foran navnet" +
                        " og tryk enter");
                System.out.print("\nVælg: ");
                int choice3 = scanner.nextInt()-1;
                System.out.print("\nHvilke svømmedisciplin ønsker du at være i?");
                scanner.nextLine();
                System.out.println("\n- Butterfly\n- Crawl\n- Rygcrawl\n- Brystsvømning");
                System.out.print("Vælg: ");
                String swimDisciplin = scanner.nextLine();
                Clubmember clubmember = members.get(choice3);
                clubmember.setCompetition("Konkurrence svømmer");
                competitionswimmers.add(new Competitionswimmers(clubmember.getAge(),clubmember.getAgeType(),
                        clubmember.getName(),clubmember.getMemberType(),clubmember.getSubscriptionPrice(),clubmember.getCompetition(),swimDisciplin));
                break;
            default:
                System.out.println("Ikke gyldig valgmulighed, Du er tilbage i menuen");
                break;
        }
    }

    //Tilføj nyt medlem
    public void registerAdd() {
        Scanner scanner = new Scanner(System.in);
        String ageType = "";
        String memberType = "";
        String competition = "";
        String swimmingDisciplin = "";
        double subscriptionPrice;

        System.out.print("\nNavn: ");
        String name = scanner.nextLine();
        System.out.print("\nAlder: ");
        int age = scanner.nextInt();
        if(age < 18){
            ageType = "Ungdom";
        }else if(age > 18 && age < 60 ){
            ageType = "Senior";
        }else if(age > 60){
            ageType = "SeniorPlus";
        }
        System.out.println("\nAktivt eller passivt medlemskab: ");
        System.out.println("1 = Passivt");
        System.out.println("2 = Aktivt");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt();
        if(choice == 1){
            memberType = "Passiv";
        }else if(choice == 2){
            memberType = "Aktiv";
        }
        System.out.println("Konkurrence svømmer?");
        System.out.println("1 = ja");
        System.out.println("2 = nej");
        System.out.print("Vælg: ");
        int choice2 = scanner.nextInt();
        subscriptionPrice = new Subscription().calculateTotalOfSubcriptions(age,memberType);
        if(choice2 == 1){
            competition = "Konkurrence svømmer";
            competitionswimmers.add(new Competitionswimmers(age, ageType, name, memberType, subscriptionPrice, competition, swimmingDisciplin));
            members.add(new Clubmember(age, ageType, name, memberType, subscriptionPrice,competition));
        }else if(choice2 == 2){
            competition = "ikke konkurrence svømmer";
        }

        members.add(new Clubmember(age, ageType, name, memberType, subscriptionPrice, competition));
    }

    public Clubmember searchForClubMember(String name) {
        for (int i = 0; i < members.size(); i++) {
            if(members.get(i).getName().equals(name)){
                return members.get(i);
            }
        }
        return null;
    }
}
