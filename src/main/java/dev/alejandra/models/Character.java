package dev.alejandra.models;

public class Character {
    
    private int health = 1000;
    private int level = 1;
    private boolean alive;

    public Character() {
        this.health = 1000;
        this.level = 1;
        this.alive = true;
    }
    
    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }   

    public void dealDamage(Character target, int damage) {
        target.health -= damage;
        if (target.health <= 0) {
            target.health = 0;
            target.alive = false;
        }
    }

    public void receiveDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        
        health = Math.max(0, health - amount);
        
        if (health == 0) {
            alive = false;
        }
    }

    public void heal(Character target, int amount) {
        if (!target.isAlive()) {
            return; 
        }
        
        if (amount < 0) {
            throw new IllegalArgumentException("Healing amount cannot be negative");
        }
        
        target.health = Math.min(1000, target.health + amount);
    }


}
