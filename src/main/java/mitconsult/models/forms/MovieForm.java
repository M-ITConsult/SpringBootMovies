package mitconsult.models.forms;

import lombok.Data;
import mitconsult.models.entities.Movie;

@Data
public class MovieForm {
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
