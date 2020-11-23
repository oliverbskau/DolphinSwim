package com.company;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    void run(){

        String menuHeader = "Delfinen Svømmeklub";
        String userChoiceText = "Skriv menu tal og tryk enter: ";
        String[] menuItems = {"Opret medlem","Medlemsoplysninger",
                "Kontingenter","Svømmeresultater","Konkurrence svømmere","Afslut program"};
        Menu menu = new Menu(menuHeader, userChoiceText, menuItems);

        Navigation navigation = new Navigation();
        navigation.menuNavigation(menu);
    }
}
