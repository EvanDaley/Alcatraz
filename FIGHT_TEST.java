import java.io.*;

public class FIGHT_TEST
{
   public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
   {
      Party party = null;
      boolean go = true;
      Room[] rooms = null;
      Map map = null;
      Enemy[] enemies = null;
      Combat combat;
      
      File fin = new File("corvette.txt");
      
      map = Map.initMap(fin); //Initialize display map & components
      
      rooms = Room.initRooms(fin); //Initialize rooms
      
      party = Party.test_createParty(4); //[DEV:TEST]Create party of 4 PCs. This is a testing method.
      party.setLocation(rooms[Room.locateStart(fin)]); //Set initial party location
      
      do
      {
         map.display(party); //Draw map to screen
         
         Room.enter(party); //Print room name. Check if visited; if not, print description of room.
         
         enemies = Enemy.test_createEnemies(party); //[DEV:TEST] Create party of enemies. This is a testing method.
         
         combat = new Combat(party, enemies); //Initialize a combat encounter object.
         
         go = combat.fight(party, enemies); //Make fight.
         
         if(go == true)
            go = Room.move(party); //Display and selection options for next movement.
         
      }while(go);
      
      System.out.println("Quittin'...");

   }//end main()
}

//Just saving some section headers to copy+paste here:
//CONSTRUCTORS---------------------------------------------------------------------------



//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

