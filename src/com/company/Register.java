package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    ArrayList<Clubmember> members = new ArrayList<>();

    public void printAll(){
        int memberNumber = 0;
        for(int i = 0 ; i < members.size() ; i++) {
            System.out.println("");
            memberNumber++;
            System.out.println(memberNumber + ". " + members.get(i).toString());
        }
    }

    public void registerAdd() {
        Scanner scanner = new Scanner(System.in);
        String ageType = "";
        String memberType = "";
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
        members.add(new Clubmember(age, ageType, name, memberType));
    }
}
