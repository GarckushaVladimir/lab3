package RestauranMenuStream.MainCourse;

import RestauranMenuStream.Menu.SearchableMenuRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainCourseRepository implements SearchableMenuRepository<MainCourse> {
    private final List<MainCourse> mainCourses = new ArrayList<>();

    private MainCourseRepository() {
    }

    public static MainCourseRepository createMainCourseRepository() {
        return new MainCourseRepository();
    }

    @Override
    public List<MainCourse> searchByName(String name) {
        return mainCourses.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<MainCourse> sortByPrice() {
        return mainCourses.stream()
                .sorted(Comparator.comparingDouble(MainCourse::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<MainCourse> sortByPopularity() {
        return mainCourses.stream()
                .sorted(Comparator.comparingInt(MainCourse::getPopularity).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void addDish(MainCourse dish) {
        mainCourses.add(dish);
    }

    @Override
    public void removeDish(MainCourse dish) {
        mainCourses.remove(dish);
    }

    @Override
    public void updateDish(MainCourse oldDish, MainCourse newDish) {
        int index = mainCourses.indexOf(oldDish);
        if (index != -1) mainCourses.set(index, newDish);
    }

    @Override
    public List<MainCourse> getAllDish() {
        return new ArrayList<>(mainCourses);
    }
}
