package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieItem {
    private int id;
    private String pictureUrl;
    private String title;
    private String genre;
    private boolean premiereTomorrow;
}