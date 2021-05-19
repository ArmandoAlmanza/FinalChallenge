package com;

public class Wizard{
    int power = 1, fairies = 10;

    public int getPower() { return power; }

    public void setPower(int power) { this.power = power; }

    public int getFairies() { return fairies; }

    public void setFairies(int fairies) { this.fairies = fairies; }

    public void move(boolean azar){
        System.out.println("Harry Potter found a fairy");
        if (azar) {
            this.setFairies(this.getFairies() + 3);
            if (this.getFairies() == 22)
                this.setPower(this.getPower() + 1);
            else
                System.out.println("The wizard get the fairy"+
				"\nThe wizard destroy the house");
        } else
            System.out.println("the don't get it jsjsjs");
    }
}
