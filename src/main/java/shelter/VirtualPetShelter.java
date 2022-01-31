package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VirtualPetShelter {

    Map<String, VirtualPet> pets = new ConcurrentHashMap<>();

    public void admit(VirtualPet petToAdd) {
        pets.put(petToAdd.getName(), petToAdd);
        System.out.println(petToAdd.getName() + " has been accepted into Nicole's Pet Shelter.");
    }

    public VirtualPet findPet(String petName) {
        return pets.get(petName);
    }

    public boolean doesPetExistInShelter(String petName) {
        if (pets.containsKey(petName)) {
            return true;
        } else {
            return false;
        }
    }

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public void getNumOfPets() {
        if (pets.size() == 0) {
            System.out.println("The shelter is now empty. Thank you for volunteering at Nicole's Pet Shelter!");
            System.exit(0);
        }
    }

    public void adopt(String petToRemove) {
        pets.remove(petToRemove);
        System.out.println("Thank you for adopting " + petToRemove + ".");
    }

    public void playWithPet(String petName) {
        pets.get(petName).playWithPet();
        System.out.println(petName + " really enjoyed playing!");
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.feedPet();
        }
        System.out.println("You have fed the pets.");
    }

    public void waterAllPets() {
        for (VirtualPet pet : pets.values()) {
            pet.givePetWater();
        }
        System.out.println("You have filled the pets water.");
    }

    public void bathroomBreakForAll() {
        for (VirtualPet pet : pets.values()) {
            pet.bathroomBreak();
        }
        System.out.println("You have given the pets a bathroom break.");
    }

    public void healthCheck() {
        for (VirtualPet pet : pets.values()) {
            if (pet.getHealth()) {
                continue;
            } else {
                System.out.println(pet.getName() + " is unwell and has been removed from the shelter.");
                pets.remove(pet.getName());
            }
        }
    }

    public void tick() {
        for (VirtualPet pet : pets.values()) {
            pet.tick();
        }
    }

    public void showPetInfo() {
        System.out.println(" ");
        System.out.println("Animals currently being sheltered and their status: ");
        System.out.println("Name\t|\tHunger\t|\tThirst\t|\tWaste\t|\tBoredom\t");
        System.out.println("----------------------------------------------------------");
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.getName() + "\t|\t " + pet.getHunger() + "\t|\t\t" + pet.getThirst() + "\t|\t\t" + pet.getWaste() + "\t|\t\t" + pet.getBoredom());
        }
        System.out.println(" ");
    }

    public void showPetTypeDesc() {
        for (VirtualPet pet : pets.values()) {
            System.out.println(pet.getName() + " - " + pet.getTypeDesc());
        }
        System.out.println(" ");
    }
}