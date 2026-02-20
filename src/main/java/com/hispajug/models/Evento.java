package com.hispajug.models;

import java.time.LocalDate;

public record Evento(
        String titulo,
        String descripcion,
        LocalDate fecha,
        String tipo,
        String urlRegistro
) {
}
