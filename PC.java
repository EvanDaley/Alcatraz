public class PC extends Character
{
   private Weapon primary; //Each PC may equip one primary weapon. Weapon stats are passed to an attack()-type method.
   //private Accessory acc; //Each PC may equip one accessory (medkit, drone, motion detector, decoy, shield... just ideas). A use()-type method may grant this character more options in combat.
   private ForceField ff; //Each PC may equip one force field. Force fields discharge and cancel one incoming attack. Must recharge between uses. Must subscribe to the observable combatTimer to recharge.
   //private Armor armor; //Each PC may equip one suit of armor. Armor reduces incoming damage.
   //private Implant implant; //Each PC may equip one implant. Implants grant a chance to evade incoming attacks.
   private Defense defense; //Defense is decorated like so: Implant >> ForceField >> Armor >> Defense. Each has a defend() method. If decorator Defense laers are breached, Defense.defend() is called and the PC takes damage.
   //private Behavior special; <--[DEV]Maybe add special/unique abilities for each class later
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private PC() {super("", -1);} //Hidden private constructor

   public PC(String n, int hp)
   {
      super(n, hp);
         //name from super()
         //hp from super()
         //defense from super()
      this.primary = null;
      this.ff = null;
   }
   
   public static PC[] test_createPC_Party(int partySize)
   {
      PC[] party = new PC[partySize];
      String[] names = {"Grant", "Helena", "Bob", "Luce", "DeFoe", "Barbarella"};
      
      for(int i = 0; i < party.length; i++)
      {
         party[i] = new PC(names[i], 100);
         party[i].setWeapon(new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
         party[i].defense = new Defense();
      }
      
      return party;
   }

//GETS & SETS----------------------------------------------------------------------------

   public Weapon getWeapon() {return this.primary;}
   public void setWeapon(Weapon w) {this.primary = w;}
   public ForceField getFF() {return this.ff;}
   public void setFF(ForceField frcFld) {this.ff = frcFld;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

}