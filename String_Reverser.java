package com.shira;

import java.io.*;

public class String_Reverser {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Shira's String Reversal function!");
        System.out.println("Please enter a string.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userString = br.readLine();
        char[] inputArray = userString.toCharArray();

        String result = reverseString(inputArray);
        System.out.println(result + "\nThanks for playing!");
    }

    /**
     * This method accepts a char array and
     * returns it with the characters in reverse order.
     * @param input The user's string of characters for reversal
     * @return The reversed string
     */
    public static String reverseString(char[] input) {
        int inputLen = input.length;
        int middle = (inputLen/2);

        //Take each char and flip its position in the array.
        for( int i = 0; i < middle; i++) {
            char letter = input[i];
            input[i] = input[inputLen - 1 - i];
            input[inputLen -1 -i] = letter;
        }
        return new String(input);
    }
}
