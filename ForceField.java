import java.util.Observer;
import java.util.Observable;

public class ForceField extends Item implements Observer
{
   private int rechargeTime;//Amount of time needed to recharge. Less time is better.
   private int timer;//Set to 0 when force field discharges. Ticks upward with update()s from combatTimer.
   private boolean charged;
   private Observable obs;
   
//CONSTRUCTORS---------------------------------------------------------------------------
   
   public ForceField(int level)
   {
	  super("Force Field", "lives as an invisible Layer around Host protecting it from Damage\n");
	  this.rechargeTime = 1000 - (200 * level);
      this.timer = 0;
      this.charged = true;
      this.obs = null;
   }

//GETS & SETS----------------------------------------------------------------------------

   public void reset()
   {
      this.timer = 0;      
   }

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void update(Observable obs, Object arg)
   {
      Combat combat = (Combat)obs;      
      timer++;
   }   
   public void equip(PC owner)
   {
      owner.setFF(this);
   }
   
   public int DefendWith(int damage, int accuracy)
	{
	   if(charged)
	      {
	         charged = false;
	         timer = 0;
	         System.out.print("BONK\n");
	         System.out.println("ForceField blocked all damage\n");	         
	         return 0;
	      }
	      else
	    	  return damage;         
	}

}
