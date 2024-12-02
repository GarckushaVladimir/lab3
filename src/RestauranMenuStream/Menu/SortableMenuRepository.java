package RestauranMenuStream.Menu;

import java.util.List;

public interface SortableMenuRepository<T> extends MenuRepository<T> {
    List<T> sortByPrice();
    List<T> sortByPopularity();
}
