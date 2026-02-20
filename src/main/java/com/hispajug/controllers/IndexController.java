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

    private static final List<Jug> jugs = Arrays.asList(new Jug("Madrid JUG", "España", "Madrid", "https://madridjug.org", Arrays.asList(new Lider("Nacho Cougil", "https://media.licdn.com/dms/image/v2/...", "https://linkedin.com/in/nachocougil"), new Lider("Mercedes W.", "https://example.com/photo2.jpg", "https://linkedin.com/in/mercedesw"))), new Jug("GuateJUG", "Guatemala", "Guatemala City", "https://guatejug.net", List.of(new Lider("Víctor Orozco", "https://example.com/victor.jpg", "https://linkedin.com/in/tuxtor"))), new Jug("Java México", "México", "CDMX", "https://javamexico.org", List.of(new Lider("Domingo Suárez", "https://example.com/domingo.jpg", "https://linkedin.com/in/domingosuarez"))), new Jug("Peru JUG", "Perú", "Lima", "https://perujug.org", List.of(new Lider("Jose Díaz", "https://example.com/jose.jpg", "https://linkedin.com/in/josediaz"))));

    private static final List<Evento> eventos = List.of(new Evento("Novedades en el GC de Java 21+", "Una inmersión profunda en los recolectores de basura modernos y cómo optimizar nuestras aplicaciones en producción.", LocalDate.of(2026, 3, 25), "En Vivo vía YouTube", "#"));

    @Get
    public ModelAndView<?> index(@QueryValue final Optional<String> pais) {
        final List<String> listaPaises = jugs.stream().map(Jug::pais).distinct().toList();

        List<Jug> filteredJugs = jugs;
        if (pais.isPresent() && !pais.get().isBlank()) {
            String filter = pais.get().toLowerCase();
            filteredJugs = jugs.stream().filter(j -> j.pais().toLowerCase().contains(filter)).toList();
        }

        final Map<String, Object> model = Map.of("jugs", filteredJugs, "paisFiltro", pais.orElse(""), "listaPaises", listaPaises, "proximoEvento", eventos.isEmpty() ? null : eventos.get(0));

        return new ModelAndView<>("index", model);
    }

}
