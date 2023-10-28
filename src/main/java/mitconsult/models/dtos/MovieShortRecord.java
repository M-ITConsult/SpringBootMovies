package mitconsult.models.dtos;

import mitconsult.models.entities.Movie;

public record MovieShortRecord(Long id, String description) {
    public static MovieShortRecord fromEntity(Movie movie) {
        return new MovieShortRecord(movie.getId(), movie.getTitle());
    }
}
