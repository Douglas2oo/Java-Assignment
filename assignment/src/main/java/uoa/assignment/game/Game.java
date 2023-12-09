package uoa.assignment.game;

import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Game {

    public Map map;
    public Player player;

    Game(int height, int width) {
        map = new Map(height, width);
        player = new Player("Player");// create player
        map.player = player;// set player
        getMap().printLayout();// print the layout
        map.monster1 = new Monster("Monster1");
        map.monster2 = new Monster("Monster2");
        map.monster3 = new Monster("Monster3");// create monsters

        map.characters[0] = player;// set player in the array
        map.characters[1] = map.monster1;
        map.characters[2] = map.monster2;
        map.characters[3] = map.monster3;// set monsters in the array

        player.row = height - 1;
        player.column = width - 1;
        map.monster1.row = 0;
        map.monster1.column = width - 1;
        map.monster2.row = height - 1;
        map.monster2.column = 0;
        map.monster3.row = 0;
        map.monster3.column = 0;// set the position of the player and the monsters

        getMap().layout[height - 1][width - 1] = "*";
        getMap().layout[0][0] = "%";
        getMap().layout[0][width - 1] = "%";
        getMap().layout[height - 1][0] = "%";// set the position of the player and the monsters in the layout
    }

    public Map getMap() {
        return map;// return the current map
    }

    public boolean nextRound(String input) {

        GameLogic.moveCharacter(input, getMap(), getMap().player);// move the player

        System.out.println("Player is moving " + input);// print the player's movement selection

        if (getMap().monster1.getHealth() > 0) {
            String monsterMove1 = getMap().monster1.decideMove();// randomly select a movement for the monster
            System.out.println("Monster1 is moving " + monsterMove1);// print the monster's movement selection
            GameLogic.moveCharacter(monsterMove1, getMap(), getMap().monster1);// move the monster
        }
        if (getMap().monster2.getHealth() > 0) {
            String monsterMove2 = getMap().monster2.decideMove();// randomly select a movement for the monster
            System.out.println("Monster2 is moving " + monsterMove2);// print the monster's movement selection
            GameLogic.moveCharacter(monsterMove2, getMap(), getMap().monster2);// move the monster
        }
        if (getMap().monster3.getHealth() > 0) {
            String monsterMove3 = getMap().monster3.decideMove();// randomly select a movement for the monster
            System.out.println("Monster3 is moving " + monsterMove3);// print the monster's movement selection
            GameLogic.moveCharacter(monsterMove3, getMap(), getMap().monster3);// move the monster
        }
        // move the monsters if they are alive
        System.out.println("");
        System.out.println("Health Player: " + getMap().player.getHealth());
        System.out.println("Health Monster1: " + getMap().monster1.getHealth());
        System.out.println("Health Monster2: " + getMap().monster2.getHealth());
        System.out.println("Health Monster3: " + getMap().monster3.getHealth());
        // print the health of the player and the monsters

        if (getMap().monster1.getHealth() <= 0 && getMap().monster2.getHealth() <= 0
                && getMap().monster3.getHealth() <= 0) {
            System.out.println("YOU HAVE WON!");// if all the monsters are dead, the player wins
        } else if (getMap().player.getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");// if the player is dead, the player loses
        }

        System.out.println("");
        getMap().printLayout();// print the layout

        if (RunGame.gameOver == true) {
            return false;
        } else {
            return true;
        }
        // return true if the game is not over, return false if the game is over
    }
}
