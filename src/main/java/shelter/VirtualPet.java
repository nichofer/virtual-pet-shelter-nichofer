package shelter;

import java.util.Random;

public class VirtualPet {
    private String name;
    private String typeDesc;
    private int hunger;
    private int thirst;
    private int waste;
    private int boredom;
    private boolean isHealthy = true;

    public String getName() {
        return name;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getWaste() {
        return waste;
    }

    public int getBoredom() {
        return boredom;
    }

    public boolean getHealth() {
        return isHealthy;
    }

    public void feedPet() {
        if (hunger != 0) {
            hunger--;
        }
        thirst++;
    }

    public void givePetWater() {
        if (thirst != 0) {
            thirst--;
        }
        hunger++;
    }

    public void bathroomBreak() {
        waste = 0;
        hunger = hunger + 2;
    }

    public void playWithPet() {
        if (boredom > 2) {
            boredom = boredom - 2;
        } else {
            boredom = 0;
        }
        hunger++;
        thirst++;
    }

    public void tick() {
//        boredom++;
        Random rand = new Random();
        int n = rand.nextInt(5);
        if (n == 1) {
            hunger++;
        } else if (n == 2) {
            thirst++;
        } else if (n == 3) {
            waste++;
        } else {
            boredom++;
        }
        if (boredom >= 10 || hunger >= 10 || thirst >= 10 || waste >= 10) {
            isHealthy = false;
        }
    }

    public VirtualPet(String petName, String petTypeDesc, int petHunger, int petThirst, int petWaste, int petBoredom) {
        this.name = petName;
        this.typeDesc = petTypeDesc;
        this.hunger = petHunger;
        this.thirst = petThirst;
        this.waste = petWaste;
        this.boredom = petBoredom;
    }
}