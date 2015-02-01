import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Map
{
   private char[][] layout;
   private char[][] starfield;
   private char[][] display;
   private int x;//x/columns of ship layout  /*  map[y][x]  */
   private int y;//y/rows of ship layout

//CONSTRUCTORS---------------------------------------------------------------------------

   private Map()
   {
      this.layout = null;
      this.starfield = null;
      this.display = null;
      this.x = 0;
      this.y = 0;
   }

   public static Map initMap(File fin) throws FileNotFoundException
   {
      Map nm = new Map();
      Scanner sc = new Scanner(new FileInputStream(fin), "UTF-8");
      sc.nextLine();//Prime read
      
      nm.y = sc.nextInt();//Read number of y elements
      nm.x = sc.nextInt();//Read number of x elements
      sc.nextLine();
      
      nm.layout = new char[nm.y][nm.x];
      nm.starfield = new char[nm.y+2][nm.x+2];
      nm.display = new char[nm.y+2][nm.x+2];
      
      sc.useDelimiter("");
      
      //Copy char map from file, by x(column) then y(row)
      for(int i = 0; i < nm.y; i++)
      {
         for(int j = 0; j < nm.x; j++)
         {
            nm.layout[i][j] = sc.next().charAt(0);
         }
         sc.nextLine();
      }
      
      sc.close();
      
      for(int i = 0; i < nm.x+2; i++)
         nm.panStarfield();
      
      return nm;
   }//initMap()

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void panStarfield()
   {
      Random rnd = new Random();
      int r;
      int x = this.starfield[0].length - 1;
      
      for(int i = 0; i < this.starfield.length; i++)
      {
         for(int j = 0; j < this.starfield[i].length - 1; j++)
            this.starfield[i][j] = this.starfield[i][j + 1];
         
         r = rnd.nextInt(101);
         
         if(r < 86)
            this.starfield[i][x] = '\0';//empty space
         else if(r > 85 && r < 97)
            this.starfield[i][x] = '.';//small star
         else if(r > 96 && r < 100)
            this.starfield[i][x] = '*';//nova
         else
            this.starfield[i][x] = 'o';//planetoid
      }
   }//end panStarfield()
   
   public void display(Party p)
   {
      int px = p.getLocation().getX();
      int py = p.getLocation().getY();
      
      this.panStarfield();
      
      //Draw starfield
      for(int i = 0; i < this.y+2; i++)
      {
         for(int j = 0; j < this.x+2; j++)
            this.display[i][j] = this.starfield[i][j];
      }
      
      //Draw ship
      for(int i = 0; i < this.y; i++)
      {
         for(int j = 0; j < this.x; j++)
         {
            if(this.layout[i][j] != '\u0020')
               this.display[i+1][j+1] = this.layout[i][j];
         }
      }
      
      //Draw party
      this.display[py+1][px+1] = 'P';
      
      System.out.println("");//Formatting
      
      //Draw to console
      for(int i = 0; i < this.y+2; i++)
      {
         for(int j = 0; j < this.x+2; j++)
            System.out.print(this.display[i][j]);
         
         System.out.println("");
      }
      
      System.out.println("");//Formatting
   }
}