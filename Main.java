import pet.attributes.PetEnergyLevel;
import pet.categories.Dog;
import pet.Pet;
import pet.PetActions;
import util.Validator;

import java.util.List;
import java.util.Scanner;

public class Main {

    enum SUPPORTED_PET {
        DOG
    }

    private static String initiateDialogAndGetInput(Scanner scanner) 	
	{
        System.out.println("Hi! Let's build a pet. Enter the type of pet you want");
        String petType = scanner.next();
        if (!Validator.validInput(petType)) 
		{
            System.out.println("Oops! Invalid choice, number should be between 1 and 4. Try again!");
            petType = scanner.next();
            if (!(Validator.validInput(petType))) 
		{
                System.out.println("Too many incorrect options. Existing the app.");
                System.exit(0);

	
            }
        }
        return petType;
    }

    private static Pet createPet(Scanner scanner, String petType) {
        System.out.print("Great you selected " + petType);
        System.out.println(".Please enter pet's name in next line");
        String petName = scanner.next();
        if (petType.equalsIgnoreCase(SUPPORTED_PET.DOG.toString())) 
	{
            return new Dog(petName);
        }

 // For now we only support Dog, additional pets can be created by extending pet class with there own implementation of play actions.
 
return new Pet(petName) {
            @Override
            public void performAction(PetActions petActions)
{

// Add actions here of a default pet;
		switch (petActions) 
		{
                    case PLAY:
                        System.out.println(petName + " is playing");
                        this.setPetEnergyLevel(PetEnergyLevel.SLEEPY);
                        break;
                    case SLEEP:
                        System.out.println(petName + " is sleeping ZZZ");
                        this.setPetEnergyLevel(PetEnergyLevel.ENERGETIC);
                        break;
                }
            }
        };
}
    

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String petType = initiateDialogAndGetInput(scanner);
        Pet pet = createPet(scanner, petType);
        System.out.println(pet.toString());
        List<PetActions> petActions = pet.presentActions();
        for (PetActions actions : petActions) 
	{
            pet.performAction(actions);
        }
        System.out.println("Current energy level "  + pet.getPetEnergyLevel());
        scanner.close();
	}
}
