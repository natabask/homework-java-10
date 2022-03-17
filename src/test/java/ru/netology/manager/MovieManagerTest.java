package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class MovieManagerTest {
    private MovieRepository repository = Mockito.mock(MovieRepository.class);
    private MovieManager manager = new MovieManager(repository);
    private MovieItem first = new MovieItem(1, "bloodshot.jpg", "Bloodshot", "action", false);
    private MovieItem second = new MovieItem(2, "onward.jpg", "Onward", "cartoon", false);
    private MovieItem third = new MovieItem(3, "hotel_belgrade.jpg", "Hotel Belgrade", "comedy", false);
    private MovieItem fourth = new MovieItem(4, "gentlemen.jpg", "Gentlemen", "action", false);

    @Test
    // Вывод массива
    public void shouldFindAll() {
        MovieItem[] returned = {first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{fourth, third, second, first};

        assertArrayEquals(actual, expected);

        verify(repository).findAll();
    }
}