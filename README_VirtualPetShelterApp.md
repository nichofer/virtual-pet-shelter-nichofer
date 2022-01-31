# VirtualPetShelter
The Virtual Pet Shelter game is a without frills application that was written as a means of practicing basic java principles: creating classes, methods, and loops using test driven development(TDD). 

## Introduction
The application consists of three classes: VirtualPet, VirtualPetShelter, and VirtualPetShelterApp. 
- VirtualPet class sets attributes that a virtual pet has, i.e. hunger, thirst, waste, boredom. Instances of this class are created initially and through user input. 
- VirtualPetShelter class initializes a map that will contain and interact with virtual pets. There is also methods that display status and information of all virtual pets in the shelter throughout the game.
- VirtualPetShelterApp class contains the main method and the game loop where user input is required and writes out to the console. 

The game's objective is to maintain a virtual pet shelter by intaking pets to shelter, adopting them out and interacting with virtual pets without allowing any of their needs to reach 10 points. All virtual pets start out with their needs at 1 point and users can interact with them by feeding, watering, playing with them, and giving them bathroom breaks. An interaction reduces that particular need by one point, but at the same time may increase another need. A tick method increases needs randomly.

The game is a balancing act of interactions to make sure none of the pet's needs reach 10 upon which they will be removed from the shelter. Users are able to give a pets up for adoption or take in a new pets. Once the shelter is empty, you are asked to leave the virtual pet shelter and the game ends.

## Instructions
1 - To feed all pets\
2 - To give all pets water\
3 - To play with a pet\
4 - To give all pets a bathroom break\
5 - To adopt a pet\
6 - To admit a pet\
7 - To exit the game\
0 - To print instructions