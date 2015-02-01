import java.io.*;

public class TEST
{
   public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
   {
      Party party = null;
      boolean go = true;
      Room[] rooms = null;
      Map map = null;
      
      File fin = new File("corvette.txt");
      
      map = Map.initMap(fin);
      
      rooms = Room.initRooms(fin);
      
      party = new Party(rooms, 3);
      
      do
      {
         map.display(party); //Draw map to screen
         
         Room.enter(party); //Print room name. Check if visited; if not, print description of room.
         
         //Room.event(party); //event is a public method that calls each room object's assigned Event. Events can generate random or non-random encounters for the party, such as ambushes, item finds, bosses, obstacles, or scripted events.
         
         go = Room.move(party);
         
      }while(go);
      
      System.out.println("Quittin'...");

   }//end main()
}

//Just saving some section headers to copy+paste here:
//CONSTRUCTORS---------------------------------------------------------------------------



//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

