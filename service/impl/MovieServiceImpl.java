package org.spring.service.impl;

import org.spring.domain.entity.MovieEntity;
import org.spring.domain.repository.MovieRepository;
import org.spring.exception.AlreadyExistsException;
import org.spring.exception.NotFoundException;
import org.spring.mapper.MovieMapper;
import org.spring.model.dto.MovieDto;
import org.spring.model.dto.request.CreateMovieRequest;
import org.spring.model.dto.request.UpdateMovieRequest;

import org.spring.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }


    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream().map(movieMapper::toMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id).map(movieMapper::toMovieDto)
                .orElseThrow(() -> new NotFoundException("Movie not found"));

    }

    @Override
    public MovieDto createMovie(CreateMovieRequest createMovieRequest) {
        existsByTitle(createMovieRequest.getTitle());
        MovieEntity movieEntity = movieMapper.toMovieEntity(createMovieRequest);
        return movieMapper.toMovieDto(movieRepository.save(movieEntity));

    }

    @Override
    public MovieDto updateMovie(Long id, UpdateMovieRequest updateMovieRequest) {
        existsByTitle(updateMovieRequest.getTitle());

        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie not found"));

        movieEntity.setTitle(updateMovieRequest.getTitle());
        movieEntity.setDirector(updateMovieRequest.getDirector());
        movieEntity.setGenre(updateMovieRequest.getGenre());
        movieEntity.setReleaseYear(updateMovieRequest.getReleaseYear());
        movieEntity.setImdbRating(updateMovieRequest.getImdbRating());
        return movieMapper.toMovieDto(movieRepository.save(movieEntity));

    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new NotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);

    }

    private void existsByTitle(String title) {
        if (movieRepository.existsByTitle(title)) {
            throw new AlreadyExistsException("Title already exists");
        }
    }
}
