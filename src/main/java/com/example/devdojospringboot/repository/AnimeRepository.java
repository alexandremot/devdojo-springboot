package com.example.devdojospringboot.repository;

import com.example.devdojospringboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
