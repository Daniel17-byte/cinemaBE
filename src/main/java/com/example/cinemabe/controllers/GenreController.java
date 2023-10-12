package com.example.cinemabe.controllers;

import com.example.cinemabe.models.Genre;
import com.example.cinemabe.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        if (genre.isPresent()) {
            return ResponseEntity.ok(genre.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        Optional<Genre> currentGenre = genreService.getGenreById(id);
        if (currentGenre.isPresent()) {
            genre.setId(id);
            genreService.updateGenre(genre);
            return ResponseEntity.ok(genre);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        if (genre.isPresent()) {
            genreService.deleteGenreById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}