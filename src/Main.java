import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item sword = new Item("Sword");
        Item shield = new Item("Shield");
        Item potion = new Item("Potion");
        Item map = new Item("Map");
        Item key = new Item("Key");

        Room entrance = new Room("Entrance", "A dark entrance to the dungeon");
        Room hall = new Room("Hall", "A wide hall with torches on the walls");
        Room armory = new Room("Armory", "A room filled with ancient weapons");
        Room library = new Room("Library", "A dusty library with old books");
        Room treasureRoom = new Room("Treasure Room", "A room filled with glittering treasure");
        Room prison = new Room("Prison", "A cold, dark prison cell");
        Room hiddenPassage = new Room("Hidden Passage", "A secret passage behind a wall");


        entrance.setConnections(hall, null, null, null);
        hall.setConnections(armory, entrance, library, prison);
        armory.setConnections(treasureRoom, hall, null, null);
        library.setConnections(null, null, null, hall);
        prison.setConnections(null, null, hall, null);
        treasureRoom.setConnections(null, armory, hiddenPassage, null);
        hiddenPassage.setConnections(null, null, null, treasureRoom);


        entrance.setItem(map);
        hall.setItem(potion);
        armory.setItem(sword);
        library.setItem(key);
        treasureRoom.setItem(shield);

        Player player = new Player(entrance);
        MUDController controller = new MUDController(player);

        controller.runGameLoop();
    }
}
