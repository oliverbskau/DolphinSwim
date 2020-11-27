package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SwimmingRecords {

    Register register = new Register();

    public void registerBestSwimtime() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nHvem skal der registreres tid på? ");
        int choice = scanner.nextInt()-1;

        Competitionswimmer competitionswimmer = register.searchForCompetitionswimmer(register.getCompetitionswimmers().get(choice).getName());

        LocalDateTime today = LocalDateTime.now();
        String swimTime;

        System.out.println("Hvad er tiden der skal registeres? (I sekunder)");
        swimTime = scanner.nextLine() + ", " + today;
        System.out.printf("\nTid registreret: %s",swimTime);
        competitionswimmer.setPersonalBest(swimTime);
    }

    public String get5TopSwimmingTimes(ArrayList<Competitionswimmer> competitionswimmers) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Double> top5 = new ArrayList<>();

        for(int i = 0; i < competitionswimmers.size(); i++) {
            String personalBest = competitionswimmers.get(i).getPersonalBest();
            String time = personalBest.substring(0,personalBest.indexOf(','));
            top5.add(Double.parseDouble(time));
        }
        Collections.sort(top5);

        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%d. %.2f",i+1,top5.get(i)));
        }
        return sb.toString();
    }

    /*
    @Override
    public String toString() {
        return
    }
    */
}