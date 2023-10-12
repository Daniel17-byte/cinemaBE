package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Movie;
import com.example.cinemabe.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie( @RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable(value = "id") Long movieId) {
        return ResponseEntity.ok().body(movieService.getMovieById(movieId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) {
        return ResponseEntity.ok().body(movieService.updateMovie(movieId, movieDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable(value = "id") Long movieId) {
        movieService.deleteMovieById(movieId);
        return ResponseEntity.ok().build();
    }
}