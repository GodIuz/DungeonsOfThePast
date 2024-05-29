import java.io.Serial;
import java.io.Serializable;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Inventory inventory;
    private int position;
    private Rooms currentRoom;
    private int health;
    private int attackDamage;


    public Player() {
        inventory = new Inventory();
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Rooms getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Rooms currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static boolean isPlayerAlive(Player player) {
        return player.getHealth() > 0;
    }

    public static int calculateAttackDamage(Player player) {
        // Replace with your logic for calculating attack damage
        int baseAttack = player.getAttackDamage(); ; // Example: get attack bonus from equipment
        return baseAttack;
    }

    public static void displayDamage(int damage) {
        System.out.println("You attack for " + damage + " damage!");
    }

    public static void handleBossDamage(Boss boss, int damage) {
        boss.takeDamage(damage); // Assumes takeDamage exists in Boss class
        if (boss.getHealth() <= 0) {
            System.out.println("Congratulations! You defeated the Boss!");
        }
    }

    public void attack(Boss boss) {
        System.out.println("Player attacks Boss for " + attackDamage + " damage.");
        boss.takeDamage(attackDamage);
    }
}
