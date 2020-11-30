package com.company;
/**
 * @author Oliver Brücker Skau
 */

public class Navigation {

    //Navigation of program menu
    Register register = new Register();
    SwimmingRecords swimmingRecords = new SwimmingRecords();
    Subscription subscription = new Subscription();

    /**
     * @author Oliver
     * @param menu
     */

    //method to navigate in menu, using a switch
    public void menuNavigation(Menu menu){

        boolean navigator = true;

        while(navigator){

            menu.printMenu();
            int choice = menu.setChoiceOfMenuAndValidateOutput();

                switch(choice){

                case 1:
                    register.registerAdd();
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

                case 5:
                    register.printCompetitionswimmers();
                    break;

                case 6:
                    System.exit(0);
                    break;
           }
        }
    }
}
