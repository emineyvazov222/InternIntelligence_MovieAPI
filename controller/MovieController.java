package org.spring.controller;

import jakarta.validation.Valid;
import org.spring.model.dto.MovieDto;
import org.spring.model.dto.request.CreateMovieRequest;
import org.spring.model.dto.request.UpdateMovieRequest;
import org.spring.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping()
    ResponseEntity<MovieDto> createMovie(@Valid @RequestBody CreateMovieRequest createMovieRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(createMovieRequest));
    }

    @PutMapping("/{id}")
    ResponseEntity<MovieDto> updateMovie(@PathVariable Long id,@Valid @RequestBody UpdateMovieRequest updateMovieRequest) {
        return ResponseEntity.ok(movieService.updateMovie(id, updateMovieRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
