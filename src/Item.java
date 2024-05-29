import java.util.ArrayList;

public class Item
{
    private String name = "";
    private String description = "";
    private ArrayList<Room> items;

    public Item() {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return name + ":" + description;
    }

}
