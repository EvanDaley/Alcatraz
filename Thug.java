public class Thug extends Enemy
{
   //Currently no data fields
   
//CONSTRUCTORS---------------------------------------------------------------------------

   public Thug()
   {
      super("Thug", 50, new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
   }
   
   public Thug(int num)
   {
      super("Thug " + num, 50, new Weapon("Unarmed", "Empty-handed", 10, 50, 95));
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

}
