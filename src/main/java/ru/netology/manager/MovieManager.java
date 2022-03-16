package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieItem;

@NoArgsConstructor
@Data
public class MovieManager {
    private int movieAmount = 10;
    private MovieItem[] movies = new MovieItem[0];

    public MovieManager(int movieAmount) {
        this.movieAmount = movieAmount;
    }

    public void add(MovieItem movie) {
        int length = movies.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public MovieItem[] getLatest() {
        int resultLength = 0;
        if (movies.length > movieAmount) {
            resultLength = movieAmount;
        } else {
            resultLength = movies.length;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
