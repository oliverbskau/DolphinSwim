package com.company;

import java.util.Scanner;

/**
 * Generic menu to use in main and further use of navigation class's switch
 */

public class Menu {

    private String menuHeader; //The text above the menu
    private String userChoiceText; //the user gets prompted with a text telling what the user should do
    private String[] menuItems;

    public Menu(String menuHeader, String userChoiceText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.userChoiceText = userChoiceText;
        this.menuItems = menuItems;
    }

    //Visually show the content of menu
    public void printMenu() {
        System.out.println("\n" + menuHeader + "\n----------------");
        System.out.println("Menu: Vælg tal og tryk enter");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i+1 + ": " + menuItems[i]);
        }
    }

    //Checks if the user's input is valid
    public int setChoiceOfMenuAndValidateOutput() {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1; //default value if the choice isn´t made correctly

        while(!validChoice) {
            System.out.print(userChoiceText);

            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validChoice = true;
            } else {
                scanner.next();
            }
        }
        return choice;
    }
}
