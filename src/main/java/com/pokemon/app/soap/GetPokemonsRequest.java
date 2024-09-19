package com.pokemon.app.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetPokemonsRequest")
public class GetPokemonsRequest {
    private int page;

    @XmlElement
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
