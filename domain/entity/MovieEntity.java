package org.spring.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    @SequenceGenerator(name = "movie_id", sequenceName = "movie_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id")
    private Long id;

    private String title;
    private String director;
    private Integer releaseYear;
    private String genre;
    private BigDecimal imdbRating;


}
