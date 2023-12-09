# Java-Assignment
DDL: 2023.12.10 Java Programming Assignment

## Introduction

The rules of the game are simple. The playing area is a 2D grid, with the player (you) starting in one
corner, and three monsters starting in the other three corners. At each round, you can move the
player one step up, down, left, or right. The monsters will also move one step randomly. If the player
tries to move to a location occupied by a monster, the player is attacking the monster. If the attack
is successful, the monster loses 50 health points. Respectively, if a monster tries to move to a location
occupied by the player, the monster is attacking the player. If the attack is successful, the player loses
20 health point.
>
In the beginning, the player and the monsters have 100 health points each. When the health score
reaches zero, the character dies. Your goal in the game is to kill the monsters before they kill you.
Figure 1 below illustrates the game.

<img width="320" alt="1702137512991" src="https://github.com/Douglas2oo/Java-Assignment/assets/119099260/c05ce98d-9df3-49a8-b97b-48152f87ea42">

## Test

Pass all tests in the test files
   
Run the following command in the 'assignment' directory
   ```console
   mvn clean test
   ```
And you will witness result like the following screenshot.

![image](https://github.com/Douglas2oo/Java-Assignment/assets/119099260/89e35820-bd92-4f61-8a51-7cf70aa9e481)

## Run Project

1. Gernerate a JAR file
   ```console
   mvn package
   ```
   
2. Run the project from the target folder with command:
   ```console
   java -jar assignment-1.0-SNAPSHOT.jar <your parameters>
   ```
   The parameters will include the height and the width of the game area.
   
3. Alternatively, you can also run the main method using Maven:
   ```console
   mvn compile exec:java -Dexec.mainClass="uoa.assignment.game.RunGame" -Dexec.args= "arg1 arg2"
   ```

