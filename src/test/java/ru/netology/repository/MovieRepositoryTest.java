package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository repo = new MovieRepository();
    private MovieItem first = new MovieItem(1, "bloodshot.jpg", "Bloodshot", "action", false);
    private MovieItem second = new MovieItem(2, "onward.jpg", "Onward", "cartoon", false);
    private MovieItem third = new MovieItem(3, "hotel_belgrade.jpg", "Hotel Belgrade", "comedy", false);

    @Test
    // Удаляем элемент по Id
    public void shouldRemoveBuId() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);

        MovieItem[] actual = repo.findAll();
        MovieItem[] expected = new MovieItem[]{first, third};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Ищем элемент по Id
    public void shouldFindById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        MovieItem actual = repo.findById(2);
        MovieItem expected = second;

        assertEquals(expected, actual);
    }

    @Test
    // Удаляем всё!
    public void shouldRemoveAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeAll();

        MovieItem[] actual = repo.findAll();
        MovieItem[] expected = new MovieItem[]{};

        assertArrayEquals(actual, expected);
    }
}