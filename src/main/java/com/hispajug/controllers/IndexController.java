package com.hispajug.controllers;

import com.hispajug.models.Evento;
import com.hispajug.models.Jug;
import com.hispajug.models.Lider;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.views.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class IndexController {

    private static final List<Jug> jugs = Arrays.asList(
            new Jug("Madrid JUG", "España", "Madrid", "https://madridjug.es",
                    Arrays.asList(
                            new Lider("Ivan Lopez", "https://github.com/ilopmar.png", "https://www.linkedin.com/in/ilopmar"),
                            new Lider("Adolfo Sanz", "https://github.com/asanzdiego.png", "https://www.linkedin.com/in/adolfosanz"),
                            new Lider("Gonzalo Ortiz", "https://github.com/gonzaloortiz.png", "https://www.linkedin.com/in/gonzalo-ortiz-jaureguizar")
                    )),
            new Jug("Barcelona JUG", "España", "Barcelona", "https://barcelonajug.org",
                    Arrays.asList(
                            new Lider("Nacho Cougil", "https://github.com/ncougil.png", "https://www.linkedin.com/in/nachocougil"),
                            new Lider("Jonathan Vila", "https://github.com/jonathanvila.png", "https://www.linkedin.com/in/jonathanvila"),
                            new Lider("Anyul Rivas", "https://github.com/anyulir.png", "https://www.linkedin.com/in/anyulrivas")
                    )),
            new Jug("Vigo JUG", "España", "Vigo", "https://www.meetup.com/vigojug",
                    List.of(new Lider("Marcos Fernández", "https://github.com/marcos-fernandez.png", "https://www.linkedin.com/in/marcosfernandez"))),
            new Jug("Málaga JUG", "España", "Málaga", "https://www.meetup.com/MalagaJUG",
                    List.of(new Lider("Javier Ferrer", "https://github.com/jferrer.png", "https://www.linkedin.com/in/javierferrer"))),
            new Jug("Valencia JUG", "España", "Valencia", "https://www.meetup.com/ValenciaJUG",
                    List.of(new Lider("César Hernández", "https://github.com/cesarhernandezgt.png", "https://linkedin.com/in/cesarhernandezgt"))),
            new Jug("Sevilla JUG", "España", "Sevilla", "http://www.meetup.com/SVQJUG",
                    List.of(new Lider("Octavio Estévez", "https://github.com/octaio.png", "https://linkedin.com/in/octavioestevez"))),
            new Jug("GuateJUG", "Guatemala", "Guatemala City", "https://guatejug.net",
                    Arrays.asList(
                            new Lider("Víctor Orozco", "https://github.com/tuxtor.png", "https://www.linkedin.com/in/victororozco"),
                            new Lider("César Hernández", "https://github.com/cesarhernandezgt.png", "https://www.linkedin.com/in/cesarhernandez"),
                            new Lider("Eddu Melendez", "https://github.com/eddumelendez.png", "https://www.linkedin.com/in/eddu-melendez")
                    )),
            new Jug("Java México", "México", "CDMX", "https://javamexico.org",
                    Arrays.asList(
                            new Lider("Jorge Vargas", "https://github.com/edivargas.png", "https://www.linkedin.com/in/edivargas"),
                            new Lider("Ixchel Ruiz", "https://github.com/ixchelruiz.png", "https://www.linkedin.com/in/ixchelruiz"),
                            new Lider("Domingo Suárez", "https://github.com/domix.png", "https://linkedin.com/in/domingosuarez")
                    )),
            new Jug("Guadalajara JUG", "México", "Guadalajara", "https://gdljug.github.io",
                    Arrays.asList(
                            new Lider("Eduardo Moranchel", "https://github.com/emoranchel.png", "https://www.linkedin.com/in/emoranchel"),
                            new Lider("Ulises Pulido", "https://github.com/ulisespulido.png", "https://www.linkedin.com/in/ulisespulido")
                    )),
            new Jug("Peru JUG", "Perú", "Lima", "https://perujug.org",
                    Arrays.asList(
                            new Lider("Jose Díaz", "https://github.com/jamdiazdiaz.png", "https://www.linkedin.com/in/jamdiazdiaz"),
                            new Lider("Jhosep Darío Luna", "https://github.com/jdluna.png", "https://www.linkedin.com/in/jdluna")
                    )),
            new Jug("Java Dominicano", "República Dominicana", "Santo Domingo", "https://github.com/JavaDominicano",
                    List.of(new Lider("Eudris Cabrera", "https://github.com/eudriscabrera.png", "https://linkedin.com/in/eudriscabrera"))),
            new Jug("Ecuador JUG", "Ecuador", "Quito", "http://www.ecuadorjug.org",
                    List.of(new Lider("Alberto Salazar", "https://github.com/alberto-salazar-15334154.png", "https://www.linkedin.com/in/alberto-salazar-15334154/"))),
            new Jug("Bogotá JVM", "Colombia", "Bogotá", "https://www.bogotajvm.com.co",
                    List.of(new Lider("Carlos Sánchez", "https://github.com/carlossg.png", "https://www.linkedin.com/in/carlossg"))),
            new Jug("MDEJUG", "Colombia", "Medellín", "https://mdejug.wordpress.com",
                    Arrays.asList(
                            new Lider("Hillmer Chona", "https://github.com/hillmerc.png", "https://www.linkedin.com/in/hillmerc"),
                            new Lider("David Gómez", "https://github.com/dgomezg.png", "https://www.linkedin.com/in/dgomezg")
                    )),
            new Jug("Barranquilla JUG", "Colombia", "Barranquilla", "https://www.meetup.com/jugbaq",
                    List.of(new Lider("Fabio Turizo", "https://github.com/fabioturizo.png", "https://www.linkedin.com/in/fabioturizo"))),
            new Jug("Cali JUG", "Colombia", "Cali", "http://www.clojug.org",
                    List.of(new Lider("Alexis López", "https://github.com/ajlopez.png", "https://linkedin.com/in/ajlopez"))),
            new Jug("Pura Vida JUG", "Costa Rica", "San José", "https://puravidajug.org",
                    Arrays.asList(
                            new Lider("Emmanuel Guzmán", "https://github.com/eguzman.png", "https://linkedin.com/in/emmanuel-guzm%C3%A1n-b0b2b2b2"),
                            new Lider("Francisco Contreras", "https://github.com/franciscontreras.png", "https://linkedin.com/in/francisco-contreras-b0b2b2b2")
                    )),
            new Jug("Nicaragua JUG", "Nicaragua", "Managua", "https://jugnicaragua.org",
                    List.of(new Lider("Omar Berroterán Silva", "https://github.com/omarberroteran.png", "https://linkedin.com/in/omarberroteransilva"))),
            new Jug("Panama JUG", "Panamá", "Panamá", "https://github.com/jugpanama",
                    List.of(new Lider("Aristides Villarreal", "https://github.com/aristidesvillarreal.png", "https://www.linkedin.com/in/aristidesvillarreal"))),
            new Jug("JUG Argentina", "Argentina", "Buenos Aires", "https://www.java.net.ar",
                    List.of(new Lider("Matías Miguez", "https://github.com/matiasmiguez.png", "https://www.linkedin.com/in/matiasmiguez"))),
            new Jug("JUG Uruguay", "Uruguay", "Montevideo", "https://dev.java/community/jugs/",
                    List.of(new Lider("Comunidad Uruguay", "https://github.com/jug-uruguay.png", "https://linkedin.com/company/jug-uruguay"))),
            new Jug("JUG Chile", "Chile", "Santiago", "https://discord.gg/RFzqQAyaYV",
                    List.of(new Lider("Mario Almonacid", "https://github.com/marioalmonacid.png", "https://www.linkedin.com/in/marioalmonacid"))),
            new Jug("Bolivian JUG", "Bolivia", "Cochabamba", "https://www.facebook.com/BolivianJUG",
                    List.of(new Lider("Comunidad Bolivia", "https://github.com/bolivian-jug.png", "https://linkedin.com/company/bolivian-jug"))),
            new Jug("JugPY", "Paraguay", "Asunción", "https://twitter.com/jugpy",
                    List.of(new Lider("Comunidad Paraguay", "https://github.com/jugpy.png", "https://linkedin.com/company/jugpy")))
    );

    private static final List<Evento> eventos = List.of(
            new Evento("Novedades en el GC de Java 21+", "Una inmersión profunda en los recolectores de basura modernos y cómo optimizar nuestras aplicaciones en producción.", LocalDate.of(2026, 3, 25), "En Vivo vía YouTube", "#")
    );

    @Get
    public ModelAndView<?> index(@QueryValue final Optional<String> pais) {
        final List<String> listaPaises = jugs.stream().map(Jug::pais).distinct().sorted().toList();

        List<Jug> filteredJugs = jugs;
        if (pais.isPresent() && !pais.get().isBlank()) {
            String filter = pais.get().toLowerCase();
            filteredJugs = jugs.stream().filter(j -> j.pais().toLowerCase().contains(filter)).toList();
        }

        final Map<String, Object> model = Map.of(
                "jugs", filteredJugs,
                "paisFiltro", pais.orElse(""),
                "listaPaises", listaPaises,
                "proximoEvento", eventos.isEmpty() ? null : eventos.get(0)
        );

        return new ModelAndView<>("index", model);
    }

}
