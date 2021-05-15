package com;

import java.util.*;

public class Main {
//    Globals
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    public static Wizard potter = new Wizard();
    public static Character character = new Character();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        String name, roll;
        boolean over = false;
        //Name block
        System.out.println("Welcome to jumanji!!!🤠💖\n" +
                "To win this game you have to get 10 fairies, The way to get fairies is rolling the dice\n" +
                "Depending on the number you can catch fairies or get punched\n" +
                "ALERT, Shrek can get fairies and hurt you 🎂😢\n" +
                "Fairy = 25 point. HP = 10 points");
        do {
            System.out.println("Enter the name of your character");
            name = sc.nextLine();
            if (!name.matches("[A-Za-z\\s]{3,10}"))
                System.out.println("ERROR, you should only enter letters" +
                        "\nMin length: 3" +
                        "\nMax length: 10");
        } while (!name.matches("[A-Za-z\\s]{3,10}"));
        character.setName(name);

        System.out.println("Initial health: " + character.getHealth());
        System.out.println("Initial fairies: " + character.getFairies());
        //Game start
        while (!over) {
            System.out.println("You wanna roll the dice or leave?\n(1) -> Roll\n(2) -> Leave");
            roll = sc.nextLine();

            if (roll.equals("1")) {
                int dice = diceRoll();
                System.out.println("The dice say: " + dice);
                System.out.println("Your health is " + character.getHealth() + "hp");
                if (character.getHealth() == 1)
                    System.out.println(ANSI_RED + "YOUR IN DANGER, YOUR HP IS LOW" + ANSI_RESET);

                if (dice == 1 || dice == 4)
                    wizardMove();
                else if (dice == 2 || dice == 5)
                    getDamaged();
                else if(dice == 3 || dice == 6)
                    fairy();

                //Finish the game
                if (character.getHealth() == 0)
                    over = true;
                if (character.getFairies() == 10) {
                    System.out.println("OMG you have all the fairies, you won buddy!! 🎉🎉🎉");
                    over = true;
                }
                if (potter.getPower() == 2) {
                    System.out.println("Oh no, its too strong and your smol");
                    over = true;
                }
            } else if (roll.equals("2")) {
                System.out.println("Well good bye SIMP 🤠");
                over = true;
            } else
                System.out.println("please enter something valid");
        }
        int score = (character.getFairies() * 25) + (character.getHealth() * 10);
        System.out.println("The score of " + character.getName() + " is: " + score + " points");
        System.out.println("Good luck next time 🤠");
    }

    public static Boolean getPunch() {
        int damaged = (int) (rn.nextDouble() * 2 + 1);
        return damaged == 1;
    }

    public static Boolean getFairy() {
        int fairies = (int) (rn.nextDouble() * 2 + 1);
        return fairies == 1;
    }

    public static int diceRoll() {
        return (int) (rn.nextDouble() * 6 + 1);
    }

    public static void wizardMove() {
        System.out.println("Harry Potter found a fairy");
        if (getFairy()) {
            potter.setFairies(potter.getFairies() + 1);
            if (potter.getFairies() == 10)
                potter.setPower(potter.getPower() + 1);
            else
                System.out.println("The wizard get the fairy");
        } else
            System.out.println("the don't get it jsjsjs");
    }

    public static void getDamaged() {
        System.out.println("You met the ogre in front");
        if (character.getHealth() == 1) {
            if (getPunch()) {
                character.setHealth(character.getDamage());
                System.out.println("Game over buddy, your so bad 😂😂😂");
            } else System.out.println("you don't receive damage, but you have 1hp");
        } else {
            if (getPunch()) {
                character.setHealth(character.getDamage());
                System.out.println("You receive damage, your health is " +
                        character.getHealth() + "hp");
            } else System.out.println("you don't receive damage" +
                    " your health is " + character.getHealth() + "hp");
        }
    }

    public static void fairy() {
        System.out.println("Look a fairy!!!\n" +
                "Careful, they can scape");
        if (getFairy()) {
            character.setFairies(character.getFairies() + 1);
            System.out.println("Well done!!!!\nNow you have " + character.getFairies() +
                    " fairies");
        } else
            System.out.println("The fairy scape...🤦‍");
    }

}
