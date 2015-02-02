import java.util.Random;

public abstract class Enemy extends Character
{
   private Weapon primary; //Can use pre-coded weapons, or custom weapons via the Weapons class constructor.

//CONSTRUCTORS---------------------------------------------------------------------------

   private Enemy() {super("", -1);} //Hidden default constructor
   
   public Enemy(String n, int hitPoints, Weapon w)
   {
      super(n, hitPoints);
      this.primary = w;
   }
   
   public static Enemy[] test_createEnemies(Party party)//Create an enemy party, minimum 1 enemy. May be as large as 150% PC party size.
   {
      Random rnd = new Random();
      int size = party.size();
      
      if(size > 1)
         size = size + (size / 2) + (size % 2);
      else
         size = 2;
      
      size = rnd.nextInt(size) + 1;
      
      Enemy[] enemies = new Enemy[size];
      
      for(int i = 0; i < enemies.length; i++)
      {
         enemies[i] = new Thug(i+1);
      }
      
      return enemies;
   }

//GETS & SETS----------------------------------------------------------------------------

   public Weapon getWeapon() {return this.primary;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

}