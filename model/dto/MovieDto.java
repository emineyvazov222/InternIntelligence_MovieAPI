package org.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.model.enums.MovieStatus;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private BigDecimal imdbRating;
    private MovieStatus status;


}
