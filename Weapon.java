public class Weapon extends Item
{
   private int damage; //Base damage caused by a hit. Countered by armor, which reduces incoming damage.
   //private int armorPiercing; <--[DEV]Maybe
   private int speed; //Determines how often attacks can be made with this weapon. Indirectly countered by force fields, which recharge.
   private int accuracy; //Base chance to hit. Countered by implants, which reduce chance to hit.
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private Weapon() {super("", "");} //Hidden default constructor
   
   public Weapon(String name, String desc, int dam, int spd, int acc)
   {
      super(name, desc);
      this.damage = dam;
      this.speed = spd;
      this.accuracy = acc;
   }

//GETS & SETS----------------------------------------------------------------------------

   public int getSpeed() {return this.speed;}
   public void setSpeed(int speed) {this.speed = speed;}
   public int getDamage() {return this.damage;}
   public void setDamage(int damage) {this.damage = damage;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void equip(PC owner)
   {
      owner.setWeapon(this);
   }

   public static void attack(Weapon w, Character target)
   {
      target.getDef().defend(target, w.damage, w.accuracy);
   }
}