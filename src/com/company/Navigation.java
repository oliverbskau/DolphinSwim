package com.company;
/**
 * @author Oliver Brücker Skau
 */

public class Navigation {

    //Navigation of program menu
    Register register = new Register();

    /**
     * @author Oliver
     * @param menu
     */
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

                case 3: //Kontigenter - lav sådan at man kan se alle personers pris for kontigenter og restance hvis der er nogle
                    double total = new Subscription().getTotalOfSubscriptions(register.members);

                    break;

                case 4:
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
