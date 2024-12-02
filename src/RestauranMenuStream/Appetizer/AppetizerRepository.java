package RestauranMenuStream.Appetizer;

import RestauranMenuStream.Menu.SearchableMenuRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppetizerRepository implements SearchableMenuRepository<Appetizer> {
    private final List<Appetizer> appetizers = new ArrayList<>();

    @Override
    public List<Appetizer> searchByName(String name) {
        return appetizers.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Appetizer> sortByPrice() {
        return appetizers.stream()
                .sorted(Comparator.comparingDouble(Appetizer::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Appetizer> sortByPopularity() {
        return appetizers.stream()
                .sorted(Comparator.comparingInt(Appetizer::getPopularity).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void addDish(Appetizer dish) {
        appetizers.add(dish);
    }

    @Override
    public void removeDish(Appetizer dish) {
        appetizers.remove(dish);
    }

    @Override
    public void updateDish(Appetizer oldDish, Appetizer newDish) {
        int index = appetizers.indexOf(oldDish);
        if (index != -1) appetizers.set(index, newDish);
    }

    @Override
    public List<Appetizer> getAllDish() {
        return new ArrayList<>(appetizers);
    }
}
