package mitconsult.services;

import mitconsult.models.entities.Movie;

import java.util.List;

public interface MovieService {
    void create(Movie movie);

    List<Movie> findAll();

    List<Movie> findManyByTitle(String title);
   void deleteAll();

    Movie findById(Long id);

    void update(Long id, Movie movie);

    void delete(Long id);
}
