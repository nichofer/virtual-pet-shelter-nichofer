package shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {

    VirtualPetShelter underTest;
    VirtualPet pet1;
    VirtualPet pet2;

    @BeforeEach
    public void setUp() {
        underTest = new VirtualPetShelter();
        pet1 = new VirtualPet("Belle", "Guinea Pig", 1, 1,1, 1);
        pet2 = new VirtualPet("Dagwood", "Dog", 1, 1,1, 1);
    }

    @Test
    public void shouldAdmitVirtualPet() {
        underTest.admit(pet1);
        VirtualPet admitPet = underTest.findPet("Belle");
        assertEquals(admitPet, pet1);
    }

    @Test
    public void shouldCheckIfPetExists() {
        underTest.admit(pet1);
        assertTrue(underTest.doesPetExistInShelter("Belle"));
    }

    @Test
    public void shouldReturnAllVirtualPets() {
        underTest.admit(pet1);
        underTest.admit(pet2);
        Collection<VirtualPet> allPets = underTest.getAllPets();
        assertEquals(2, allPets.size());
    }

    @Test
    public void shouldAdoptAVirtualPet() {
        underTest.admit(pet1);
        underTest.adopt("Belle");
        VirtualPet adoptPet = underTest.findPet("Belle");
        assertEquals(adoptPet, null);
    }

    @Test
    public void shouldPlayWithOnePet() {
        underTest.admit(pet1);
        underTest.playWithPet("Belle");
        assertEquals(underTest.findPet("Belle").getBoredom(), 0);
    }

    @Test
    public void shouldFeedAllPets() {
        underTest.admit(pet1);
        underTest.admit(pet2);
        underTest.feedAllPets();
        assertEquals(underTest.findPet("Belle").getHunger(), 0);
        assertEquals(underTest.findPet("Dagwood").getHunger(), 0);
    }

    @Test
    public void shouldGiveAllPetsBathroomBreak(){
        underTest.admit(pet1);
        underTest.admit(pet2);
        underTest.bathroomBreakForAll();
        assertEquals(underTest.findPet("Belle").getWaste(),0);
        assertEquals(underTest.findPet("Dagwood").getWaste(),0);
    }

    @Test
    public void shouldGiveAllPetsWater() {
        underTest.admit(pet1);
        underTest.admit(pet2);
        underTest.waterAllPets();
        assertEquals(underTest.findPet("Belle").getThirst(), 0);
        assertEquals(underTest.findPet("Dagwood").getThirst(), 0);
    }

    @Test
    public void shouldCheckPetsHealth() {
        underTest.admit(pet1);
        underTest.admit(pet2);
        underTest.healthCheck();
        assertTrue(underTest.findPet("Belle").getHealth());
        assertTrue(underTest.findPet("Dagwood").getHealth());
    }
}