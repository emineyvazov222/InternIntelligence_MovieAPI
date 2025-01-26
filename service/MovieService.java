package org.spring.service;


import org.spring.model.dto.MovieDto;
import org.spring.model.dto.request.CreateMovieRequest;
import org.spring.model.dto.request.UpdateMovieRequest;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(Long id);

    MovieDto createMovie(CreateMovieRequest createMovieRequest);

    MovieDto updateMovie(Long id, UpdateMovieRequest updateMovieRequest);

    void deleteMovie(Long id);


}
