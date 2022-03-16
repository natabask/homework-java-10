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
    private MovieItem fourth = new MovieItem(4, "gentlemen.jpg", "Gentlemen", "action", false);
    private MovieItem fifth = new MovieItem(5, "invisible_man.jpg", "Invisible man", "horror", false);
    private MovieItem sixth = new MovieItem(6, "trolls.jpg", "Trolls", "cartoon", true);
    private MovieItem seventh = new MovieItem(7, "number_one.jpg", "Number One", "comedy", true);

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
    public void shouldFindBuId() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        MovieItem[] actual = repo.findById(1);
        MovieItem[] expected = new MovieItem[]{first};

        assertArrayEquals(actual, expected);
    }

    @Test
    // Удаляем всё!
    public void shouldRemoveAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        MovieItem[] actual = repo.removeAll();
        MovieItem[] expected = new MovieItem[0];

        assertArrayEquals(actual, expected);
    }
}