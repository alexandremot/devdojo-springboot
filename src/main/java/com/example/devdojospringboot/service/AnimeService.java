package com.example.devdojospringboot.service;

import com.example.devdojospringboot.domain.Anime;
import com.example.devdojospringboot.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService implements AnimeRepository {

    private List<Anime> animes = List.of(new Anime(1L, "Attack on Titan"), new  Anime(2L, "Naruto"));

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        Anime result = animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found!"));
        return result;
    }
}
