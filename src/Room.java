public class Room {
    private String roomName;
    private String DescrioptionRoom;
    private Room forward;
    private Room back;
    private Room left;
    private Room right;
    private Item item;
    public Room(String roomName, String DescrioptionRoom) {
        this.roomName = roomName;
        this.DescrioptionRoom = DescrioptionRoom;
    }

    public void setConnections(Room forward, Room back, Room left, Room right) {
        this.forward = forward;
        this.back = back;
        this.left = left;
        this.right = right;
    }
    public Room getConnections(String direction) {
        if (forward == null && back == null && left == null && right == null) {
            if (direction.equals("forward")) {
                return forward;
            }
            else if (direction.equals("back")) {
                return back;
            }
            else if (direction.equals("left")) {
                return left;
            }
            else if (direction.equals("right")) {
                return right;
            }
            else {
                return null;
            }
        }
        else {
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
        if(item.getItemName() != null) {
            return "in this room("+roomName+") "+" there is = " + "Item("+item.getItemName()+")";
        }
        else {
            return "in this room("+roomName+")" + " dont have any item";
        }
    }

}
