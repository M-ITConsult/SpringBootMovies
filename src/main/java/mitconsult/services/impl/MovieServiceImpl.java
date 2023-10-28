package mitconsult.services.impl;

import mitconsult.models.entities.Movie;
import mitconsult.repositories.MovieRepository;
import mitconsult.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() { return movieRepository.findAll();}

    @Override
    public List<Movie> findManyByTitle(String title) { return movieRepository.searchByTitle(title.toUpperCase());}

    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Long id, Movie movie) {
        Movie existingMovie = findById(id);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        movieRepository.save(existingMovie);
    }

    @Override
    public void delete(Long id) { movieRepository.deleteById(id);}
}
