package com.company;

import java.time.LocalDate;
import java.util.*;

public class SwimmingRecords {

    public void recordsNavigation(ArrayList<Competitionswimmer> competitionswimmers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSvømmeresultater");
        System.out.println("------------------");
        printAll(competitionswimmers);
        System.out.println("1. Tilbage til menu\n2. Tilføj record\n3. Se top 5 konkurrencesvømmere");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: //Tilbage til menu
                break;
            case 2: //Tilføj rekord
                registerBestSwimtime(competitionswimmers);
                break;
            case 3: //Se top 5
                get5TopSwimmingTimes(competitionswimmers);
                break;
        }
    }

    public void registerBestSwimtime(ArrayList<Competitionswimmer> competitionswimmers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSkriv tallet foran navnet på den der skal ændres tid på");
        System.out.print("Vælg: ");
        int choice = scanner.nextInt()-1;

        Competitionswimmer competitionswimmer = competitionswimmers.get(choice);

        String swimTime;

        scanner.nextLine();

        System.out.println("Hvad er tiden der skal registeres? (I sekunder)");
        System.out.print("Tid: ");
        swimTime = scanner.nextLine() + " Sekunder, " + LocalDate.now();
        System.out.printf("\nTid registreret: %s",swimTime);
        competitionswimmer.setPersonalBest(swimTime);
    }

    public void get5TopSwimmingTimes(ArrayList<Competitionswimmer> competitionswimmers) {
        Collections.sort(competitionswimmers, Comparator.comparing(Competitionswimmer::getPersonalBest));

        for (int i = 0; i < competitionswimmers.size(); i++) {
            System.out.println(competitionswimmers.get(i).getName() + ", " + competitionswimmers.get(i).getPersonalBest());
        }
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
