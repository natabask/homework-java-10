package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// используем конструктор без аргументов, выдаются последние 10 добавленных фильмов (значение по умолчанию)
public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MovieItem first = new MovieItem(1, "bloodshot.jpg", "Bloodshot", "action", false);
    private MovieItem second = new MovieItem(2, "onward.jpg", "Onward", "cartoon", false);
    private MovieItem third = new MovieItem(3, "hotel_belgrade.jpg", "Hotel Belgrade", "comedy", false);
    private MovieItem fourth = new MovieItem(4, "gentlemen.jpg", "Gentlemen", "action", false);
    private MovieItem fifth = new MovieItem(5, "invisible_man.jpg", "Invisible man", "horror", false);
    private MovieItem sixth = new MovieItem(6, "trolls.jpg", "Trolls", "cartoon", true);
    private MovieItem seventh = new MovieItem(7, "number_one.jpg", "Number One", "comedy", true);

    @Test
    // Выводим "пустой" список
    public void shouldReturnIfEmpty() {

        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим "список" из 1-го фильма
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
}