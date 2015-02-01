public class Character
{
   private int hp; //Hit Points
   private Defense defense;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Character() {};
   
   public Character(int hitPoints)
   {
      this.hp = hitPoints;
   }
   
//GETS & SETS----------------------------------------------------------------------------

   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend(int damage, int acc)
   {
      defense.defend(this, damage, acc);
   }
}
