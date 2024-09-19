package com.pokemon.app.controller;

import com.pokemon.app.model.Pokemon;
import com.pokemon.app.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/api/pokemon")
    public List<Pokemon> getPokemons(@RequestParam(value = "page", defaultValue = "0") int page) {
        return pokemonService.getAllPokemon(page);
    }
}
