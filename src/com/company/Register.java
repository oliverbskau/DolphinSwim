package com.company;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Oliver Brücker Skau
 * @author Jonas Kunert
 */

public class Register {

    FileProcess fileProcess = new FileProcess();
    ArrayList<Clubmember> members = new ArrayList<>();
    ArrayList<Competitionswimmer> competitionswimmers = new ArrayList<>();

    //Prints the competition members, and gives you the choice to remove them again.
    public void competitionsSwimmers(){
        printAllOfList(competitionswimmers);

        System.out.println("\n1. Tilbage til menuen\n2. Fjern medlem fra konkurrence svømmere");
        System.out.print("Vælg: ");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        switch(choice){
            case 1: //Tilbage til menu
                break;
            case 2: //Fjern medlem fra konkurrencesvømmere
                printAllOfList(competitionswimmers);
                System.out.println("\nFjern medlem fra kokurrence svømmere ved at skrive tallet foran navnet" +
                                " og tryk enter");
                System.out.print("Vælg: ");
                int removeCompetitionSwimmer = scanner.nextInt()-1;
                searchForClubMember(competitionswimmers.get(removeCompetitionSwimmer).getName())
                        .setCompetition("ikke konkurrence svømmer");
                fileProcess.removeFromFile("Resources/Competitionswimmers.txt",
                        competitionswimmers.get(removeCompetitionSwimmer).toString());
                competitionswimmers.remove(removeCompetitionSwimmer);
                break;
        }
    }

    //See members, assign members directly from member informations. Assign a member to competitionmembers. Or remove a member
    //Choices defined above, are chosen with a switch.
    public void membershipOptions(){
        printAllOfList(members);

        System.out.println("\n1. Tilbage til menu\n2. Tilføj medlem\n3. Tilføj medlem til konkurrence svømmere" +
                "\n4. Fjern medlem\n5. Skift medlem status");
        System.out.print("Vælg: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1: //Tilbage til menu
                break;
            case 2: //Tilføj medlemmer
                addMembers();
                break;
            case 3: //Tilføj medlemmer til konkurrencesvømmere
                int memberNumber2 = 0;
                System.out.println("Konkurrence svømmere");
                System.out.println("--------------------");
                printAllOfList(members);
                System.out.print("\nTilføj medlem til kokurrence svømmere ved at skrive tallet foran navnet" +
                        " og tryk enter");
                System.out.print("\nVælg: ");
                int choice3 = scanner.nextInt()-1;
                //if you chose index out of bounce, you go back to the menu
                if (choice3 < competitionswimmers.size()||choice3 > competitionswimmers.size()){
                    System.out.println("Tallet du har indtastet stemmer ikke overens med eksisterende medlem.\n" +
                            "Du er tilbage i hovedmenu.");
                    break;
                }
                //if you chose the correct index, the process continues
                System.out.print("\nHvilke svømmedisciplin skal personen tilføjes til?");
                scanner.nextLine();
                System.out.println("\n- Butterfly\n- Crawl\n- Rygcrawl\n- Brystsvømning");
                System.out.print("Vælg: ");
                String swimDisciplin = scanner.nextLine();
                Clubmember clubmember = members.get(choice3);
                clubmember.setCompetition("Konkurrence svømmer");
                competitionswimmers.add(new Competitionswimmer(clubmember.getAge(),clubmember.getAgeType(),
                        clubmember.getName(),clubmember.getMemberType(),clubmember.getSubscriptionPrice(),clubmember.getHasPayed(),clubmember.getCompetition(),swimDisciplin,"0"));
                break;
            case 4: //Fjern et medlem
                printAllOfList(members);
                System.out.println("\nSkriv tallet foran navnet på den person som skal fjernes og tryk enter");
                System.out.print("Vælg: ");
                int removeMember = scanner.nextInt()-1;
                fileProcess.removeFromFile("Resources/Members.txt",members.get(removeMember).toString());
                members.remove(removeMember);
                if (competitionswimmers.size()>0) {
                    competitionswimmers.remove(searchForCompetitionswimmer(members.get(removeMember).getName()));
                }
                break;
            case 5: //Skift medlemsstatus
                printAllOfList(members);
                System.out.println("\nSkriv tallet foran navnet på den person som skal have ændret status" +
                        " og tryk enter");
                System.out.print("Vælg: ");
                int currentMemberIndex = scanner.nextInt()-1;
                Clubmember memberStatus = searchForClubMember(members.get(currentMemberIndex).getName());

                if (memberStatus.getMemberType().equals("Passiv")){
                    memberStatus.setMemberType("Aktiv");
                    if(competitionswimmers.size()>0)
                    searchForCompetitionswimmer(members.get(currentMemberIndex).getName()).setMemberType("Aktiv");
                }else if(memberStatus.getMemberType().equals("Aktiv")){
                    memberStatus.setMemberType("Passiv");
                    if(competitionswimmers.size()>0)
                    searchForCompetitionswimmer(members.get(currentMemberIndex).getName()).setMemberType("Passiv");
                }
                break;

            default:
                System.out.println("Ikke gyldig valgmulighed, Du er tilbage i menuen");
                break;
        }
    }

    //Assign a new member and choose attributes with a Scanner class
    public void addMembers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n1. Fortsæt\n2. Fortryd\nVælg: ");
        int regret = scanner.nextInt();

        switch (regret) {
            case 1:
            String ageType = "";
            String memberType = "";
            String competition = "";
            String swimmingDisciplin = "";
            double subscriptionPrice;

            scanner.nextLine();
            System.out.print("\nNavn: ");
            String name = scanner.nextLine();
            System.out.print("\nAlder: ");
            int age = scanner.nextInt();
            if (age < 18) {
                ageType = "Ungdom";
            } else if (age > 18 && age < 60) {
                ageType = "Senior";
            } else if (age > 60) {
                ageType = "SeniorPlus";
            }
            System.out.println("\nAktivt eller passivt medlemskab: ");
            System.out.println("1 = Passivt");
            System.out.println("2 = Aktivt");
            System.out.print("Vælg: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                memberType = "Passiv";
            } else if (choice == 2) {
                memberType = "Aktiv";
            }
            System.out.println("Konkurrence svømmer?");
            System.out.println("1 = ja");
            System.out.println("2 = nej");
            System.out.print("Vælg: ");
            int choice2 = scanner.nextInt();
            subscriptionPrice = new Subscription().calculateTotalOfSubcriptions(age, memberType);
            if (choice2 == 1) {
                competition = "Konkurrence svømmer";
                System.out.print("\nHvilke svømmedisciplin ønsker du at være i?");
                scanner.nextLine();
                System.out.println("\n- Butterfly\n- Crawl\n- Rygcrawl\n- Brystsvømning");
                System.out.print("Vælg: ");
                swimmingDisciplin = scanner.nextLine();
                competitionswimmers.add(new Competitionswimmer(age, ageType, name, memberType, subscriptionPrice, "Nej", competition, swimmingDisciplin, "0"));
                new FileProcess().writeToFile("Resources/Competitionswimmers.txt", competitionswimmers.get(competitionswimmers.size() - 1).toString());
            } else if (choice2 == 2) {
                competition = "ikke konkurrence svømmer";
            }
            members.add(new Clubmember(age, ageType, name, memberType, subscriptionPrice, competition, "Nej"));
            fileProcess.writeToFile("Resources/Members.txt", members.get(members.size() - 1).toString());
            break;
            case 2:
                break;
        }
    }

    //Search for a specifik member. this is used when there is a change for a member in an arraylist of members.
    //then the changes has to be the same for the same member in other arraylists
    public Clubmember searchForClubMember(String name) {
        for (int i = 0; i < members.size(); i++) {
            if(members.get(i).getName().equals(name)){
                return members.get(i);
            }
        }
        return null;
    }

    //Search for a specifik competitionmember. this is used when there is a change for a member in an arraylist of members.
    //then the changes has to be the same for the same member in other arraylists
    public Competitionswimmer searchForCompetitionswimmer(String name) {
        for (int i = 0; i < competitionswimmers.size(); i++) {
            if(competitionswimmers.get(i).getName().equals(name)){
                return competitionswimmers.get(i);
            }
        }
        return null;
    }

    //Method to print all members of Competitionswimmers or clubmembers
    public void printAllOfList(ArrayList arrayList) {
        int memberNumber = 0;
        for(int i = 0 ; i < arrayList.size() ; i++) {
            System.out.println();
            memberNumber++;
            System.out.println(memberNumber + ". " + arrayList.get(i).toString());
        }
    }

    public ArrayList<Competitionswimmer> getCompetitionswimmers() {
        return competitionswimmers;
    }
}