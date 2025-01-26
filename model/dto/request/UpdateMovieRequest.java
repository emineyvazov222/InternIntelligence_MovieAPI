package org.spring.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequest {

    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private BigDecimal imdbRating;

}
