package com.codesaitma.maventest.ciphers;

import java.util.Scanner;

public class Caesar {

    public static String encode(String message, int shift) {
        String encoded = "";
        shift %= 26;
        final int length = message.length();
        for (int i = 0; i < length; i++) {
        // int current = message.charAt(i); //using char to shift characters because ascii is in-order latin alphabet
            char current = message.charAt(i); // Java law : char + int = char
            if (IsCapitalLatinLetter(current)) {
                current += shift;
                encoded += (char) (current > 'Z' ? current - 26 : current); // 26 = number of latin letters
            } else if (IsSmallLatinLetter(current)) {
                current += shift;
                encoded += (char) (current > 'z' ? current - 26 : current); // 26 = number of latin letters
            } else {
                encoded += current;
            }
        }
        return encoded;
    }

    public static String decode(String encryptedMessage, int shift) {
        String decoded = "";
        shift %= 26;
        final int length = encryptedMessage.length();
        for (int i = 0; i < length; i++) {
            char current = encryptedMessage.charAt(i);
            if (IsCapitalLatinLetter(current)) {
                current -= shift;
                decoded += (char) (current < 'A' ? current + 26 : current);// 26 = number of latin letters
            } else if (IsSmallLatinLetter(current)) {
                current -= shift;
                decoded += (char) (current < 'a' ? current + 26 : current);// 26 = number of latin letters
            } else {
                decoded += current;
            }
        }
        return decoded;
    }

    private static boolean IsCapitalLatinLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean IsSmallLatinLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void callCipher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the message (Latin Alphabet)");
        String message = input.nextLine();
        System.out.println(message);
        System.out.println("Please enter the shift number");
        int shift = input.nextInt() % 26;
        System.out.println("(E)ncode or (D)ecode ?");
        char choice = input.next().charAt(0);
        switch (choice) {
            case 'E':
            case 'e':
                System.out.println("ENCODED MESSAGE IS \n" + new Caesar().encode(message, shift)); //send our function
                // to handle
                break;
            case 'D':
            case 'd':
                System.out.println("DECODED MESSAGE IS \n" + new Caesar().decode(message, shift));
        }
        input.close();
    }
}
