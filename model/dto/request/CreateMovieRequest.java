package org.spring.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest {

    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @NotBlank(message = "Director cannot be blank.")
    private String director;

    @NotNull(message = "Release year cannot be null.")
    private Integer releaseYear;

    @NotBlank(message = "Genre cannot be blank.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Genre must contain only letters and spaces.")
    private String genre;

    @DecimalMin(value = "0.0", inclusive = true, message = "IMDb rating must be at least 0.0.")
    @DecimalMax(value = "10.0", inclusive = true, message = "IMDb rating must not exceed 10.0.")
    private BigDecimal imdbRating;

}
