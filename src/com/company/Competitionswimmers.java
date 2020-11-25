package com.company;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @version 1.0
 * @author jonas
 */
public class Competitionswimmers extends Clubmember {

    String swimmingDisciplin;

    public Competitionswimmers(int age, String ageType, String name, String memberType, double subscriptionPrice, String competition ,String swimmingDisciplin) {
        super(age, ageType, name, memberType, subscriptionPrice, competition);
        this.swimmingDisciplin = swimmingDisciplin;
    }

    public String registerBestSwimtime(Clubmember competitionMember) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        String swimTime;

        System.out.println("Hvad er tiden der skal registeres? (minut:sekunder) = (0:00)");
        swimTime = scanner.nextLine() + ", " + today;

        return swimTime;
    }

    public String getTopSwimmingTime(Clubmember competitionMember) {

        return "";
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

    public String toString(){
        return "/ Navn: " + getName() + "/ Alder: " + getAge() + "/ Aldersgruppe: " + getAgeType()
                + "/ Medlem status: " + getMemberType() + "/ Kontigent: " + "/ Svømmer status: " + getCompetition()
                + "/ Svømmmedeciplin: " + getSwimmingDisciplin();
    }
}
