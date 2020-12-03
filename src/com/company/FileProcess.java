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
            FileWriter myWriter = new FileWriter(path, true);
            myWriter.write(text);
            myWriter.write("\n");
            myWriter.close();
        } catch(IOException e){
                System.err.println("An error occurred.");
                e.printStackTrace();
        }
    }

    public void removeFromFile(String path, String memberToBeDeleted){
        File file = new File(path);
        String currentLine;

        try {

            File tempFile = new File(file.getAbsolutePath() + ".tmp");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            while((currentLine = reader.readLine()) != null) {
                if(!currentLine.equals(memberToBeDeleted)) {
                    writer.write(currentLine);
                    writer.write("\n");
                    writer.flush();
                }

            }

            writer.close();
            reader.close();

            if (!file.delete()) {
                System.out.println("Kunne ikke slette filen, Fileprocess.java linje 56");
                return;
            }

            if (!tempFile.renameTo(file)) {
                System.out.println("Kunne ikke omnavngive filen, Fileprocess.java linje 61");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
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
                            Integer.parseInt(variables[2]),//Alder
                            variables[3],//Aldersgruppe
                            variables[1],//Navn
                            variables[4],//Medlem status
                            Double.parseDouble(variables[5]),//Konkurencesvømmer(ja/nej)
                            variables[7],//Kontantpris
                            variables[6]));//Betalt kontingent
                } else if(path.equals("Resources/Competitionswimmers.txt")) {
                    //Alder,Aldersgruppe,Navn,Medlem status, Konkurrencesvømmer (Ja/Nej),
                    // Kontigentpris,Betalt kontigent,svømmedisciplin,Personlige rekord
                    arrayList.add(new Competitionswimmer(
                            Integer.parseInt(variables[2]),//Alder
                            variables[3],//Aldersgruppe
                            variables[1],//Navn
                            variables[4],//Medlem Status
                            Double.parseDouble(variables[5]),//Kontigentpris
                            variables[7],//Konkurencesvømmer (ja/nej)
                            variables[6],//btalt kontigent
                            variables[8],//Svømmedisciplin
                            variables[9]));//Personlig record
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fil ikke fundet, check om sti'en findes");
            e.printStackTrace();
        }
    }
}