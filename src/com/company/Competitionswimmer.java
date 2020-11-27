package com.company;

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

    public Competitionswimmer(){

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

    public String printSwimRecords() {
        return "/ Navn: " + getName() + "/ Svømmedisciplin: " + getSwimmingDisciplin() + "/ Personlig rekord: " + getPersonalBest();
    }

    public String toString(){
       return "/ Navn: " + getName() + "/ Alder: " + getAge() + "/ Aldersgruppe: " + getAgeType()
                + "/ Medlem status: " + getMemberType() + "/ Kontigent: " + "/ Svømmer status: " + getCompetition()
                + "/ Svømmmedeciplin: " + getSwimmingDisciplin();
    }
}
