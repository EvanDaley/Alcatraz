import java.util.Random;

class WeaponFactory
{  
   //Create a default weapon based on weaponType
   public static Weapon getWeapon(String weaponType)
   {
      Weapon weapon = null;
      if ( weaponType.equals("Knife") )   //instead of creating a weapon the next line should create a knife subclass
         weapon = new Weapon("Knife", "A sharp item", 25, 15, 15);
      else if ( weaponType.equals("Crowbar") )
         weapon = new Weapon("Crowbar", "A long heavy bar with a hook", 45, 35, 15);
      else if ( weaponType.equals("Sword") )
         weapon = new Weapon("Sword", "A glimmering blade", 25, 15, 15);
      else if ( weaponType.equals("Gun") )
         weapon = new Weapon("Gun", "Throw pieces of molten ore at your adversaries", 25, 15, 15);
      else if ( weaponType.equals("Blaster") )
         weapon = new Weapon("Blaster", "Throw molten plasma at your adversaries", 25, 15, 15);
      else if ( weaponType.equals("Rocket") )
         weapon = new Weapon("Rocket", "Throw pieces of molten ore at your adversaries", 25, 15, 15);
      
      if(weapon == null)
      {
         System.out.println("Weapon factory didn't recognize weaponType parameter");
         weapon = new Weapon(weaponType, "No description available", 25, 15, 15);
      }
      
      return weapon;
   }

   //Creates a default weapon and then modifies damage and speed based on level
   public static Weapon getWeapon(String weaponType, int weaponLevel)
   {
      Weapon weapon = getWeapon(weaponType);
      Random rand = new Random();
      
      //Modify damage based on weaponLevel 
      int randomNum = rand.nextInt(weaponLevel*10);   
      int dmg = weapon.getDamage() + randomNum;         
      weapon.setDamage(dmg);
      
      //Modify speed based on weaponLevel 
      randomNum = rand.nextInt(weaponLevel) + 2;
      int spd = weapon.getSpeed();
      spd = (spd / randomNum) + (spd / 2);      //decrease the time it takes to swing by up to half
      
      if(spd < 15)
         spd = 15;
      
      weapon.setSpeed(spd);
      
      return weapon;
   }
}