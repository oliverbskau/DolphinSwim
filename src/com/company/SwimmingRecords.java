package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwimmingRecords {

    Register register = new Register();

    public void registerBestSwimtime(ArrayList<Competitionswimmer> competitionswimmers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSkriv tallet foran navnet på den der skal ændres tid på");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt()-1;

        Competitionswimmer competitionswimmer = competitionswimmers.get(choice);

        LocalDateTime today = LocalDateTime.now();
        String swimTime;

        scanner.nextLine();

        System.out.println("Hvad er tiden der skal registeres? (I sekunder)");
        System.out.print("Tid: ");
        swimTime = scanner.nextLine() + " Sekunder, " + today;
        System.out.printf("\nTid registreret: %s",swimTime);
        competitionswimmer.setPersonalBest(swimTime);
    }

    public String get5TopSwimmingTimes(ArrayList<Competitionswimmer> competitionswimmers) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Double> top5 = new ArrayList<>();

        for(int i = 0; i < competitionswimmers.size(); i++) {
            String personalBest = competitionswimmers.get(i).getPersonalBest();
            String time = personalBest.substring(0,personalBest.indexOf(" Sekunder,"));
            top5.add(Double.parseDouble(time));
        }
        Collections.sort(top5);

        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%d. %.2f",i+1,top5.get(i)));
        }
        return sb.toString();
    }

    public void printAll(ArrayList<Competitionswimmer> competitionswimmers){
        int competitionMember = 0;
        System.out.println();
        for(int i = 0 ; i < competitionswimmers.size(); i++){
            competitionMember++;
            System.out.println(competitionMember + ". " + competitionswimmers.get(i).printSwimRecords());
            System.out.println();
        }
    }

}
