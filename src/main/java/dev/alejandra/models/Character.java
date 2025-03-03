package dev.alejandra.models;

public class Character {
    
    private int health = 1000;
    private int level = 1;

    public Character() {
        this.health = 1000;
        this.level = 1;
    }
    
    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }
}
