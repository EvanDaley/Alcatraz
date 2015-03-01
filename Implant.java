import java.util.Random;

public class Implant extends Item implements Defend
{
    private int evade;

//CONSTRUCTORS---------------------------------------------------------------------------
   
   public Implant(int e)
   {
	   super("Implant", "A Doo-Hicky in your Head that makes you dodge faster\n");
       this.evade = (e * 10);
   }

   public int DefendWith(int damage, int accuracy)
	{
	   Random rnd = new Random();
	      int i = rnd.nextInt(100);//Returns 0 to 99
	      int hitRange = accuracy - this.evade;
	      
	      if(i < hitRange) {
	    	  System.out.println("HIT\n");
	         return damage; }
	      else
	      {
	         System.out.print("MISS \n");
	         return 0;
	      }
	}

@Override
public void equip(PC owner) {
	
}

}
