package com.pokemon.app.service;

import com.pokemon.app.exception.PokemonFetchException;
import com.pokemon.app.model.Pokemon;
import com.pokemon.app.model.PokemonResponse;
import com.pokemon.app.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.util.Collections;
import java.util.List;

@Service
public class PokemonService implements PokemonRepository {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PokemonService.class);

    @Autowired
    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Pokemon> getAllPokemon(int page) {
        if (page < 0) {
            throw new IllegalArgumentException("Page number must be non-negative");
        }

        String url = "https://pokeapi.co/api/v2/pokemon?offset=" + (page * 20) + "&limit=20";
        try {
            PokemonResponse response = restTemplate.getForObject(url, PokemonResponse.class);
            return response != null && response.getResults() != null ? response.getResults() : Collections.emptyList();
        } catch (RestClientException e) {
            logger.error("Error fetching Pokémon data: {}", e.getMessage());
            throw new PokemonFetchException("Failed to fetch Pokémon data");
        }
    }
}
