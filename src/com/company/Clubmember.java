package com.company;

public class Clubmember {
    //Variables to define a member
    int age;
    String ageType;
    String name;
    String memberType;


    public Clubmember(int age, String ageType, String name, String memberType){
        setAge(age);
        setAgeType(ageType);
        setName(name);
        setMemberType(memberType);
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

    public String toString(){
        return "/ Navn: " + getName() + "/ Alder: " + getAge() + "/ Aldersgruppe: " + getAgeType()
                + "/ Medlem status: " + getMemberType();
    }

}
