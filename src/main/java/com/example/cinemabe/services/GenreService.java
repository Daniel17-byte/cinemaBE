package com.example.cinemabe.services;

import com.example.cinemabe.models.Genre;
import com.example.cinemabe.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public Genre updateGenre(Genre genre) {
        return genreRepository.saveAndFlush(genre);
    }

    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}