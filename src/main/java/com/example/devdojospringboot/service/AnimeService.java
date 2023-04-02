package com.example.devdojospringboot.service;

import com.example.devdojospringboot.domain.Anime;
import com.example.devdojospringboot.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService implements AnimeRepository {

    public List<Anime> listAll(){
        return List.of(new Anime(1L, "Attack on Titan"), new  Anime(2L, "Naruto"));
    }
}
