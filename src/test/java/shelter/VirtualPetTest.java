package shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetTest {

    VirtualPet underTest = new VirtualPet("Belle", "Guinea Pig", 1, 1,1,1);

    @Test
    public void shouldReturnVirtualPetName() {
        String actualName = underTest.getName();
        assertEquals("Belle", actualName);
    }

    @Test
    public void shouldReturnPetNameAndTypeDesc() {
        String actualName = underTest.getName();
        String actualType = underTest.getTypeDesc();
        assertEquals("Belle", actualName);
        assertEquals("Guinea Pig", actualType);
    }

    @Test
    public void shouldReturnPetHunger() {
        int actualHunger = underTest.getHunger();
        assertEquals(1, actualHunger);
    }

    @Test
    public void shouldReturnPetThirst() {
        int actualThirst = underTest.getThirst();
        assertEquals(1, actualThirst);
    }

    @Test
    public void shouldReturnPetWaste() {
        int actualWaste = underTest.getWaste();
        assertEquals(1, actualWaste);
    }

    @Test
    public void shouldReturnPetBoredomLevel() {
        int boredomLevel = underTest.getBoredom();
        assertEquals(1, boredomLevel);
    }

    @Test
    public void shouldFeedPet() {
        underTest.feedPet();
        int actualHunger = underTest.getHunger();
        assertEquals(0, actualHunger);
    }

    @Test
    public void shouldGivePetWater() {
        underTest.givePetWater();
        int actualThirst = underTest.getThirst();
        assertEquals(0, actualThirst);
    }

    @Test
    public void shouldPlayWithPet() {
        underTest.playWithPet();
        int boredomLevel = underTest.getBoredom();
        assertEquals(0, boredomLevel);
    }

    @Test
    public void shouldTickPet() {
        underTest.tick();
        assertTrue(underTest.getBoredom()>1||underTest.getHunger()>1||underTest.getThirst()>1);
    }
}