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

    //method to navigate in menu, using a switch
    public void menuNavigation(Menu menu){

        fileProcess.loadMembers("Resources/Members.txt", register.members);
        fileProcess.loadMembers("Resources/Competitionswimmers.txt", register.competitionswimmers);
        boolean navigator = true;

        while(navigator){

            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();

                switch(choice){

                case 1: //tilføj medlem
                    register.addMembers();
                    break;

                case 2:
                    register.printAll();
                    break;

                case 3: //Kontigenter
                    subscription.subscriptionNavigation(register.members);
                    break;

                case 4: //Svømmetider
                    swimmingRecords.recordsNavigation(register.getCompetitionswimmers());
                    break;

                case 5: //Konkurrencesvømmere
                    register.competitionsSwimmers();
                    break;

                case 6: //afslut program
                    System.exit(0);
                    break;
           }
        }
    }
}
