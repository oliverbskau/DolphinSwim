package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class FileProcess {


        public void readfile(String path)
        {
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
public void writetofile(String path,String text){

            try {
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(text);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }






