package com.pokemon.app.soap;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetPokemonsResponse")
public class GetPokemonsResponse {
    private List<String> pokemons = new ArrayList<>();

    @XmlElement(name = "pokemon")
    public List<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<String> pokemons) {
        this.pokemons = pokemons;
    }
}
