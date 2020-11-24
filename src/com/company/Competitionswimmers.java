package com.company;

/**
 * @version 1.0
 * @author jonas
 */
public class Competitionswimmers extends Clubmember {

    String swimmingDisciplin;

    public Competitionswimmers(int age, String ageType, String name, String memberType, String competition) {
        super(age, ageType, name, memberType, competition);
    }

    public String getTopSwimmingTime(Clubmember clubmember) {

        return "";
    }




    public String getSwimmingDisciplin() {
        return swimmingDisciplin;
    }

    public void setSwimmingDisciplin(String swimmingDisciplin) {
        this.swimmingDisciplin = swimmingDisciplin;
    }
}
