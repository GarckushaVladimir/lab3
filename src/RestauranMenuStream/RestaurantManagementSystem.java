package RestauranMenuStream;

import RestauranMenuStream.Appetizer.Appetizer;
import RestauranMenuStream.Appetizer.AppetizerRepository;
import RestauranMenuStream.Dessert.Dessert;
import RestauranMenuStream.Dessert.DessertRepository;
import RestauranMenuStream.MainCourse.MainCourse;
import RestauranMenuStream.MainCourse.MainCourseRepository;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Создаем репозитории
        AppetizerRepository appetizerRepository = new AppetizerRepository();
        MainCourseRepository mainCourseRepository = MainCourseRepository.createMainCourseRepository();
        DessertRepository dessertRepository = new DessertRepository();

        // Добавляем блюда
        Appetizer caesarSalad = new Appetizer("Салат Цезарь", 12.5, 8);
        Appetizer bruschetta = new Appetizer("Брускетта", 9.0, 7);
        appetizerRepository.addDish(caesarSalad);
        appetizerRepository.addDish(bruschetta);

        MainCourse steak = new MainCourse("Стейк", 25.0, 9);
        MainCourse pasta = new MainCourse("Паста", 18.0, 8);
        mainCourseRepository.addDish(steak);
        mainCourseRepository.addDish(pasta);

        Dessert tiramisu = new Dessert("Тирамису", 8.0, 7);
        Dessert cheesecake = new Dessert("Чизкейк", 7.5, 8);
        dessertRepository.addDish(tiramisu);
        dessertRepository.addDish(cheesecake);

        // Выводим все блюда
        System.out.println("Закуски:");
        appetizerRepository.getAllDish().forEach(System.out::println);

        System.out.println("\nОсновные блюда:");
        mainCourseRepository.getAllDish().forEach(System.out::println);

        System.out.println("\nДесерты:");
        dessertRepository.getAllDish().forEach(System.out::println);

        // Сортируем по цене
        System.out.println("\nЗакуски, отсортированные по цене:");
        appetizerRepository.sortByPrice().forEach(System.out::println);

        // Сортируем по популярности
        System.out.println("\nОсновные блюда, отсортированные по популярности:");
        mainCourseRepository.sortByPopularity().forEach(System.out::println);

        // Ищем блюдо по имени
        System.out.println("\nПоиск десерта 'Тирамису':");
        dessertRepository.searchByName("Тирамису").forEach(System.out::println);

        // Удаляем блюдо
        System.out.println("\nУдаляем 'Брускетта':");
        appetizerRepository.removeDish(bruschetta);
        appetizerRepository.getAllDish().forEach(System.out::println);

        // Обновляем блюдо
        System.out.println("\nОбновляем 'Салат Цезарь' на 'Салат Греческий':");
        Appetizer greekSalad = new Appetizer("Салат Греческий", 13.0, 9);
        appetizerRepository.updateDish(caesarSalad, greekSalad);
        appetizerRepository.getAllDish().forEach(System.out::println);
    }
}