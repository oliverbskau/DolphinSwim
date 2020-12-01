package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class FileProcess {

    public void readFile(String path) {
        File file = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }

    public void writeToFile(String path, String text) {

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void loadClubMembers(String path, ArrayList<Clubmember> arrayList) {
        String currentMemberFromFile;

        File file = new File(path);
        Scanner scanner;

        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                currentMemberFromFile = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fil ikke fundet, check om sti'en findes");
            e.printStackTrace();
        }
    }
}






