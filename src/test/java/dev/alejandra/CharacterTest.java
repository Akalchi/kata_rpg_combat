package dev.alejandra;
import dev.alejandra.models.Character;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    @Test
    public void newCharacterShouldHave1000Health() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void newCharacterShouldBeLevel1() {
        Character character = new Character();
        assertEquals(1, character.getLevel());
    }

    @Test
    public void newCharacterShouldBeAlive() {
        Character character = new Character();
        assertTrue(character.isAlive());
    }

    @Test
    public void characterShouldTakeDamage() {
        Character attacker = new Character();
        Character target = new Character();
        
        attacker.dealDamage(target, 100);
        
        assertEquals(900, target.getHealth());
    }

    @Test
    public void characterShouldDieWhenHealthReachesZero() {
        Character attacker = new Character();
        Character target = new Character();
        
        attacker.dealDamage(target, 1000);
        
        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void characterShouldDieWhenHealthBelowZero() {
        Character attacker = new Character();
        Character target = new Character();
        
        attacker.dealDamage(target, 1200);
        
        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void characterShouldBeAbleToHealOtherCharacter() {
        Character healer = new Character();
        Character target = new Character();
        
        target.receiveDamage(200);
        assertEquals(800, target.getHealth());
        
        healer.heal(target, 100);
        assertEquals(900, target.getHealth());
    }
    
    @Test
    public void shouldNotHealDeadCharacter() {
        Character healer = new Character();
        Character target = new Character();
        
        target.receiveDamage(1000);
        assertFalse(target.isAlive());
        
        healer.heal(target, 100);
        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }
    
    @Test
    public void shouldNotHealAboveMaximumHealth() {
        Character healer = new Character();
        Character target = new Character();
        
        target.receiveDamage(100);
        assertEquals(900, target.getHealth());
        
        healer.heal(target, 200);
        assertEquals(1000, target.getHealth());
    }
    
}
