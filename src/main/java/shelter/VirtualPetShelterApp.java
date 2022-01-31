package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

    public static void main(String[] args) {
        introduction();
        instructions();

        VirtualPetShelter myShelter = new VirtualPetShelter();
        VirtualPet pet1 = new VirtualPet("Belle", "Guinea Pig - Loves to nibble on wood blocks", 1, 1, 1, 1);
        VirtualPet pet2 = new VirtualPet("Mae", "Guinea Pig - Loves to cuddle", 1, 1, 1, 1);
        VirtualPet pet3 = new VirtualPet("Dagwood", "Dog - Ain't nothing but an old hound dog", 1, 1, 1, 1);
        VirtualPet pet4 = new VirtualPet("Riley", "Dog - Loves to hunt moles", 1, 1, 1, 1);

        myShelter.admit(pet1);
        myShelter.admit(pet2);
        myShelter.admit(pet3);
        myShelter.admit(pet4);

        Scanner input = new Scanner(System.in);
        String userInput;
        String petName;

        do {
            myShelter.showPetInfo();
            System.out.println("What would you like to do? Press 0 for instructions.");
            userInput = input.nextLine();

            if (!userInput.matches("^[0-7]$")) {
                System.out.println("You have entered an invalid entry. Please try again.");
                continue;
            }

            switch (userInput) {
                case "0":
                    instructions();
                    break;
                case "1":
                    myShelter.feedAllPets();
                    break;
                case "2":
                    myShelter.waterAllPets();
                    break;
                case "3":
                    System.out.println("Here is a brief description of the animals available for playtime: ");
                    myShelter.showPetTypeDesc();
                    System.out.println("Which pet would you like to play with today? Please enter the pet's name.");
                    petName = input.nextLine();
                    while (!myShelter.doesPetExistInShelter(petName)) {
                        System.out.println("Sorry, that pet is not available for playtime. Please enter another pet's name.");
                        petName = input.nextLine();
                    }
                    myShelter.playWithPet(petName);
                    break;
                case "4":
                    myShelter.bathroomBreakForAll();
                    break;
                case "5":
                    System.out.println("Here is a brief description of the animals available for adoption: ");
                    myShelter.showPetTypeDesc();
                    System.out.println("Which pet would you like to adopt today? Please enter the pet's name.");
                    petName = input.nextLine();
                    while (!myShelter.doesPetExistInShelter(petName)) {
                        System.out.println("Sorry, that pet is not available for adoption. Please enter another pet's name.");
                        petName = input.nextLine();
                    }
                    myShelter.adopt(petName);
                    break;
                case "6":
                    System.out.println("Enter the name of the pet being brought in today: ");
                    petName = input.nextLine();
                    System.out.println("What type of animal is " + petName + "?");
                    String petType = input.nextLine();
                    System.out.println("Please provide a brief description of " + petName + ":");
                    String petDesc = input.nextLine();
                    String petTypeDesc = petType + " - " + petDesc;
                    myShelter.admit(new VirtualPet(petName, petTypeDesc, 1, 1, 1, 1));
                    break;
            }
            myShelter.tick();
            myShelter.healthCheck();
            myShelter.getNumOfPets();
        } while (!userInput.equals("7"));
        System.out.println("Thanks for volunteering at Nicole's Pet Shelter!");
    }

    public static void introduction() {
        System.out.println("(^._.^)()~");
        System.out.println(" `   ` `` ");
        System.out.println("Welcome to Nicole's Pet Shelter.");
        System.out.println("As a volunteer you have the ability to feed, water, allow bathroom breaks and play with pets. You can also adopt out a pet and/or intake new pets.");
        System.out.println("Let's get started!");
        System.out.println(" ");
    }

    public static void instructions() {
        System.out.println("Press 1 to feed all pets");
        System.out.println("Press 2 to give all pets water");
        System.out.println("Press 3 to play with a pet");
        System.out.println("Press 4 to give all pets a bathroom break");
        System.out.println("Press 5 to adopt a pet");
        System.out.println("Press 6 to admit a pet");
        System.out.println("Press 7 to exit the game");
        System.out.println(" ");
    }
}