package com.company;

public class Navigation {

    //Navigation of program menu
    Register register = new Register();
    public void menuNavigation(){

        boolean navigator = true;

        int choice = 0;
        while(navigator){
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
