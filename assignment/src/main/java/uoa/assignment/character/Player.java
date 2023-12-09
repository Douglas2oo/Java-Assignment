package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);//call the constructor of the superclass
	}

	public
	void hurtCharacter(GameCharacter character) {
        if (!character.successfulDefense()) {
			int currentHealth = character.getHealth() - 50;
            character.setHealth(currentHealth);
        }
	}//hurt the character

	public
	boolean successfulDefense() {
        Random rand = new Random();
        int possibility = rand.nextInt(10);
        if (possibility < 3) 
		    return true;
        else
            return false;
	}//determine whether the player can successfully defend itself

}