 class Player {
    private String playerName;
    private int playerCoin;
    private Room currentRoom;
    private Item inventory;

     public Player(Room startRoom) {
         this.currentRoom = startRoom;
     }

     public Room getCurrentRoom() {
         return currentRoom;
     }

     public void moveTo(Room newRoom) {
         this.currentRoom = newRoom;
     }

     public void TakeItem() {
         if(currentRoom.getItem() != null) {
             inventory = currentRoom.getItem();
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
             System.out.println(inventory);
         }
         else {
             System.out.println("There is nothing in the inventory");
         }
     }

}
