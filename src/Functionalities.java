import java.util.*;

public class Functionalities {
    static double playerHealth = 100;
    static double bossHealth = 800;
    static double zombieHealth = 50;
    static  double zombieAttack = 5;
    static double playerAttack = 10;
    private static String position;


    // static String closeWord = "quit";

    public static String hello() {
        String string = "Hello";
        return string;
    }

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

        String position = "";
        int countString = countWords(str).size();
        String route = null;
        if (countString == 1) {
            System.out.println("Where do you want to go");
            Scanner scanner = new Scanner(System.in);
            route = scanner.nextLine();
            if (Objects.equals(route, "north")) {
                System.out.println("You go north");
                position = "north";
                getPosition();
                return position;
            } else if (Objects.equals(route, "south")) {
                System.out.println("You go south");
                position = "south";
                getPosition();
                return position;
            } else if (Objects.equals(route, "west")) {
                System.out.println("You go west");
                position = "west";
                getPosition();
                return position;
            } else if (Objects.equals(route, "east")) {
                System.out.println("You go east");
                position = "east";
                getPosition();
                return position;
            } else if (Objects.equals(route, "northeast")) {
                System.out.println("You go northeast");
                position = "northeast";
                getPosition();
                return position;
            } else if (Objects.equals(route, "northwest")) {
                System.out.println("You go northwest");
                position = "northwest";
                getPosition();
                return position;
            } else if (Objects.equals(route, "southeast")) {
                System.out.println("You go southeast");
                position = "southeast";
                getPosition();
                return position;
            } else if (Objects.equals(route, "southwest")) {
                System.out.println("You go southwest");
                position = "southwest";
                getPosition();
                return position;
            } else {
                System.out.println("Pardon me ?");
                position = "0";
                getPosition();
                return position;
            }
        } else if (countString == 2) {
            if (Objects.equals(route, "go north")) {
                position = "north";
                System.out.println("You go north");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go south")) {
                position = "south";
                System.out.println("You go south");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go west")) {
                position = "west";
                System.out.println("You go west");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go east")) {
                position = "east";
                System.out.println("You go east");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go northeast")) {
                position = "northeast";
                System.out.println("You go northeast");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go southeast")) {
                position = "southeast";
                System.out.println("You go southeast");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go southwest")) {
                position = "southwest";
                System.out.println("You go southwest");
                getPosition();
                return position;
            } else if (Objects.equals(route, "go northwest")) {
                position = "northwest";
                System.out.println("You go northwest");
                getPosition();
                return position;
            }
        } else {
            System.out.println("Check your compass and try again");
        }
        return position;
    }

    public static Map<String, Integer> countWords(String input) {
        // Split the input string into words
        String[] words = input.split("\\s+");

        // Create a map to store the count of each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Count the occurrences of each word
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                // If the word is already in the map, increment its count
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                // If the word is not in the map, add it with a count of 1
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }

    public static void look() {

    }

    public static void attackEnemy() {
        double playerHealth = getPlayerHealth();
        double zombieHealth1 = getZombieHealth();
        List<InventoryItem> inventory = new ArrayList<>();
        do {
            if (inventory.isEmpty()) {
                zombieHealth1 = zombieHealth1 - playerAttack;
                playerHealth = playerAttack - zombieAttack;
                setPlayerHealth(playerHealth);
                setZombieHealth(zombieHealth1);
                System.out.println("Zombie hp :" +zombieHealth1);
                System.out.println("Your hp" + playerHealth);
            }
        }while (zombieHealth1 == 0 || playerHealth == 0);

        if(zombieHealth1 == 0)
        {
            inventory.add(new InventoryItem("Health Posion",1));
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

    public void setPosition(String position) {
        Functionalities.position = position;
    }

    public static String getPosition() {
        return position;
    }

    public static String spawnEnemy() {
        int minStep = 0;
        int maxStep = 8;
        String[] position = {"north", "south", "west", "east", "northeast", "northwest", "southeast", "southwest"};

        Random random = new Random();
        int randomStep = random.nextInt(maxStep - minStep + 1) + minStep;
        int randomPosition = random.nextInt(position.length);

        String positionX = String.valueOf((char) randomStep - 1);
        String positionY = String.valueOf(randomPosition);
        String enemyPosition = positionX + positionY;
        return enemyPosition;
    }

    public double getBossHealth() {
        return bossHealth;
    }

    public void setBossHealth(double bossHealth) {
        Functionalities.bossHealth = bossHealth;
    }
}
