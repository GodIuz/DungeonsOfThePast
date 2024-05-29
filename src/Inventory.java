import java.io.*;
import java.util.ArrayList;

public class Inventory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    static ArrayList<Item> items = null;
    private final String name = "";

    public Inventory() {
        items = new ArrayList<>();
    }

    public static void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + "has been added to your inventory.");
    }

    public void removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                System.out.println(item.getName() + " has been removed from your inventory.");
            }
        }
        System.out.println("Item not found in inventory.");
    }

    public static void listItems() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in your inventory:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public static void saveToFile(Player player, String filename)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Save player's position and current room
            writer.write("Position:" + player.getPosition());
            writer.newLine();
            writer.write("Room:" + player.getCurrentRoom() + Rooms.getName() + ";" + Rooms.getDescription());
            writer.newLine();
            writer.write("Inventory" +  player.getInventory() );

            // Save inventory items
            for (Item item : items) {
                writer.write(item.getName() + ";" + item.getDescription());
                writer.newLine();
            }
            System.out.println("Inventory and player data saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void loadFromFile(Player player, String filename) {
        items.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Read player's position
            if ((line = reader.readLine()) != null && line.startsWith("Position:")) {
                player.setPosition(Integer.parseInt(line.substring(9)));
            }

            // Read player's current room
            if ((line = reader.readLine()) != null && line.startsWith("Room:")) {
                String[] roomData = line.substring(5).split(";", 2);
                if (roomData.length == 2) {
                    player.setCurrentRoom(new Rooms(roomData[0], roomData[1]));
                }
            }

            // Read inventory items
            while ((line = reader.readLine()) != null) {
                String[] itemData = line.split(";", 2);
                if (itemData.length == 2) {
                    addItem(new Item());
                }
            }
            System.out.println("Inventory and player data loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Item searchItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return file.delete();
        } else {
            System.out.println("File does not exist.");
            return false;
        }
    }
}