package src.model;

public class item {
    private int id;
    private String name;
    private String type;
    private String color;

    public item(int id, String name, String type, String color) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getColor() { return color; }
}