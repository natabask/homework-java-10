package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTestListOfTwo {
        // используем конструктор c 1 аргументом, выдаётся 2 последних из добавленных фильмов
        private MovieManager manager = new MovieManager(2);
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
    // Выводим список фильмов, количество = максимальному = 2
    public void shouldReturnIfMax() {
        manager.add(first);
        manager.add(second);

        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    // Выводим список фильмов, количество больше максимального = 2
    public void shouldReturnIfMoreThanMax() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getLatest();
        MovieItem[] expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}