package mitconsult.repositories;

import mitconsult.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMoviesByTitleContainingIgnoreCase(String title);
    @Query("select m from Movie m where upper(m.title) like %:title%")
    List<Movie> searchByTitle(@Param("title") String title);

}
