import java.util.Random;

public abstract class Enemy extends Character
{
   private Weapon primary; //Can use pre-coded weapons, or custom weapons via the Weapons class constructor.
   private ForceField ff; //Each PC may equip one force field. Force fields discharge and cancel one incoming attack. Must recharge between uses. Must subscribe to the observable combatTimer to recharge.
   private Armor armor; //Each PC may equip one suit of armor. Armor reduces incoming damage.
   private Implant implant;
   

//CONSTRUCTORS---------------------------------------------------------------------------

   private Enemy() {super("", -1);} //Hidden default constructor
   
   public Enemy(String n, int hitPoints, Weapon w)
   {
      super(n, hitPoints);
      this.primary = w;
      this.ff = new ForceField(0);
      this.armor = new Armor(0);
      this.implant = new Implant(0);
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
   public ForceField getFF() {return this.ff;}
   public Armor getArmor(){return this.armor;}
   public Implant getImp(){return this.implant;}

//CLASS-LEVEL METHODS--------------------------------------------------------------------
   public void defend(int damage, int acc) {
	    int Health = super.getCurHp();
		System.out.printf("Current Enemies Health %d\n",Health);
		Health = Health - damage;
		super.setCurHp(Health);
		System.out.printf("Enemies HP after hit %d\n",super.getCurHp());
	    if(super.getCurHp() < 1)
	        super.setDef(true);
		return;
	}

}
