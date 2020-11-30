package com.company;

/**
 * @auther Jonas Kunert
 */

public class Clubmember {

    //Variables to define a member
    private int age;
    private double subscriptionPrice;
    private String ageType;
    private String name;
    private String memberType;
    private String competition;
    private String hasPayed;

    public Clubmember(int age, String ageType, String name, String memberType, double subscriptionPrice, String competition,String hasPayed){
        setAge(age);
        setAgeType(ageType);
        setName(name);
        setMemberType(memberType);
        setCompetition(competition);
        setSubscriptionPrice(subscriptionPrice);
    }

    public Clubmember(){
    }

    //Get age of member
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //Get age group of member
    public String getAgeType() {
        return ageType;
    }
    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    //Get name of member
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Get membership of member
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    //Get if they are competiters or not
    public String getCompetition(){
        return competition;
    }
    public void setCompetition(String competition){
        this.competition = competition;
    }
    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }
    public String getHasPayed() {
        return hasPayed;
    }
    public void setHasPayed(String hasPayed){
        this.hasPayed = hasPayed;
    }

    public String toString(){
        return "/ Navn: " + getName() + "/ Alder: " + getAge() + "/ Aldersgruppe: " + getAgeType()
                + "/ Medlem status: " + getMemberType() + "/ Kontigent: " + getSubscriptionPrice() +"/ Betalt kontigent: " + getHasPayed()
                + "/ Svømmer status: " + getCompetition();
    }

}
