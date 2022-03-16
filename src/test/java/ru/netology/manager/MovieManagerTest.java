package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    // используем конструктор без аргументов, выдаются последние 10 добавленных фильмов (значение по умолчанию)
    private MovieManager manager = new MovieManager();
    // используем конструктор c одним аргументом, выдаётся 2 последних из добавленных фильмов
    private MovieManager manager2 = new MovieManager(2);
    // используем конструктор c одним аргументом, выдаётся последний из добавленных фильмов
    private MovieManager manager3 = new MovieManager(1);

    private MovieItem first = new MovieItem(1, "bloodshot.jpg", "Bloodshot", "action", false);
    private MovieItem second = new MovieItem(2, "onward.jpg", "Onward", "cartoon", false);
    private MovieItem third = new MovieItem(3, "hotel_belgrade.jpg", "Hotel Belgrade", "comedy", false);
    private MovieItem fourth = new MovieItem(4, "gentlemen.jpg", "Gentlemen", "action", false);
    private MovieItem fifth = new MovieItem(5, "invisible_man.jpg", "Invisible man", "horror", false);
    private MovieItem sixth = new MovieItem(6, "trolls.jpg", "Trolls", "cartoon", true);
    private MovieItem seventh = new MovieItem(7, "number_one.jpg", "Number One", "comedy", true);

    // Тесты для конструктора без аргументов
    @Test
    // Выводим "пустой" список
    public void shouldReturnIfEmpty() {
        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим "список" из одного фильма
    public void shouldReturnIfOne() {
        manager.add(first);
        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество меньше максимального = 10
    public void shouldReturnIfNotEmpty() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество = максимальному = 10
    public void shouldReturnIfMax() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{third, second, first, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество больше максимального = 10
    public void shouldReturnIfMoreThanMax() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{fourth, third, second, first, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список всех добавленных фильмов
    public void shouldReturnAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        MovieItem[] actual = manager.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    // Тесты для менеджера, который выводит 2 последних фильма
    @Test
    // Выводим "пустой" список
    public void shouldReturnIfEmpty2() {
        MovieItem[] actual = manager2.getLatest();
        MovieItem[] expected = new MovieItem[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим "список" из 1-го фильма
    public void shouldReturnIfOne2() {
        manager2.add(first);
        MovieItem[] actual = manager2.getLatest();
        MovieItem[] expected = new MovieItem[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество = максимальному = 2
    public void shouldReturnIfMax2() {
        manager2.add(first);
        manager2.add(second);
        MovieItem[] actual = manager2.getLatest();
        MovieItem[] expected = new MovieItem[]{second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество больше максимального = 2
    public void shouldReturnIfMoreThanMax2() {
        manager2.add(first);
        manager2.add(second);
        manager2.add(third);
        MovieItem[] actual = manager2.getLatest();
        MovieItem[] expected = new MovieItem[]{third, second};
        assertArrayEquals(expected, actual);
    }

    // Тесты для менеджера, который выводит 1 последний фильм
    @Test
    // Выводим "пустой" список
    public void shouldReturnIfEmpty3() {
        MovieItem[] actual = manager3.getLatest();
        MovieItem[] expected = new MovieItem[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    // Добавляем и выводим "список" из 1-го фильма
    public void shouldReturnIfOne3() {
        manager3.add(first);
        MovieItem[] actual = manager3.getLatest();
        MovieItem[] expected = new MovieItem[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    // Добавляем несколько фильмов, выводим последний
    public void shouldReturnIfNotEmpty3() {
        manager3.add(first);
        manager3.add(second);
        manager3.add(third);
        manager3.add(fourth);
        manager3.add(fifth);
        manager3.add(sixth);
        MovieItem[] actual = manager3.getLatest();
        MovieItem[] expected = new MovieItem[]{sixth};
        assertArrayEquals(expected, actual);
    }
}