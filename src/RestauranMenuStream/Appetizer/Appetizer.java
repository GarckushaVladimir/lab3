package RestauranMenuStream.Appetizer;

import RestauranMenuStream.Dish;

public class Appetizer extends Dish {
    public Appetizer(String name, double price, int popularity) {
        super(name, price, popularity);
    }

    @Override
    public String toString() {
        return "Appetizer{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", popularity=" + getPopularity() +
                '}';
    }
}
