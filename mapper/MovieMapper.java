package org.spring.mapper;

import org.spring.domain.entity.MovieEntity;
import org.spring.model.dto.MovieDto;
import org.spring.model.dto.request.CreateMovieRequest;
import org.spring.model.enums.MovieStatus;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto toMovieDto(MovieEntity movieEntity) {
        return MovieDto.builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .director(movieEntity.getDirector())
                .genre(movieEntity.getGenre())
                .releaseYear(movieEntity.getReleaseYear())
                .imdbRating(movieEntity.getImdbRating())
                .status(MovieStatus.IN_THEATERS)
                .build();

    }

    public MovieEntity toMovieEntity(MovieDto movieDto) {
        return MovieEntity.builder()
                .id(movieDto.getId())
                .title(movieDto.getTitle())
                .director(movieDto.getDirector())
                .genre(movieDto.getGenre())
                .releaseYear(movieDto.getReleaseYear())
                .imdbRating(movieDto.getImdbRating())
                .build();

    }

    public MovieEntity toMovieEntity(CreateMovieRequest createMovieRequest) {
        return MovieEntity.builder()
                .title(createMovieRequest.getTitle())
                .director(createMovieRequest.getDirector())
                .genre(createMovieRequest.getGenre())
                .releaseYear(createMovieRequest.getReleaseYear())
                .imdbRating(createMovieRequest.getImdbRating())
                .build();
    }

}
