public class Item
{
   private String name; //Identify this item by name.
   private String description; //Flavor text that describes the item to the player would be useful.

//CONSTRUCTORS---------------------------------------------------------------------------

   private Item() {}//Hidden default constructor

   public Item(String n, String desc)
   {
      this.name = n;
      this.description = desc;
   }

//GETS & SETS----------------------------------------------------------------------------

//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public abstract void equip(PC owner)
   {
      //The PC equips this item.
      //Each item must recognize which PC 'slot' it belongs to to override this method.
   }
}

