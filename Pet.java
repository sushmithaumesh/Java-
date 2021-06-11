
package pet;

import pet.attributes.PetEnergyLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


 // Pet represents super class. It contains some reusable methods.
// Child class that extends pet needs to implement all abstract methods of pet.

public abstract class Pet {


    private String petName;
    private PetEnergyLevel petEnergyLevel;

   
 // Creates a new instance of pet.
 // @param petName name of the pet.
 
    public Pet(String petName) 
	{
        this.petName = petName;
        this.petEnergyLevel = PetEnergyLevel.SLEEPY;
    }

   
 // Returns energy level of pet           
// @return @see PetEnergyLevels
 
    public PetEnergyLevel getPetEnergyLevel() 
  {
        return petEnergyLevel;
  }

    protected void setPetEnergyLevel(PetEnergyLevel petEnergyLevel) 
	{	
        this.petEnergyLevel = petEnergyLevel;
  	}	

    
 // Provides a bunch of options to the user that can be performed on Pet object with certain restrictions.FOr example sleepy pet cannot play.
 //@return list of pet actions.@see PetActions
 
    public List<PetActions> presentActions() 
	{
        final Scanner scanner = new Scanner(System.in);
        List<PetActions> petActions = new ArrayList<>();
        int option;
        String petName = this.getPetName();
        switch (this.getPetEnergyLevel()) {
            case ENERGETIC:
                System.out.println(petName + " is full of energy. Do you want to play with " + petName + "? ");
                System.out.println("Press \n1. Yes \n2. No");
                option = scanner.nextInt();
                if (option == 1) 
		{
                    petActions.add(PetActions.PLAY);
                }
                return petActions;
            case SLEEPY:
                System.out.println(this.getPetName() + " is tired. Do you want " + petName + " to sleep?");
                System.out.println("Press \n1. Yes \n2. No");
                option = scanner.nextInt();
                if (option == 1) 
		{
                    petActions.add(PetActions.SLEEP);
                } else {
                    System.out.println("Sorry " + petName + " is too tired to play. Putting her to sleep" +
                            " Come back in 1 min");
                    System.out.println(petName + " is full of energy now. " +
                            "Do you want to play with " + petName + "? Woof Woof");
                    System.out.println("Press \n1. Yes \n2. No");
                    option = scanner.nextInt();
                    if (option == 1) 
		    {
                        petActions.add(PetActions.PLAY);
                    } else {
                        petActions.add(PetActions.SLEEP);
                        this.setPetEnergyLevel(PetEnergyLevel.SLEEPY);
                        System.out.println("Okay bye bye");
                    }

                }
                return petActions;
            default:
                break;
        }
        scanner.close();
        return petActions;
    }

    private String getPetName() 
    {
        return petName;
    }

    // Abstract method that performs actions on pet.@param petActions pet actions
    // @see PetActions
 
    public abstract void performAction(PetActions petActions);

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Your pet info:\n");
        stringBuilder.append("Name:" + this.petName);
        stringBuilder.append("\nEnergy level:" + this.petEnergyLevel);
        return stringBuilder.toString();
    }
}
