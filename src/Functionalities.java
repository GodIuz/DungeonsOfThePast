import java.util.*;

public class Functionalities {
    static double playerHealth = 100;
    static double bossHealth = 800;
    static double zombieHealth = 50;
    static  double zombieAttack = 5;
    static double playerAttack = 10;
    private static String position;
    protected static final Room currentRoom = Room.START;
    private final HashMap<String, Room> rooms = new HashMap<>();
    private static final String name="";
    private static final String description="";


    public static void quit() {
        System.out.println("Are you sure you want to quit ?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (Objects.equals(s, "yes")) {
            System.out.println("Thanks for playing our game!");
            System.out.println("See you next time");
            System.exit(0);
        }
    }

    public static String go(String str) {
        if (Objects.equals(str, "go north")) {
            position = "north";
            System.out.println("You go north");
            getPosition();
        } else if (Objects.equals(str, "go south")) {
            position = "south";
            System.out.println("You go south");
            getPosition();
        } else if (Objects.equals(str, "go west")) {
            position = "west";
            System.out.println("You go west");
            getPosition();
        } else if (Objects.equals(str, "go east")) {
            position = "east";
            System.out.println("You go east");
            getPosition();
        } else if (Objects.equals(str, "go southeast")) {
            position = "southeast";
            System.out.println("You go southeast");
            getPosition();
        } else if (Objects.equals(str, "go southwest")) {
            position = "southwest";
            System.out.println("You go southwest");
            getPosition();
        } else if (Objects.equals(str, "go northwest")) {
            position = "northwest";
            System.out.println("You go northwest");
            getPosition();
        } else if (Objects.equals(str, "go northeast"))
        {
            position = "northeast";
            System.out.println("You go northeast");
            getPosition();
        }
        else {
            System.out.println("Check your compass and try again");
        }
        return position;
    }

    public static String look(String direction) {
       Rooms currentRoom = new Rooms(name,description);

        // Check for valid direction
        if (!Rooms.isValidDirection(direction)) {
            return "You can't go that way.";
        }

        // Get the exit description for the specified direction
        String description = currentRoom.getExitDescription(direction);

        // If there's no exit, indicate it
        if (description == null) {
            return "There is no exit in that direction.";
        }

        return description;
    }

    public static void attackEnemy() {
        double playerHealth = getPlayerHealth();
        double zombieHealth1 = getZombieHealth();
        do {
                zombieHealth1 = zombieHealth1 - playerAttack;
                playerHealth = playerAttack - zombieAttack;
                setPlayerHealth(playerHealth);
                setZombieHealth(zombieHealth1);
                System.out.println("Zombie hp :" +zombieHealth1);
                System.out.println("Your hp" + playerHealth);

        }while (zombieHealth1 == 0 || playerHealth == 0);
        Player player = new Player();
        if(!Player.isPlayerAlive(player))
        {
            System.out.println("You died . Try again");
            Inventory.deleteFile("save.txt");
        }

    }

    public static void setZombieHealth(double zombieHealth) {
        Functionalities.zombieHealth = zombieHealth;
    }

    private static double getZombieHealth() {
        return zombieHealth;
    }

    public static void setPlayerHealth(double playerHealth) {
        Functionalities.playerHealth = playerHealth;
    }

    public static double getPlayerAttack() {
        return playerAttack;
    }

    public static void setPlayerAttack(double playerAttack) {
        Functionalities.playerAttack = playerAttack;
    }

    public static double getPlayerHealth() {
        return playerHealth;
    }

    public static void enter() {
        Random random = new Random();
        Player player = new Player();
        position = setPosition();
        player.getInventory().listItems();
        if (currentRoom == Room.START) {
            String itemNameToSearch = "Key";
            Item foundItem = player.getInventory().searchItem(itemNameToSearch);
            if (foundItem != null) {
                System.out.println("You go to second room.");
            } else {
                System.out.println("Search for the key.");
            }
        } else if (currentRoom == Room.SECOND_ROOM)
        {
            String itemNameToSearch = "Key";
            Item foundItem = player.getInventory().searchItem(itemNameToSearch);
            if (foundItem != null) {
                System.out.println("You go to third room.");
            } else {
                System.out.println("Search for the key.");
            }
        } else if (currentRoom == Room.THIRD_ROOM) {
            String itemNameToSearch = "Key";
            Item foundItem = player.getInventory().searchItem(itemNameToSearch);
            if (foundItem != null) {
                System.out.println("You go to fourth room.");
            } else {
                System.out.println("Search for the key.");
            }
        } else if (currentRoom == Room.FOURTH_ROOM) {
            String itemNameToSearch = "Key";
            Item foundItem = player.getInventory().searchItem(itemNameToSearch);
            if (foundItem != null) {
                System.out.println("You go to the last room.");
            } else {
                System.out.println("Search for the key.");
            }
        }else {
            System.out.println("Boss appeared.");
            System.out.println("Fight start.");
        }

    }

    public static String setPosition() {
        Functionalities.position = position;
        return position;
    }

    public static String getPosition() {
        return position;
    }

    public static String spawnPosition(Random random) {

        String[] position = {"north", "south", "west", "east", "northeast", "northwest", "southeast", "southwest"};

        int randomPosition = random.nextInt(position.length);

        String spawnPosition = String.valueOf(randomPosition);
        return spawnPosition;
    }

    public static String spawnItem(Random random) {

        String[] item ={"potion","sword","key","shield"};

        int randomItem = random.nextInt(item.length);
        String spawnItem = String.valueOf(randomItem);
        return spawnItem;
    }

    public static void attackBoss(Player player, Boss boss) {
        int playerAttack = player.getAttackDamage(); // Example: get attack stat from Player object

        // Check if player is alive (replace with your logic)
        if (!Player.isPlayerAlive(player)){
            System.out.println("You can't attack, you are defeated!");
            return;
        }

        // Reduce Boss health
        boss.takeDamage(playerAttack);

        // Display attack information
        System.out.println("You attack the Boss for " + playerAttack + " damage!");
        System.out.println("Boss health remaining: " + boss.getHealth());

    }

    public void spawnText() {
        Random random = new Random();
        String text = spawnPosition(random);
        System.out.println("It appears "+ text+".");
    }

    public static String spawnEnemy(Random random) {
        String[] enemy = {"zombie","boomer","tank","witch"};
        int randomEnemy = random.nextInt(enemy.length);
        String spawnEnemy = String.valueOf(randomEnemy);
        return spawnEnemy;
    }

    public void spawnEnemyText() {
        Random random = new Random();
        String enemy = spawnEnemy(random);
        System.out.println("A"+enemy+"appears. Be ready to fight.");
    }

    public double getBossHealth() {
        return bossHealth;
    }

    public void setBossHealth(double bossHealth) {
        Functionalities.bossHealth = bossHealth;
    }

    public static void playerAttackBoss(Player player, Boss boss) {

        // Check if player is alive (replace with your logic)
        if (!player.isPlayerAlive(player)) {
            System.out.println("You can't attack, you are defeated!");
            return;
        }

        // Calculate player attack damage (replace with your logic)
        int playerAttack = player.calculateAttackDamage(player); // Delegate to Player class for attack logic


        // Reduce Boss health
        boss.takeDamage(playerAttack);

        // Check for Boss defeat
        if (boss.getHealth() <= 0) {
            System.out.println("Congratulations! You defeated the Boss!");
        }
    }

}
