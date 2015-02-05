/*
   Team: Drop Table
   Evan Daley
   Michael Parkes
   Phillip Gort
*/

import java.util.Observable;

public class CombatTimer extends Observable{
   private int time;
   private int deltaTime;

   public CombatTimer(){}

   public int getChange()
   {
      return deltaTime;
   }

   public void setTime(int time)
   {
      deltaTime = time - this.time;
      this.time = time;
      valuesChanged();
   }
   
   public void subtractTime(int delta)
   {
      deltaTime = -delta;
      this.time = time - delta;
      valuesChanged();
   }
   
   public void addTime(int delta)
   {
      deltaTime = delta;
      this.time = time + delta;
      valuesChanged();
   }
   
   public void valuesChanged(){
      setChanged();
      notifyObservers();
   }
   
}