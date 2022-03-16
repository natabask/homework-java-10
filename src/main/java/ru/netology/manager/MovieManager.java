package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(MovieItem movie) {
        repository.save(movie);
    }

    public MovieItem[] getAll() {
        MovieItem[] movies = repository.findAll();
        MovieItem[] result = new MovieItem[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
