package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @version 1.0
 * @author jonas
 */
public class Competitionswimmer extends Clubmember {

    private String swimmingDisciplin;
    private String personalBest;

    public Competitionswimmer(int age, String ageType, String name, String memberType,
                              double subscriptionPrice, String competition , String swimmingDisciplin,
                              String personalBest)
    {
        super(age, ageType, name, memberType, subscriptionPrice, competition);
        this.swimmingDisciplin = swimmingDisciplin;
        this.personalBest = personalBest;
    }

    public void registerBestSwimtime(Competitionswimmer competitionMember) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        String swimTime;

        System.out.println("Hvad er tiden der skal registeres? (I sekunder)");
        swimTime = scanner.nextLine() + ", " + today;
        System.out.printf("\nTid registreret: %s",swimTime);
        competitionMember.setPersonalBest(swimTime);
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

    public String getCompetitionsCompetedIn(Clubmember competitionMember) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
    public String getSwimmingDisciplin() {
        return swimmingDisciplin;
    }
    public void setSwimmingDisciplin(String swimmingDisciplin) {
        this.swimmingDisciplin = swimmingDisciplin;
    }

    public String getPersonalBest() {
        return personalBest;
    }

    public void setPersonalBest(String personalBest) {
        this.personalBest = personalBest;
    }

    public String toString(){
        return "/ Navn: " + getName() + "/ Alder: " + getAge() + "/ Aldersgruppe: " + getAgeType()
                + "/ Medlem status: " + getMemberType() + "/ Kontigent: " + "/ Svømmer status: " + getCompetition()
                + "/ Svømmmedeciplin: " + getSwimmingDisciplin();
    }
}
