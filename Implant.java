import java.util.Random;

public class Implant extends DefenseDecorator
{
   private int evade;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Implant() {super("", "", null);}//Hiden default
   
   public Implant(String desc, String n, int e, Defense def)
   {
      super(desc, n, def);
      this.evade = e;
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend(Character target, int damage, int accuracy)
   {
      Random rnd = new Random();
      int i = rnd.nextInt(100);//Returns 0 to 99
      int hitRange = accuracy - this.evade;
      
      if(i < hitRange)
         defRef.defend(target, damage, accuracy);
      else
         System.out.print("MISS ");
   }
}
