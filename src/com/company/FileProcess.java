package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
            myWriter.write("\n");
            myWriter.close();
        } catch(IOException e){
                System.err.println("An error occurred.");
                e.printStackTrace();
            }
    }
    public void loadMembers(String path, ArrayList arrayList) {
        String currentMemberFromFile;
        String[] variables;

        File file = new File(path);
        Scanner scanner;

        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                currentMemberFromFile = scanner.nextLine();
                variables = currentMemberFromFile.split("/");

                for (int i = 0; i < variables.length; i++) {
                    String currentVar = variables[i];
                    if(!currentVar.equals("")) {
                        variables[i] = currentVar.substring(currentVar.indexOf(": ")+2);
                    }
                }

                if(path.equals("Resources/Members.txt")){
                    arrayList.add(new Clubmember(
                            //Alder,Aldersgruppe,Navn,Medlem status, Konkurrencesvømmer (Ja/Nej),
                            // Kontigentpris,Betalt kontigent
                            Integer.parseInt(variables[2]),
                            variables[3],
                            variables[1],
                            variables[4],
                            Double.parseDouble(variables[5]),
                            variables[7],
                            variables[6]));
                } else if(path.equals("Resources/Competitionswimmers.txt")) {
                    //Alder,Aldersgruppe,Navn,Medlem status, Konkurrencesvømmer (Ja/Nej),
                    // Kontigentpris,Betalt kontigent,svømmerdisciplin,Personlige rekord
                    arrayList.add(new Competitionswimmer(
                            Integer.parseInt(variables[2]),
                            variables[3],
                            variables[1],
                            variables[4],
                            Double.parseDouble(variables[5]),
                            variables[7],
                            variables[6],
                            variables[8],
                            variables[9]));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fil ikke fundet, check om sti'en findes");
            e.printStackTrace();
        }
    }
}