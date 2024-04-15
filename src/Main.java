import java.util.Objects;
import java.util.Scanner;

public class Main {
    static String str ="";
    static String position="";
    static String enemyPosition="";

    public static void main(String[] args) {
        System.out.print("Welcome to Dungeons of Past. You entered an old dungeon.\nYou want to explore it but be careful of beings inside of the dungeon.");
        System.out.println("\nYou heard stories of people that entered this dungeon and never come back ");
        do
        {
            System.out.println(">>");
            Scanner scanner = new Scanner(System.in);
            str =scanner.nextLine();
            enemyPosition = Functionalities.spawnEnemy();
            position = Functionalities.go(str);
            if(Objects.equals(enemyPosition,position))
            {
                System.out.println("A zombie appears. It is coming to you.");
                Functionalities.attackEnemy();
            }
        }while(!Objects.equals(str, "quit"));
        if(Objects.equals(str,"quit"))
        {
            Functionalities.quit();
        }
    }
}