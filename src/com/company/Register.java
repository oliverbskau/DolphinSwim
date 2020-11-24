package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Oliver Brücker Skau
 * @author Jonas Kunert
 */

public class Register {
    ArrayList<Clubmember> members = new ArrayList<>();

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

                break;
            default:
                System.out.println("Ikke gyldig valgmulighed, Du er tilbage i menuen");
                break;
        }
    }

    public void registerAdd() {
        Scanner scanner = new Scanner(System.in);
        String ageType = "";
        String memberType = "";
        String competition = "";
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
        if(choice2 == 1){
            competition = "Konkurrence svømmer";
        }else if(choice2 == 2){
            competition = "ikke konkurrence svømmer";
        }
        members.add(new Clubmember(age, ageType, name, memberType, competition));
    }
}
