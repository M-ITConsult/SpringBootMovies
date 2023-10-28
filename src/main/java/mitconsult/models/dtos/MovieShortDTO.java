package mitconsult.models.dtos;

import lombok.Data;
import mitconsult.models.entities.Movie;

@Data
public class MovieShortDTO {
    private Long id;
    private String title;

    public static MovieShortDTO fromEntity(Movie movie) {
        MovieShortDTO dto = new MovieShortDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        return dto;
    }
}
