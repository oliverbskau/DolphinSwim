package com.company;

/**
 * @version 1.0
 * @author jonas
 */
public class Competitionswimmer extends Clubmember {

    private String swimmingDisciplin;
    private String personalBest;

    public Competitionswimmer(int age, String ageType, String name, String memberType,
                              double subscriptionPrice, String hasPayed, String competition , String swimmingDisciplin,
                              String personalBest)
    {
        super(age, ageType, name, memberType, subscriptionPrice, competition, hasPayed);
        this.swimmingDisciplin = swimmingDisciplin;
        this.personalBest = personalBest;
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
                + "/ Medlem status: " + getMemberType() + "/ Kontigent: " + getSubscriptionPrice() + "/ Betalt Kontigent: "
                + getHasPayed() + "/ Svømmer status: " + getCompetition() + "/ Svømmmedisciplin: "
                + getSwimmingDisciplin() +  "/ Personlige rekord: " + getPersonalBest();
    }
}
