package RestauranMenuStream.Menu;

import java.util.List;

public interface SearchableMenuRepository<T> extends SortableMenuRepository<T> {
    List<T> searchByName(String name);
}
