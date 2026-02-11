package es.iesquevedo.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import es.iesquevedo.dao.JsonSocioDaoImpl;

@ApplicationScoped
public class ConfigProducer {

    @Produces
    public JsonSocioDaoImpl produceJsonSocioDao() {
        String path = System.getProperty("socios.file", "socios.json");
        return new JsonSocioDaoImpl(path);
    }
}
