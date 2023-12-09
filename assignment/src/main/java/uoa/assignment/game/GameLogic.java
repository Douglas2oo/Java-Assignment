package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

    public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
        if (!input.equals("up") && !input.equals("down") && !input.equals("left") && !input.equals("right")
                && !input.equals("")) {
            System.out.println("Use only keywords up, down, left, right");// if input is not a valid keyword
        } else {
            switch (input) {
                case "up":
                    moveUp(character, gameMap);
                    break;
                case "down":
                    moveDown(character, gameMap);
                    break;
                case "left":
                    moveLeft(character, gameMap);
                    break;
                case "right":
                    moveRight(character, gameMap);
                    break;
            }
            // make the specific movement if the input is a valid keyword
        }

    }

    private static void moveRight(GameCharacter character, Map gameMap) {
        // if the character is not at the right edge of the map and the character is player
        if (character.column < gameMap.layout[0].length - 1 && gameMap.layout[character.row][character.column] == "*") {
            // if the player is moving to an empty space
            if (gameMap.layout[character.row][character.column + 1] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.column++;// increment the column of the player
                gameMap.layout[character.row][character.column] = "*";// set the new position to the player
            } 
            // if the player is moving to a dead monster
            else if (gameMap.layout[character.row][character.column + 1] == "x") {
                System.out.println("Character already dead");
            } 
            // if the player is moving to a live monster
            else {
                // if the monster is monster1
                if (gameMap.monster1.row == character.row && gameMap.monster1.column == character.column + 1) {
                    int current = gameMap.monster1.getHealth();//get the current health of monster1
                    character.hurtCharacter(gameMap.monster1);// hurt monster1
                    int newh = gameMap.monster1.getHealth();//get the new health of monster1
                    //if the player successfully attacked monster1
                    if (current > newh) {
                        System.out.println("!!HIT!! Player successfully attacked Monster1");
                     } else {
                        System.out.println("!!MISS!! Monster1 successfully defended attack from Player");
                    }
                    // if monster1 is dead
                    if (gameMap.monster1.getHealth() <= 0) {
                        // set the position of monster1 to x(dead monster)
                        gameMap.layout[gameMap.monster1.row][gameMap.monster1.column] = "x";
                    }
                }
                // if the monster is monster2 
                else if (gameMap.monster2.row == character.row && gameMap.monster2.column == character.column + 1) {
                    int current = gameMap.monster2.getHealth();//get the current health of monster2
                    character.hurtCharacter(gameMap.monster2);// hurt monster2
                    int newh = gameMap.monster2.getHealth();//get the new health of monster2
                    //if the player successfully attacked monster2
                    if (current > newh) {
                        System.out.println("!!HIT!! Player successfully attacked Monster2");
                    } 
                    //if the monster successfully defended itself
                    else {
                        System.out.println("!!MISS!! Monster2 successfully defended attack from Player");
                    }
                    // if monster2 is dead
                    if (gameMap.monster2.getHealth() <= 0) {
                        // set the position of monster2 to x(dead monster)
                        gameMap.layout[gameMap.monster2.row][gameMap.monster2.column] = "x";
                    }
                } 
                // if the monster is monster3
                else if (gameMap.monster3.row == character.row && gameMap.monster3.column == character.column + 1) {
                     int current = gameMap.monster3.getHealth();//get the current health of monster3
                    character.hurtCharacter(gameMap.monster3);// hurt monster3
                    int newh = gameMap.monster3.getHealth();//get the new health of monster3
                    //if the player successfully attacked monster3
                    if (current > newh) {
                        System.out.println("!!HIT!! Player successfully attacked Monster3");
                    } 
                    //if the monster successfully defended itself
                    else {
                        System.out.println("!!MISS!! Monster3 successfully defended attack from Player");
                    }
                    // if monster3 is dead
                    if (gameMap.monster3.getHealth() <= 0) {
                        // set the position of monster3 to x(dead monster)
                        gameMap.layout[gameMap.monster3.row][gameMap.monster3.column] = "x";
                    }
                }
            }
        }
        // if the character is not at the right edge of the map and the character is monster 
        else if (character.column < gameMap.layout[0].length - 1
                && gameMap.layout[character.row][character.column] == "%") {
            // if the monster is moving to an empty space
            if (gameMap.layout[character.row][character.column + 1] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.column++;// increment the column of the monster
                gameMap.layout[character.row][character.column] = "%";// set the new position to the monster
            } 
            // if the monster is moving to a monster
            else if (gameMap.layout[character.row][character.column + 1] == "%" ) {
                System.out.println("Monster already there so can't move");
            } 
            // if the monster is moving to a player
            else if (gameMap.layout[character.row][character.column + 1] == "*") {
                int current = gameMap.player.getHealth();//get the current health of the player
                character.hurtCharacter(gameMap.player);// hurt the player
                int newh = gameMap.player.getHealth();//get the new health of the player
                if (current > newh) {
                    System.out.println("!!HIT!!"+character.name+" successfully attacked Player");
                } else {
                    System.out.println("!!MISS!! Player successfully defended attack from "+character.name);
                }
            }
        }
        // if the character is at the right edge of the map 
        else {
            System.out.println("You can't go right. You lose a move.");
        }
    }

    private static void moveLeft(GameCharacter character, Map gameMap) {
        // if the character is not at the left edge of the map and the character is player
        if (character.column > 0 && gameMap.layout[character.row][character.column] == "*") {
            // if the player is moving to an empty space
            if (gameMap.layout[character.row][character.column - 1] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.column--;// decrement the column of the player
                gameMap.layout[character.row][character.column] = "*";// set the new position to the player
            }
            // if the player is moving to a dead monster 
            else if (gameMap.layout[character.row][character.column - 1] == "x") {
                System.out.println("Character already dead");
            }
            // if the player is moving to a live monster
            else {
                // if the monster is monster1
                if (gameMap.monster1.row == character.row && gameMap.monster1.column == character.column - 1) {
                    character.hurtCharacter(gameMap.monster1);// hurt monster1
                    // if monster1 is dead
                    if (gameMap.monster1.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster1.row][gameMap.monster1.column] = "x";// set the position of monster1 to x(dead monster)
                    }
                } 
                // if the monster is monster2
                else if (gameMap.monster2.row == character.row && gameMap.monster2.column == character.column - 1) {
                    character.hurtCharacter(gameMap.monster2);// hurt monster2
                    // if monster2 is dead
                    if (gameMap.monster2.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster2.row][gameMap.monster2.column] = "x";// set the position of monster2 to x(dead monster)
                    }
                } 
                // if the monster is monster3
                else if (gameMap.monster3.row == character.row && gameMap.monster3.column == character.column - 1) {
                    character.hurtCharacter(gameMap.monster3);// hurt monster3
                    // if monster3 is dead
                    if (gameMap.monster3.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster3.row][gameMap.monster3.column] = "x";// set the position of monster3 to x(dead monster)
                    }
                }

            }

        } 
        // if the character is not at the left edge of the map and the character is monster
        else if (character.column > 0 && gameMap.layout[character.row][character.column] == "%") {
            // if the monster is moving to an empty space
            if (gameMap.layout[character.row][character.column - 1] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.column--;// decrement the column of the monster
                gameMap.layout[character.row][character.column] = "%";// set the new position to the monster
            } 
            // if the monster is moving to a monster
            else if (gameMap.layout[character.row][character.column - 1] == "%" ) {
                System.out.println("Monster already there so can't move");
            } 
            // if the monster is moving to a player
            else if (gameMap.layout[character.row][character.column - 1] == "*") {
                character.hurtCharacter(gameMap.player);// hurt the player
            } 
        } 
        // if the character is at the left edge of the map
        else {
            System.out.println("You can't go left. You lose a move.");
        }
    }

    private static void moveUp(GameCharacter character, Map gameMap) {
        // if the character is not at the top edge of the map and the character is player
        if (character.row > 0 && gameMap.layout[character.row][character.column] == "*") {
            // if the player is moving to an empty space
            if (gameMap.layout[character.row - 1][character.column] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.row--;// decrement the row of the player
                gameMap.layout[character.row][character.column] = "*";// set the new position to the player
            } 
            // if the player is moving to a dead monster
            else if (gameMap.layout[character.row - 1][character.column] == "x") {
                System.out.println("Character already dead");
            }
            // if the player is moving to a live monster
            else {
                // if the monster is monster1
                if (gameMap.monster1.row == character.row - 1 && gameMap.monster1.column == character.column) {
                    character.hurtCharacter(gameMap.monster1);// hurt monster1
                    // if monster1 is dead
                    if (gameMap.monster1.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster1.row][gameMap.monster1.column] = "x";// set the position of monster1 to x(dead monster)
                    }
                } 
                // if the monster is monster2
                else if (gameMap.monster2.row == character.row - 1 && gameMap.monster2.column == character.column) {
                    character.hurtCharacter(gameMap.monster2);// hurt monster2
                    // if monster2 is dead
                    if (gameMap.monster2.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster2.row][gameMap.monster2.column] = "x";// set the position of monster2 to x(dead monster)
                    }
                } 
                // if the monster is monster3
                else if (gameMap.monster3.row == character.row - 1 && gameMap.monster3.column == character.column) {
                    character.hurtCharacter(gameMap.monster3);// hurt monster3
                    // if monster3 is dead
                    if (gameMap.monster3.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster3.row][gameMap.monster3.column] = "x";// set the position of monster3 to x(dead monster)
                    }
                }
            }
        } 
        // if the character is not at the top edge of the map and the character is monster
        else if (character.row > 0 && gameMap.layout[character.row][character.column] == "%") {
            // if the monster is moving to an empty space
            if (gameMap.layout[character.row - 1][character.column] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.row--;// decrement the row of the monster
                gameMap.layout[character.row][character.column] = "%";// set the new position to the monster
            } 
            // if the monster is moving to a monster
            else if (gameMap.layout[character.row - 1][character.column] == "%" ) {
                System.out.println("Monster already there so can't move");
            } 
            // if the monster is moving to a player
            else if (gameMap.layout[character.row][character.column] == "*" ) {
                character.hurtCharacter(gameMap.player);// hurt the player
            }

        } 
        // if the character is at the top edge of the map
        else {
            System.out.println("You can't go up. You lose a move.");
        }
    }

    private static void moveDown(GameCharacter character, Map gameMap) {
        // if the character is not at the bottom edge of the map and the character is player
        if (character.row < gameMap.layout.length - 1 && gameMap.layout[character.row][character.column] == "*") {
            // if the player is moving to an empty space
            if (gameMap.layout[character.row + 1][character.column] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.row++;// increment the row of the player
                gameMap.layout[character.row][character.column] = "*";// set the new position to the player
            } 
            // if the player is moving to a dead monster
            else if (gameMap.layout[character.row + 1][character.column] == "x") {
                System.out.println("Character already dead");
            }
            // if the player is moving to a live monster
            else {
                // if the monster is monster1
                if (gameMap.monster1.row == character.row + 1 && gameMap.monster1.column == character.column) {
                    character.hurtCharacter(gameMap.monster1);// hurt monster1
                    // if monster1 is dead
                    if (gameMap.monster1.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster1.row][gameMap.monster1.column] = "x";// set the position of monster1 to x(dead monster)
                    }
                } 
                // if the monster is monster2
                else if (gameMap.monster2.row == character.row + 1 && gameMap.monster2.column == character.column) {
                    character.hurtCharacter(gameMap.monster2);// hurt monster2
                    // if monster2 is dead
                    if (gameMap.monster2.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster2.row][gameMap.monster2.column] = "x";// set the position of monster2 to x(dead monster)
                    }
                } 
                // if the monster is monster3
                else if (gameMap.monster3.row == character.row + 1 && gameMap.monster3.column == character.column) {
                    character.hurtCharacter(gameMap.monster3);// hurt monster3
                    // if monster3 is dead
                    if (gameMap.monster3.getHealth() <= 0) {
                        gameMap.layout[gameMap.monster3.row][gameMap.monster3.column] = "x";// set the position of monster3 to x(dead monster)
                    }
                }
            }
        }
        // if the character is not at the bottom edge of the map and the character is monster 
        else if (character.row < gameMap.layout.length - 1
                && gameMap.layout[character.row][character.column] == "%") {
            // if the monster is moving to an empty space
            if (gameMap.layout[character.row + 1][character.column] == ".") {
                gameMap.layout[character.row][character.column] = ".";// set the current position to empty
                character.row++;// increment the row of the monster
                gameMap.layout[character.row][character.column] = "%";// set the new position to the monster
            } 
            // if the monster is moving to an alive monster
            else if (gameMap.layout[character.row + 1][character.column] == "%") {
                System.out.println("Monster already there so can't move");
            } 
            // if the monster is moving to a player
            else if (gameMap.layout[character.row + 1][character.column] == "*") {
                character.hurtCharacter(gameMap.player);// hurt the player
            }

        } 
        // if the character is at the bottom edge of the map
        else {
            System.out.println("You can't go down. You lose a move.");
        }

    }
}