package RestauranMenuStream;

public abstract class Dish {
    private String name;
    private double price;
    private int popularity;

    public Dish(String name, double price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPopularity() {
        return popularity;
    }

}
