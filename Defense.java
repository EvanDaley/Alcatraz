public class Defense extends Item
{

//CONSTRUCTORS---------------------------------------------------------------------------

   public Defense()
   {
      super("DEF_BASE", "A non-removable defensive layer.");
   }
   
   public Defense(String n, String desc)
   {
      super(n, desc);
   }

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void defend(Character target, int damage, int accuracy)
   {
      System.out.print("hits " + target.getName() + " for " + damage + " damage.\r\n");
      target.harm(damage);
      //Use Character gets/sets to incur damage.
      //This method is overwritten in DefenseDecorator(s) ForceField, Armor, and Implant
   }
   
   public void equip(PC owner) {}//This base defense layer is not explicitly equip()ed.
}

