package dev.alejandra;

public class CharacterTest {
    
    @Test
    public void newCharacterShouldHave1000Health() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
    }
    
}
