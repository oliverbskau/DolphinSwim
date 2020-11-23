package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    ArrayList<Clubmember> members = new ArrayList<>();

    public void printAll(){
        for(int i = 0 ; i < members.size() ; i++) {
            System.out.println(members.get(i).toString());
        }
    }
    public void registerAdd() {
        Scanner scanner = new Scanner(System.in);
        int ageType = 0;
        int memberType = 0;
        System.out.print("\nNavn: ");
        String name = scanner.nextLine();
        System.out.print("\nAlder: ");
        int age = scanner.nextInt();
        if(age < 18){
            ageType = 1;
        }else if(age > 18 && age < 60 ){
            ageType = 2;
        }else if(age > 60){
            ageType = 3;
        }
        System.out.println("\nAktivt eller passivt medlemskab: ");
        System.out.println("1 = Passivt");
        System.out.println("2 = Aktivt");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt();
        if(choice == 1){
            memberType = 1;
        }else if(choice == 2){
            memberType = 2;
        }
        members.add(new Clubmember(age, ageType, name, memberType));
    }
}
