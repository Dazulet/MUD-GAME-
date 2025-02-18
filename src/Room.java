public class Room {
    private String roomName;
    private String descriptionRoom;  // Исправлено на descriptionRoom
    private Room forward;
    private Room back;
    private Room left;
    private Room right;
    private Item item;

    public Room(String roomName, String descriptionRoom) {
        this.roomName = roomName;
        this.descriptionRoom = descriptionRoom;
    }

    public void setConnections(Room forward, Room back, Room left, Room right) {
        this.forward = forward;
        this.back = back;
        this.left = left;
        this.right = right;
    }

    public Room getConnections(String direction) {
        if (direction.equals("forward")) {
            return forward;
        } else if (direction.equals("back")) {
            return back;
        } else if (direction.equals("left")) {
            return left;
        } else if (direction.equals("right")) {
            return right;
        } else {
            return null;
        }
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void removeItem() {
        this.item = null;
    }

    public String describe() {
        if (item != null && item.getItemName() != null) {
            return "In this room (" + roomName + ") there is: Item(" + item.getItemName() + ")";
        } else {
            return "In this room (" + roomName + ") there is no item.";
        }
    }
}
