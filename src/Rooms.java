import java.io.Serial;
import java.io.Serializable;

public class Rooms implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static  String name;
    private static  String description;

    public Rooms(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }

    public static boolean isValidDirection(String direction) {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    private Room getConnectedRooms() {
        return Functionalities.currentRoom;
    }

    static Room getCurrentRoom() {
        return Functionalities.currentRoom;
    }

    public String getExitDescription(String direction) {
        return description;
    }
}
