package com.pokemon.app.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.pokemon.app.service.PokemonService;
import com.pokemon.app.model.Pokemon;
import com.pokemon.app.soap.GetPokemonsRequest;
import com.pokemon.app.soap.GetPokemonsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class PokemonSoapController {
    private static final String NAMESPACE_URI = "http://pokemon.com/app";
    private final PokemonService pokemonService;

    public PokemonSoapController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonsRequest")
    @ResponsePayload
    public GetPokemonsResponse getPokemons(@RequestPayload GetPokemonsRequest request) {
        GetPokemonsResponse response = new GetPokemonsResponse();
        int page = request.getPage();
        
        List<Pokemon> pokemons = pokemonService.getAllPokemon(page);
        response.getPokemons().addAll(pokemons.stream()
            .map(Pokemon::getName)
            .collect(Collectors.toList()));
        
        return response;
    }
}
