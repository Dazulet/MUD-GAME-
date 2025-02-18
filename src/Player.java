import java.util.ArrayList;
import java.util.List;

class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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
            System.out.println("you got this item" + inventory);
        }
        else {
            System.out.println("Here, no item to take.");
        }
    }

    public void showInventory() {
        System.out.println("INVENTORY:");
        if (inventory != null) {
            for (Item item : inventory) {
                System.out.print("[" + item.getItemName() + "] ");
            }
            System.out.println();
        } else {
            System.out.println("No items in inventory.");
        }
    }
}
