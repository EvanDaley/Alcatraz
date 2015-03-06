import java.util.Scanner;


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
      
      //newParty.party = PC.test_createPC_Party(partySize);
      
      newParty.size = partySize;
      
      return newParty;
   }
   public static Party CreateParty()
   {
	   Party newParty = new Party();
	   int NumofParty = 0;
	   Scanner kb = new Scanner(System.in);

	   while (NumofParty < 1)
	      {
	    	  System.out.println("Welcome Commander");
	    	  System.out.println("How many in your Crew? (we suggest atleast 3 and no more than 6)");
	    	  NumofParty = kb.nextInt();
	      }
	   newParty.party = PC.createPC_Party(NumofParty);
	   newParty.size = NumofParty;
	   kb.close();
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
