package com.pokemon.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.ws.config.annotation.EnableWs;
// import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
// import org.springframework.xml.xsd.SimpleXsdSchema;
// import org.springframework.xml.xsd.XsdSchema;
// import org.springframework.core.io.ClassPathResource;

// @EnableWs
@Configuration
public class SoapWebServiceConfig {

    // @Bean(name = "pokemon")
    // public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonSchema) {
    //     DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    //     definition.setPortTypeName("PokemonPort");
    //     definition.setLocationUri("/ws/pokemon");
    //     definition.setTargetNamespace("http://pokemon.com/app");
    //     definition.setSchema(pokemonSchema);
    //     return definition;
    // }

    // @Bean
    // public XsdSchema pokemonSchema() {
    //     return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    // }
}
