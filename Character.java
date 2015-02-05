import java.util.Observable;
import java.util.Observer;

public abstract class Character implements Comparable<Character>, Observer
{
   private String name;
   private int maxHp; //Maximum Hit Points
   private int curHp; //Current Hit Points
   private Defense defense;
   private int actionDelay;
   private boolean defeated;
   Observable combatTimer;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Character() {};
   
   public Character(String n, int hitPoints)
   {
      this.name = n;
      this.maxHp = hitPoints;
      this.curHp = hitPoints;
      defense = new Defense();
      this.actionDelay = 0;
      this.defeated = false;
   }
   
//GETS & SETS----------------------------------------------------------------------------

   public String getName() {return this.name;}
   public Defense getDef() {return this.defense;}
   public int getDelay() {return this.actionDelay;}
   public void setDelay(int delay) {this.actionDelay = delay;}
   public void modDelay(int mod) {this.actionDelay -= mod;}
   public abstract Weapon getWeapon();
   public boolean defeated() {return this.defeated;}
   public void subscribeToTimer(Observable timer){timer.addObserver(this); combatTimer = timer;}
   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend(int damage, int acc)
   {
      defense.defend(this, damage, acc);
   }
   
   public void harm(int damage)
   {
      this.curHp -= damage;
      
      if(this.curHp < 1)
         this.defeated = true;
   }
   
   public void restore()
   {
      this.curHp = this.maxHp;
      this.actionDelay = 0;
      this.defeated = false;
   }
   
   public int compareTo(Character that)
   {
      return this.actionDelay - that.actionDelay;
   }
   
   public void update(Observable obs, Object args){
      if(obs instanceof CombatTimer){
         CombatTimer myTimer = (CombatTimer)obs;
         actionDelay -= myTimer.getChange();
      }
   }

}
