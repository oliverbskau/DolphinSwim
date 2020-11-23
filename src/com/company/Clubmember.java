package com.company;

public class Clubmember {
    //Variables to define a member
    int age;
    int ageType;
    String name;
    int memberType;


    public Clubmember(int age, int ageType, String name, int memberType){
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
    public int getAgeType() {
        return ageType;
    }
    public void setAgeType(int ageType) {
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
    public int getMemberType() {
        return memberType;
    }
    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public String toString(){
        return "navn" + "age" + "ageType" + "memberType";
    }

}
