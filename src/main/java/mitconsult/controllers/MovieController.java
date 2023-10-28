package mitconsult.controllers;

import mitconsult.models.dtos.MovieShortDTO;
import mitconsult.models.entities.Movie;
import mitconsult.models.forms.MovieForm;
import mitconsult.services.impl.MovieServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) { this.movieService = movieService;}

    @GetMapping
    public String findAll(Model model) {
        List<Movie> movies = movieService.findAll();
        List<MovieShortDTO> dtos = movies.stream()
                            .map(MovieShortDTO::fromEntity)
                            .toList();
        model.addAttribute("dtos", dtos);
        return "movie/index.html";
    }

    @GetMapping("/{id}")
    public String findOneById(@PathVariable Long id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movie/detail.html";
    }
    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("movieForm", new MovieForm());
        return "movie/create.html";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute MovieForm movieForm) {
        Movie movie = movieForm.toEntity();
        movieService.create(movie);
        return "redirect:/movie";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model) {
        Movie movie = movieService.findById(id);
        MovieForm movieForm = MovieForm.fromEntity(movie);
        model.addAttribute("id", id);
        model.addAttribute("movieForm", movieForm);
        return "movie/update.html";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@ModelAttribute MovieForm movieForm, @PathVariable Long id) {
        Movie movie = movieForm.toEntity();
        movieService.update(id, movie);
        return "redirect:/movie";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieService.delete(id);
        return "redirect:/movie";
    }

    @PostMapping("/search")
    public String search(@RequestParam("input") String input, Model model) {
        List<Movie> movies = movieService.findManyByTitle(input);
        List<MovieShortDTO> dtos = movies.stream()
                            .map(MovieShortDTO::fromEntity)
                            .toList();
        model.addAttribute("dtos",dtos);
        return  "movie/index.html";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        movieService.deleteAll();
        model.addAttribute("deleteAll");
        return "redirect:/movie";
    }
}
