package com.platzi.platziplayapi.persistence.mapper;

import com.platzi.platziplayapi.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genre) {
        if (genre == null) return null;

        return switch (genre.toUpperCase()) {
            case "ACTION" -> Genre.ACTION;
            case "COMEDY" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMATED" -> Genre.ANIMATED;
            case "DOCUMENTARY" -> Genre.DOCUMENTARY;
            case "SCI-FI" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) return null;

        return switch (genre) {
            case Genre.ACTION -> "ACTION";
            case Genre.COMEDY -> "COMEDY";
            case Genre.DRAMA -> "DRAMA";
            case Genre.ANIMATED -> "ANIMATED";
            case Genre.DOCUMENTARY -> "DOCUMENTARY" ;
            case Genre.SCI_FI -> "SCI-FI";
            default -> null;
        };
    }
}
