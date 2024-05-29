public class Boss {
    private int health;
    private final int attackDamage;

    public Boss(int health, int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Boss takes " + damage + " damage and now has " + health + " health.");
        if (health <= 0) {
            System.out.println("Boss is defeated!");
        }
    }
}
