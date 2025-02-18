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
                        System.out.println("Welcome to MUD Game.Enter Text:");
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
               if (t1.equalsIgnoreCase("move")){
                       move(t2);
               }
               else if (t1.equalsIgnoreCase("look")){
                       player.getCurrentRoom().describe();
               }
               else if (t1.equalsIgnoreCase("exit")){
                       running = false;
               }
               else if (t1.equalsIgnoreCase("pick")){
                       player.TakeItem();
               }
               else if (t1.equalsIgnoreCase("inventory")){
                       player.showInventory();
               }
               else if (t1.equalsIgnoreCase("help")){
                       showHelp();
               }
                }


        private void lookAround() {
        }


        private void move(String go) {
                Room room = player.getCurrentRoom().getConnections(go);
                if (room != null) {
                        player.moveTo(room);
                        System.out.println("Moved => " + room.describe());
                }
                else {
                        System.out.println("Room not found");
                }
        }


        private void pickUp(String arg) {
                if (arg.equals("")) {
                        System.out.println("Can not pick up empty room");
                        System.out.println("you should specify what do you want to pick up");
                        return;
                }

                Item item = player.getCurrentRoom().getItem();
                if (item != null && item.getItemName().equalsIgnoreCase(arg)) {
                        player.TakeItem();
                } else {
                        System.out.println("here is not a valid item");
                }
        }

        private void checkInventory() {
                player.showInventory();
        }

        private void showHelp() {
                System.out.println("look = Describe the room");
                System.out.println("move (forward|back|left|right) = Move in the specified direction");
                System.out.println("pick = take item");
                System.out.println("inventory = Show inventory");
                System.out.println("help = Show help");
                System.out.println("exit = Exit the game");
        }
        }




