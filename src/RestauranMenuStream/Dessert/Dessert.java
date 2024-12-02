package RestauranMenuStream.Dessert;

import RestauranMenuStream.Dish;

public class Dessert extends Dish {
    public Dessert(String name, double price, int popularity) {
        super(name, price, popularity);
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", popularity=" + getPopularity() +
                '}';
    }
}
