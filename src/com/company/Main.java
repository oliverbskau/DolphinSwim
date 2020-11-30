package com.company;


//Main method. Calls method "run", to run entire program
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    //Main method's "run" method for the entire program
    void run(){

        //Implements a generic menu. Header, guide and the menu choices
        String menuHeader = "Delfinen Svømmeklub";
        String userChoiceText = "Skriv menu tal og tryk enter: ";
        String[] menuItems = {"Opret medlem","Medlemsoplysninger",
                "Kontingenter","Svømmeresultater","Konkurrence svømmere","Afslut program"};
        Menu menu = new Menu(menuHeader, userChoiceText, menuItems);

        //Call navigation class, to run "menuNavigation" method
        Navigation navigation = new Navigation();
        navigation.menuNavigation(menu);
    }
}
