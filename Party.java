class Party
{
   private Room location;
   private PC[] party;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Party() {}//Hidden default constructor
   
   public Party(Room[] rooms, int r)//[DEV] Can't instantiate party until map has been initialized
   {
      this.location = rooms[r];
   }
   
//GETS & SETS----------------------------------------------------------------------------

   public Room getLocation() {return this.location;}
   public void setLocation(Room r) {this.location = r;}
   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

}
