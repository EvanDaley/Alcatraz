import java.io.*;
import java.util.Scanner;

public class Room
{
   private int id;
   private String name;
   private String description;
   private int y;
   private int x;
   private int[] adjId;
   private Room[] adj;
   private boolean visited;
   //private Event event;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Room() {}//id defaults to 0. Bug potential?

   public static Room[] initRooms(File fin) throws FileNotFoundException
   {
      Room[] map = null;
      Room r = null;
      String[] adjRead;
      Scanner sc = new Scanner(new FileInputStream(fin), "UTF-8");
      
      sc.nextLine();//Prime read //BUGGED? WITHOUT PRIME READ, SCANNER CRASHES TRYING TO READ NEXTINT
      
      int skipRows = sc.nextInt();
      sc.nextLine();//Skip x & y line
      
      for(int i = 0; i < skipRows; i++)
         sc.nextLine();
      
      map = new Room[sc.nextInt()];//Get number of rooms
      sc.nextLine();//Skip starting room
      sc.nextLine();
      
      for(int i = 0; i < map.length; i++)
      {
         sc.nextLine();
         r = new Room();
         
         r.id = sc.nextInt();
         sc.nextLine();
         r.name = sc.nextLine();
         r.description = sc.nextLine();
         r.y = sc.nextInt();
         r.x = sc.nextInt();
         sc.nextLine();
         adjRead = sc.nextLine().split(" ");
         r.adjId = new int[adjRead.length];
         r.adj = new Room[r.adjId.length];
         
         for(int j = 0; j < adjRead.length; j++)
            r.adjId[j] = Integer.parseInt(adjRead[j]);
         
         map[i] = r;
      }
      
      for(int i = 0; i < map.length; i++)
      {
         for(int j = 0; j < map[i].adjId.length; j++)
         {
            map[i].adj[j] = map[map[i].adjId[j]];
         }
      }
      
      sc.close();
      
      return map;
   }//end initMap()
   
   public static int locateStart(File fin) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new FileInputStream(fin), "UTF-8");
      
      sc.nextLine();//Prime read
      
      int skipRows = sc.nextInt();
      sc.nextLine();//Skip x & y line
      
      for(int i = 0; i < skipRows; i++)
         sc.nextLine();
      
      sc.nextLine(); //Skip number of rooms
      
      return sc.nextInt();//Return starting room
   }

//GETS & SETS----------------------------------------------------------------------------

   public Room[] getAdj() {return this.adj;}
   public int getX() {return this.x;}
   public int getY() {return this.y;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public static void enter(Party p)
   {
      Room loc = p.getLocation();
      
      System.out.println(loc.name);
      
      if(loc.visited == false)
      {
         System.out.println(loc.description);
         loc.visited = true;
      }
   }
   
   public static boolean move(Party p)
   {
      boolean validSelect = false;
      Scanner kb = new Scanner(System.in);
      int select = -1;
      Room r = p.getLocation();
      
      System.out.print("Where to move?\r\n");
      
      do
      {
         for(int i = 0; i < r.adj.length; i++)
         {
            System.out.printf("%d) " + r.adj[i].name + "\r\n", i + 1);
         }
         System.out.printf("Or enter '0' to quit: ");
         
         select = kb.nextInt() - 1;
         kb.nextLine();
         
         if(select >= -1 && select < r.adj.length)
         {
            if(select == -1)
               return false;
            
            validSelect = true;
            p.setLocation(r.adj[select]);
         }
         else
            System.out.print("Invalid selection. Try again: ");
      }while(!validSelect);
      
      return true;
   }
   
}//end Room