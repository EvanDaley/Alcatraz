public class Weapon extends Item
{
   private int damage; //Base damage caused by a hit. Countered by armor, which reduces incoming damage.
   //private int armorPiercing; <--[DEV]Maybe
   private int speed; //Determines how often attacks can be made with this weapon. Indirectly countered by force fields, which recharge.
   private int accuracy; //Base chance to hit. Countered by implants, which reduce chance to hit.
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private Weapon() {} //Hidden default constructor
   
   public Weapon(String name, String desc, int dam, int spd, int acc)
   {
      super(name, desc);
      this.damage = dam;
      this.spd = spd;
      this.acc = acc;
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

   //May need an attack() method if we decided to give different behaviors to different weapons (targeting restrictions, splash damage, etc.). For now, we only need call the target's defend() method and pass this weapon's properties as parameters.

}