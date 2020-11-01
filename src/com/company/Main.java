package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        // Filnavn
        System.out.println("Skriv navnet på den fil du vil arbejde med - f.eks. numbers.txt");
        String fileName = scan.nextLine();

        // Menu selection
        int tal = 0;
        while (true) {
            // Menu
            visMenu();

            // Variable
            tal = indtastTal();
            scan.nextLine();

            // Handlinger i forhold til valg
            switch (tal) {
                case 1:
                    // Opret fil
                    try {
                        File myObj = new File(fileName);
                        if (myObj.createNewFile()) {
                            System.out.println("Filen er oprettet: " + myObj.getName());
                        } else {
                            System.out.println("Filen findes allerede!");
                        }
                    } catch (IOException e) {
                        System.out.println("Der opstod en fejl - Beklager 1");
                        e.printStackTrace();

                    }
                    break;
                case 2:
                    try {
                        FileWriter myWriter = new FileWriter(fileName);
                        for (int i = 1; i < 10000; i++) {
                            myWriter.write(String.format("%d\n", i));
                        }
                        myWriter.close();
                        System.out.println("Tal er skrevet til filen");
                    } catch (IOException e) {
                        System.out.println("Der opstod en fejl - Beklager 2");
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    // Læs fra fil
                    ArrayList<Integer> numbers = new ArrayList<Integer>();
                    Scanner input = new Scanner(new File(fileName));

                    while (input.hasNextInt()) {
                        int n = input.nextInt();
                        numbers.add(n);
                    }

                    System.out.println(numbers);
                    filterEvens(numbers);
                    System.out.println(numbers);
                    break;
                default: System.exit(1);
            }
            System.out.println("\nTryk enter for at returnere til hovedmenu");
            scan.nextLine();
        }

    }

    public static void filterEvens(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i);
            if (n % 2 == 0) {
                list.remove(i);
            }
        }
    }

    // Menu
    public static void visMenu() {
        System.out.println("\nHovedmenu - 9 afslutter programmet\n");
        System.out.println("1. Opret fil");
        System.out.println("2. Skriv til fil");
        System.out.println("3. Læs fra fil");
        System.out.print("\nIndtast menu nummer: ");
    }

    // Check for tal
    public static int indtastTal(){
        int tal = 0;
        while(!scan.hasNextInt()){
            System.out.println("\nDu skal skrive et tal!");
            System.out.print("Indtast menu nummer: ");
            scan.nextLine();
        }
        tal = scan.nextInt();
        return tal;
    }
}
