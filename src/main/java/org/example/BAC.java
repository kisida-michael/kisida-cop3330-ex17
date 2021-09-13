package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Michael Kisida
 */


import java.util.Scanner;


public class BAC
{
    public static double math(int A, int W, double r, int H ){

       double BAC = (A * 5.14 / W * r)-.015 * H;
        return BAC;
    }
    public static boolean isNum(String str){

        try {
            int val= Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            // System.out.println("Input String must be numeric.");
        }
        return false;
    }
    public static void main( String[] args ) {
        int gender = 0;
        int weight = 0;
        int hours = 0;
        int amount= 0;
        double ratio =0;
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        boolean valid = false;
        System.out.print("Enter a 1 if you are a male or a 2 if you are a female: ");
        while (!valid) {

            String R = input.nextLine();  // Read user input
            if (isNum(R)) {

                gender = Integer.parseInt(R);
                valid = true;
            } else {
                System.out.println("Input is not numeric!");

            }

        }
        valid = false;
        System.out.print("How many ounces of alcohol did you have? ");
        while (!valid) {
            String A = input.nextLine();  // Read user input
            if (isNum(A)) {
                amount = Integer.parseInt(A);
                valid = true;
            } else {
                System.out.println("Input is not numeric!");

            }
        }
        valid = false;
        System.out.print("What is your weight, in pounds? ");
        while (!valid) {
            String W = input.nextLine();  // Read user input
            if (isNum(W)) {
                weight = Integer.parseInt(W);
                valid = true;
            } else {
                System.out.println("Input is not numeric!");

            }
        }
        valid = false;
        System.out.print("How many hours has it been since your last drink? ");
        while (!valid) {
            String H = input.nextLine();  // Read user input
            if (isNum(H)) {
                hours = Integer.parseInt(H);
                valid = true;
            } else {
                System.out.println("Input is not numeric!");

            }
        }
        if  (gender == 1){
             ratio = 0.73;
        }
        else if (gender == 2) {
             ratio = 0.66;
        }

        double bac = math(amount, weight, ratio, hours);
        String message = " ";
        if (bac > .08) {
           message  = "It is not legal for you to drive.";
        }
        else {
            message = "It is legal for you to drive.";
        }
        String output1 = String.format("Your BAC is %.7f\n%s", bac, message);
        System.out.println(output1);
        input.close();
    }

}
