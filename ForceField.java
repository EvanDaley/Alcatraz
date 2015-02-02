import java.util.Observer;
import java.util.Observable;

public class ForceField implements Observer
{
   private int rechargeTime;//Amount of time needed to recharge. Less time is better.
   private int timer;//Set to 0 when force field discharges. Ticks upward with update()s from combatTimer.
   private boolean charged;
   private Observable obs;
   private DefenseDecorator defRef;
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private ForceField() {}//Hidden constructor
   
   public ForceField(int chargeTime, int time)//Enables the construction of custom force fields for testing. Otherise, use a sub-class constructor.
   {
      this.rechargeTime = 1000;
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
   
   public void defend(Character target, int damage, int accuracy)
   {
      if(charged)
      {
         charged = false;
         timer = 0;
         System.out.print("BONK");
      }
      else
         defRef.defend(target, damage, accuracy);
         
   }
   
   public void equip(PC owner)
   {
      owner.setFF(this);
   }//This base defense layer is not explicitly equip()ed.

}