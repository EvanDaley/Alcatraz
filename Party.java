class Party
{
   private Room location;
   private PC[] party;
   private int size;

//CONSTRUCTORS---------------------------------------------------------------------------

   private Party()
   {
      this.location = null;
      this.party = null;
      this.size = 0;
   }//Hidden default constructor
   
   public static Party test_createParty(int partySize)
   {
      Party newParty = new Party();
      
      newParty.party = PC.test_createPC_Party(partySize);
      
      newParty.size = partySize;
      
      return newParty;
   }
   
//GETS & SETS----------------------------------------------------------------------------

   public Room getLocation() {return this.location;}
   public void setLocation(Room r) {this.location = r;}
   public PC[] getPartyMembers() {return this.party;}
   public int size() {return this.size;}
   
//CLASS-LEVEL METHODS--------------------------------------------------------------------

   public void restore()
   {
      for(int i = 0; i < this.size; i++)
         party[i].restore();
   }
}
