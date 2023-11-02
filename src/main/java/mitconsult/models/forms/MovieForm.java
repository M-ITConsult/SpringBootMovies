package mitconsult.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import mitconsult.models.entities.Movie;

@Data
public class MovieForm {
    @NotBlank
    @Size(min = 2, max = 100)
    private String title;
    private String description;

    public Movie toEntity() {
        Movie movie = new Movie();
        movie.setTitle(this.title);
        movie.setDescription(this.description);
        return movie;
    }

    public static MovieForm fromEntity(Movie movie) {
        MovieForm movieForm = new MovieForm();
        movieForm.setTitle(movie.getTitle());
        movieForm.setDescription(movie.getDescription());
        return movieForm;
    }
}
