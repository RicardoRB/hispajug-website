package com.hispajug.models;

import java.util.List;

public record Jug(
        String nombre,
        String pais,
        String localizacion,
        String webUrl,
        List<Lider> lideres
) {
}