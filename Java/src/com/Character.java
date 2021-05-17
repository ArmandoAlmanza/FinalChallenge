package com;

public class Character {
    String name;
    int fairies = 0, health = 3;

    public void setName(String name) { this.name = name; }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFairies() {
        return fairies;
    }

    public void setFairies(int fairies) {
        this.fairies = fairies;
    }

    public int getDamage(){ return health - 1; }

    public String getName() { return name; }

    public void damaged(boolean azar){
        System.out.println("You met the ogre in front");
        if (this.getHealth() == 1) {
            if (azar) {
                this.setHealth(this.getDamage());
                System.out.println("Game over buddy, your so bad 😂😂😂");
            } else System.out.println("you don't receive damage, but you have 1hp");
        } else {
            if (azar) {
                this.setHealth(this.getDamage());
                System.out.println("You receive damage, your health is " +
                        this.getHealth() + "hp");
            } else System.out.println("you don't receive damage" +
                    " your health is " + this.getHealth() + "hp");
        }
    }

    public void fairy(boolean azar){
        System.out.println("Look a fairy!!!\n" +
                "Careful, they can scape");
        if (azar) {
            this.setFairies(this.getFairies() + 1);
            System.out.println("Well done!!!!\nNow you have " + this.getFairies() +
                    " fairies");
        } else
            System.out.println("The fairy scape...🤦‍");
    }

}
