package uoa.assignment.character;

public abstract class GameCharacter {
    
	public String name ="";//initial name is empty
	
	private int health=100; // initial health is 100
	
	public int row;
	public int column;//locate the coordinates of the character using row and column
	
	
	public GameCharacter (String name) {
		//complete
        this.name = name; //this.name is the name of the class, name is the parameter
	}
	
	public abstract void hurtCharacter (GameCharacter character); //define an abstract method
	
	public abstract boolean successfulDefense ();//define an abstract method
	
	
	public String sayName() {
	    return this.name; 
	}//get the name of the character

	public int getHealth() {
		return this.health;
	}//get the health of the character

	public void setHealth(int health) {
		//complete
        this.health = health;
	}//set the health of the character
}

