package com.company;

/**
 * @author Oliver Brücker Skau
 */

public class Navigation {

    //Navigation of program menu
    Register register = new Register();
    SwimmingRecords swimmingRecords = new SwimmingRecords();
    Subscription subscription = new Subscription();
    FileProcess fileProcess = new FileProcess();

    /**
     * @author Oliver
     * @param menu
     */

    //method to navigate in menu using a switch
    public void menuNavigation(Menu menu){

        fileProcess.loadMembers("Resources/Members.txt", register.members);
        fileProcess.loadMembers("Resources/Competitionswimmers.txt", register.competitionswimmers);

        boolean navigatorOfMenu = true;

        while(navigatorOfMenu){

            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();

            switch (choice) {
                //tilføj medlem
                case 1 -> register.addMembers();
                //Se og rediger medlemsoplysninger
                case 2 -> register.membershipOptions();
                //Kontigenter
                case 3 -> subscription.subscriptionNavigation(register.members);
                //Svømmetider
                case 4 -> swimmingRecords.recordsNavigation(register.getCompetitionswimmers());
                //Konkurrencesvømmere
                case 5 -> register.competitionsSwimmers();
                //afslut program
                case 6 -> System.exit(0);
                }
            }
        }
    }

