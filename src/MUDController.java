import java.util.Scanner;

public class MUDController {

        private final Player player;
        private boolean running;

        public MUDController(Player player) {
                this.player = player;
                this.running = true;
        }

        public void runGameLoop() {
                Scanner in = new Scanner(System.in);
                while (running) {
                        System.out.println("Welcome to MUD Game. Enter Text(if you dont know something you can write HELP ):");
                        String text = in.nextLine();
                        handleInput(text);
                }
        }

        public void handleInput(String input) {
                String t1 = input;
                String t2 = "";

                int spaceIndex = input.indexOf(" ");
                if (spaceIndex != -1) {
                        t1 = input.substring(0, spaceIndex);
                        t2 = input.substring(spaceIndex + 1);
                }

                switch (t1.toLowerCase()) {
                        case "move":
                                move(t2);
                                break;
                        case "look":
                                lookAround();
                                break;
                        case "exit":
                                running = false;
                                break;
                        case "pick":
                                pickUp(t2);
                                break;
                        case "inventory":
                                checkInventory();
                                break;
                        case "help":
                                showHelp();
                                break;
                        default:
                                System.out.println("you really stupid because i show you commands list.Maybe you write help and try again another commands.");
                }
        }

        private void move(String direction) {
                Room current = player.getCurrentRoom();
                if (current == null) {
                        System.out.println("Error: Current room is null.");
                        return;
                }

                Room nextRoom = current.getConnections(direction);
                if (nextRoom != null) {
                        player.moveTo(nextRoom);
                        System.out.println("Moved to: " + nextRoom.describe());
                } else {
                        System.out.println("Room not found in that direction.");
                }
        }

        private void checkInventory() {
                player.showInventory();
        }

        private void pickUp(String arg) {
                if (arg.isEmpty()) {
                        System.out.println("Please specify an item to pick up.");
                        return;
                }

                Item item = player.getCurrentRoom().getItem();
                if (item != null && item.getItemName().equalsIgnoreCase(arg)) {
                        player.TakeItem();
                } else {
                        System.out.println("No such item in this room.");
                }
        }

        private void lookAround() {
                Room currentRoom = player.getCurrentRoom();
                if (currentRoom != null) {
                        System.out.println(currentRoom.describe());
                } else {
                        System.out.println("You are in an unknown place...");
                }
        }

        private void showHelp() {
                System.out.println("look => Describe the room");
                System.out.println("move (forward|back|left|right) => Move in the specified direction");
                System.out.println("pick (item name) => Pick up the specified item");
                System.out.println("inventory => Show inventory");
                System.out.println("help => Show help");
                System.out.println("exit => Exit the game");
        }
}
