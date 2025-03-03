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
    
}
