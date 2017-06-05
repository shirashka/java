package com.shira;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Characters {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Shira's Unique Character Search function!");
        System.out.println("Please enter a string.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userString = br.readLine();

        //Remove any spaces from the String
        userString = userString.replaceAll("\\s", "");

        char[] upperString = (userString.toUpperCase()).toCharArray();
        ArrayList<String> results = processString(upperString);

        //Display results
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println("\nThanks for playing!");
    }

    /**
     * This method counts how many of each character are inside of the string.
     * @param input Char array holding the user's input
     * @return Returns a String ArrayList containing the amount of each character.
     *
     * */
    private static ArrayList<String> processString(char[] input) {

        ArrayList<String> resultList = new ArrayList<>(); //To hold the result string
        Set<Character> badIndex = new HashSet<>(); // To hold the duplicates

        //Retrieves each letter from the input array
        for (int i = 0; i < input.length; i++) {
            char letter = input[i];

            //Block duplicates
            if (!badIndex.contains(letter)) {
                //Takes each letter and searches the array for it
                int resultsFound = 0;
                for (char anInput : input) {
                    if (anInput == letter) {
                        resultsFound++;
                    }
                }

                resultList.add(letter + ":" + resultsFound);
                if (resultsFound > 0) {
                    badIndex.add(letter);
                }
            }
        }
        return resultList;
    }
}
