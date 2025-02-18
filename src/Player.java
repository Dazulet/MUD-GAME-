import java.util.ArrayList;
import java.util.List;

class Player {
    private String playerName;
    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(String playerName, Room currentRoom, List<Item> inventory) {
        this.playerName = playerName;


    }
     public Player(Room startRoom) {
         this.currentRoom = startRoom;
         this.inventory = new ArrayList<>();
     }

     public Room getCurrentRoom() {
         return currentRoom;
     }

     public void moveTo(Room newRoom) {
         this.currentRoom = newRoom;
     }

     public void TakeItem() {
         if(currentRoom.getItem() != null) {
             inventory.add(currentRoom.getItem());
             currentRoom.setItem(null);
             System.out.println("In this room player("+playerName+")"+" Taken! "+inventory);
         }
         else {
             System.out.println("here not to take any item");
         }
     }
     public void showInventory() {
         System.out.println("INVENTORY:");
         if (inventory != null) {
         for (Item item : inventory) {
                 System.out.print("["+item+"] ");
         }}
         else {
             System.out.println("here not to show inventory");
         }
     }
}
