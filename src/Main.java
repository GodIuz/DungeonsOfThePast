import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String str ="";
    static String position="";
    static String enemyPosition="";
    static String itemPosition="";
    static int health;
    static int attackDamage;

    public static void main(String[] args) {
        Random random = new Random();
        Player player = new Player();
        Item item = new Item();
        Boss boss = new Boss(health,attackDamage);
        System.out.print("Welcome to Dungeons of Past. You entered an old dungeon.\nYou want to explore it but be careful of beings inside of the dungeon.");
        System.out.println("\nYou heard stories of people that entered this dungeon and never come back ");
        do
        {

            System.out.println(">>");
            Scanner scanner = new Scanner(System.in);
            str =scanner.nextLine();
            enemyPosition = Functionalities.spawnPosition(random);
            itemPosition = Functionalities.spawnPosition(random);
            position = Functionalities.go(str);
           switch (str) {
               case "go north", "go south", "go west", "go east", "go northwest", "go northeast", "go southeast",
                    "go southwest":
                   position = Functionalities.go(str);
                   if (Objects.equals(position, enemyPosition)) {
                       Functionalities.attackEnemy();
                   }
                   if(Functionalities.currentRoom == Room.END){
                       System.out.println("Boss appears.");
                       Functionalities.attackBoss(player,boss);
                   }
                   break;
               case "look":
                   itemPosition = Functionalities.spawnPosition(random);
                   Functionalities.spawnItem(random);
                   if(Objects.equals(position, itemPosition)) {
                       String direction = str;
                       Functionalities.look(direction);
                   }else{
                       System.out.println("Nothing to look here.");
                   }
                   break;
               case "enter":
                   String it3ms = "Key";
                   if(it3ms.contains((CharSequence) Inventory.items)) {
                       Functionalities.enter();
                   }else {
                       System.out.println("You need to find a key to exit a room.");
                   }
                   break;
               case "save":
                   Inventory.saveToFile(player, "save.txt");
                   break;
               case "hello", "hi":
                   String str = "Hello !";
                   System.out.println(str);
                   break;
               case "restore":
                   Player loadedPlayer = new Player();
                   loadedPlayer.getInventory().loadFromFile(loadedPlayer, "inventory.txt");
                   System.out.println("Loaded player data:");
                   System.out.println("Position: " + loadedPlayer.getPosition());
                   System.out.println("Current Room: " + loadedPlayer.getCurrentRoom());
                   loadedPlayer.getInventory().listItems();
                   break;
               case "pick up":
                   if (Objects.equals(position, itemPosition))
                   {
                       Inventory.addItem(item);
                   }
               case "quit":
                   Functionalities.quit();
                   break;
               default:
               System.out.println("Try again !!");
           }

        }while(!Objects.equals(str, "quit"));

    }
}