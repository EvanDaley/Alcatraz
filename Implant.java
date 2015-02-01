public class Implant extends DefenseDecorator
{
   private int evade;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Implant() {}//Hiden default
   
   public Implant(String desc, String n, int e)
   {
      super(desc, n);
      this.evade = e;
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend()
   {
      Character target, int damage, int accuracy
   }
}
