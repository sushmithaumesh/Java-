
package  pet.categories;

import pet.Pet;
import pet.PetActions;
import pet.attributes.PetEnergyLevel;

//Dog represents a type of Pet with its own play specific methods.
 //It is a child class of @see Pet
 
public class Dog extends Pet {

    public Dog( String petName) 
    {
        super(petName);
    }

    @Override
    public void performAction(PetActions petActions) 
{
        switch (petActions) 
	{
            case PLAY:
                System.out.println("Woof Woof Woof ");
                this.setPetEnergyLevel(PetEnergyLevel.SLEEPY);
                break;
            case SLEEP:
                System.out.println("ZZZZZZZZ");
                this.setPetEnergyLevel(PetEnergyLevel.ENERGETIC);
                break;
        }
}

    @Override
    public String toString() 
    {
        return super.toString() + "Pet type:" + this.getClass().getSimpleName();
    }

}
