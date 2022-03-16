package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] movies = new MovieItem[0];

    public MovieItem[] getMovies() {
        return movies;
    }

    public void setMovies(MovieItem[] movies) {
        this.movies = movies;
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public void save(MovieItem movie) {
        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieItem[] findById(int id) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() == id) {
                return new MovieItem[]{movies[i]};
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public MovieItem[] removeAll() {
        MovieItem[] result = new MovieItem[0];
        return result;
    }
}
