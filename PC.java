import java.util.*;
public class PC extends Character
{
   private Weapon primary; //Each PC may equip one primary weapon. Weapon stats are passed to an attack()-type method.
   //private Accessory acc; //Each PC may equip one accessory (medkit, drone, motion detector, decoy, shield... just ideas). A use()-type method may grant this character more options in combat.
   private ForceField ff; //Each PC may equip one force field. Force fields discharge and cancel one incoming attack. Must recharge between uses. Must subscribe to the observable combatTimer to recharge.
   private Armor armor; //Each PC may equip one suit of armor. Armor reduces incoming damage.
   private Implant implant; //Each PC may equip one implant. Implants grant a chance to evade incoming attacks.
   //private Behavior special; <--[DEV]Maybe add special/unique abilities for each class later
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private PC() {super("", -1);} //Hidden private constructor

   public PC(String n, int hp)
   {
      super(n, hp);
      this.primary = null;
      this.ff = new ForceField(0);
      this.armor = new Armor(1);
      this.implant = new Implant(0);
   }
   
   public static PC[] createPC_Party(int partySize)
   {
      PC[] party = new PC[partySize];
      String[] names = new String[partySize];
      Scanner kb = new Scanner(System.in);
      String PlayerName=null;;
      
	  for(int x=0; x<partySize; x++)
	      {
	    	  System.out.printf("What shall we call Party Member #%d ",x+1);
	    	  PlayerName = kb.next();
	    	  names[x]=PlayerName;
	    	  PlayerName=null;
	      }
	      for(int i = 0; i < party.length; i++)
	      {
	         party[i] = new PC(names[i], 100);
	         party[i].setWeapon(new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
	      }
      kb.close();
      return party;
   }

//GETS & SETS----------------------------------------------------------------------------

   public Weapon getWeapon() {return this.primary;}
   public void setWeapon(Weapon w) {this.primary = w;}
   public ForceField getFF() {return this.ff;}
   public void setFF(ForceField frcFld) {this.ff = frcFld;}
   public Armor getArmor(){return this.armor;}
   public void setArmor(Armor Arm){this.armor = Arm;}
   public Implant getImp(){return this.implant;}
   public void setImp(Implant imp){this.implant = imp;}

public void defend(int damage, int acc) {
	System.out.printf("doing this much damage %d\n",damage);
	int DamageToOpponent = 0;
	DamageToOpponent = getFF().DefendWith(damage,acc);
	if(DamageToOpponent == 0)
		return;
	DamageToOpponent = getImp().DefendWith(damage, acc);
	if(DamageToOpponent == 0)
		return;
	DamageToOpponent = getArmor().DefendWith(damage,acc);
	
	int Health = super.getCurHp();
	System.out.printf("Current Players Health %d\n",Health);
	Health = Health - DamageToOpponent;
	super.setCurHp(Health);
	System.out.printf("new HP after hit %d\n",super.getCurHp());
	
    if(super.getCurHp() < 1)
        super.setDef(true);
	return;
}

//CLASS-LEVEL METHODS--------------------------------------------------------------------

}