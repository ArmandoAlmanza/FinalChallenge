package com;

public class Character {
    String name;
    int fairies = 0, health = 3;

    public void setName(String name) {
        this.name = name;
    }

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
}
