import java.util.Observable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Combat extends Observable
{
   private int timeElapsed; //Measure time 
   private ArrayList<Character> actionQueue;
   
//CONSTRUCTORS---------------------------------------------------------------------------

   private Combat() {}//Hidden default constructor
   
   public Combat(Party party, Enemy[] enemies)
   {
      this.timeElapsed = 0;
      this.actionQueue = new ArrayList<Character>(party.size() + enemies.length);
   }

//GETS & SETS----------------------------------------------------------------------------



//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public boolean fight(Party party, Enemy[] enemies)
   {
      Random rnd = new Random();
      Character actor, target;
      int i, j;
      int ps = party.size();
      int es = enemies.length;
      int partyDefeat = 0;
      int enemyDefeat = 0;
      
      //Display the fight to console
      System.out.print("An ambush! ");
      
      for(i = 0; i < enemies.length; i++)
      {
         System.out.print(enemies[i].getName() + ", ");
      }
      
      System.out.print(" attack!\r\n\r\n");
      
      //Populate the Action Queue. Initial delay times are randomized.
      for(i = 0; i < party.size(); i++)
      {
         actor = party.getPartyMembers()[i];
         actor.setDelay(rnd.nextInt(20));
         actionQueue.add(actor);
      }
      
      for(j = 0; i < party.size() + enemies.length; i++, j++)
      {
         actor = enemies[j];
         actor.setDelay(rnd.nextInt(20));
         actionQueue.add(actor);
      }
      
      actionQueue.trimToSize();
      Collections.sort(actionQueue);
      
      //Main fighting loop
      while(partyDefeat < ps && enemyDefeat < es)
      {
         actor = actionQueue.remove(0);
         
         timeElapsed = actor.getDelay();
         
         //Modify action delay times
         for(i = 0; i < actionQueue.size(); i++)
            actionQueue.get(i).modDelay(timeElapsed);
         
         //If the next character to act is a PC, target a random enemy to attack. If the next character is an enemy, target random PC.
         //This method might lag if, for instance, there are 6 defeated enemies in a 7-enemy party. Consider revision.
         do
         {
            if(actor instanceof PC)
               target = enemies[rnd.nextInt(es)];
            else
               target = party.getPartyMembers()[rnd.nextInt(ps)];
         }while(target.defeated());
         
         //Attack
         System.out.print(actor.getName() + " ");
         Weapon.attack(actor.getWeapon(), target);
         actor.setDelay(actor.getWeapon().getSpeed());
         actionQueue.add(actor);
            
         if(target.defeated())
         {
            System.out.print(target.getName() + " is defeated!\r\n");
            actionQueue.remove(target);
            
            if(target instanceof PC)
               partyDefeat++;
            else
               enemyDefeat++;
         }
         
         Collections.sort(actionQueue);
      }
      
      if(partyDefeat == ps)
      {
         System.out.print("U ded.\r\n\r\n");
         return false;
      }
      else
      {
         party.restore();
         System.out.print("Sweet victory!\r\n\r\n");
         return true;
      }
   }

   public void tick()
   {
      setChanged();
      notifyObservers();
   }

}
