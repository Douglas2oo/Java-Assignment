package uoa.assignment.character;

import uoa.assignment.character.GameCharacter;

import java.util.Random;

public class Monster extends GameCharacter {

	public Monster(String name) {
		super(name);// call the constructor of the superclass
	}

	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
			int currentHealth = character.getHealth() - 20;
			character.setHealth(currentHealth);
		}
	}// hurt the character

	public boolean successfulDefense() {
		Random rand = new Random();
		int possibility = rand.nextInt(2);
		if (possibility == 0)
			return false;
		else
			return true;
	}// determine whether the monster can successfully defend itself

	public String decideMove() {
		Random rand = new Random();
		int possibility = rand.nextInt(4);
		switch (possibility) {
			case 0:
				return "up";
			case 1:
				return "down";
			case 2:
				return "left";
			case 3:
				return "right";
			default:
				return "";
		}

	}// decide the move of the character
}
