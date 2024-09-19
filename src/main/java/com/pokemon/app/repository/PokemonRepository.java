package com.pokemon.app.repository;

import com.pokemon.app.model.Pokemon;

import java.util.List;

public interface PokemonRepository {
    List<Pokemon> getAllPokemon(int page);
}
