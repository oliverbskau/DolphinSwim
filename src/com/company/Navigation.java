package com.company;
import java.util.Scanner;

public class Navigation {

    //Navigation of program menu
    Register register = new Register();
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

               case 3:
                   break;

               case 4:
                   break;

               case 5:
                   break;

               case 6:
                   System.exit(0);
                   break;



           }
        }
    }
}