package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

   public String[][] layout;//initialise the layout of the map
   public Player player;//initialise the player
   public Monster monster1;
   public Monster monster2;
   public Monster monster3;//initialise the monsters
   public GameCharacter[] characters;//initialise the array of characters

   Map(int height, int width) {

      layout = new String[height][width];//create the layout
      characters = new GameCharacter[4];//create the array of characters

      player = new Player("Player");
      monster1 = new Monster("Monster1");
      monster2 = new Monster("Monster2");
      monster3 = new Monster("Monster3");
      //create the characters

      characters[0] = player;
      characters[1] = monster1;
      characters[2] = monster2;
      characters[3] = monster3;
      //set the characters in the array

      characters[0].row = height - 1;
      characters[0].column = width - 1;
      characters[1].row = 0;
      characters[1].column = width - 1;
      characters[2].row = height - 1;
      characters[2].column = 0;
      characters[3].row = 0;
      characters[3].column = 0;
      //set the position of the characters

      initialiseArray();
      //initialise the layout

      layout[height - 1][width - 1] = "*";
      layout[0][0] = "%";
      layout[0][width - 1] = "%";
      layout[height - 1][0] = "%";
      //set the position of the characters in the layout
      

   }

   public void initialiseArray() {
      for (int i = 0; i < layout.length; i++) {
         for (int j = 0; j < layout[i].length; j++) {
            layout[i][j] = ".";
         }
      }
   }
   //initialise the layout



   public void printLayout() {
      for (int i = 0; i < layout.length; i++) {
         for (int j = 0; j < layout[i].length; j++) {
            System.out.print(layout[i][j]);
         }
         System.out.println();
      }
   }//print the layout
}
