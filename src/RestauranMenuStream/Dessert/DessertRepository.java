package RestauranMenuStream.Dessert;

import RestauranMenuStream.Menu.SearchableMenuRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DessertRepository implements SearchableMenuRepository<Dessert> {
    private final List<Dessert> desserts = new ArrayList<>();

    @Override
    public void addDish(Dessert dish) {
        desserts.add(dish);
    }

    @Override
    public void removeDish(Dessert dish) {
        desserts.remove(dish);
    }

    @Override
    public void updateDish(Dessert oldDish, Dessert newDish) {
        int index = desserts.indexOf(oldDish);
        if (index != -1) {
            desserts.set(index, newDish);
        }
    }

    @Override
    public List<Dessert> getAllDish() {
        return new ArrayList<>(desserts);
    }

    @Override
    public List<Dessert> sortByPrice() {
        return desserts.stream()
                .sorted(Comparator.comparingDouble(Dessert::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dessert> sortByPopularity() {
        return desserts.stream()
                .sorted(Comparator.comparingInt(Dessert::getPopularity).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Dessert> searchByName(String name) {
        return desserts.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}