package RestauranMenuStream.MainCourse;

import RestauranMenuStream.Dish;

public class MainCourse extends Dish {
    public MainCourse(String name, double price, int popularity) {
        super(name, price, popularity);
    }

    @Override
    public String toString() {
        return "MainCourse{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", popularity=" + getPopularity() +
                '}';
    }
}
