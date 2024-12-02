package RestauranMenuStream.Menu;

import java.util.List;

public interface MenuRepository<T> {
    void addDish(T dish);
    void removeDish(T dish);
    void updateDish(T oldDish, T newDish);
    List<T> getAllDish();
}
