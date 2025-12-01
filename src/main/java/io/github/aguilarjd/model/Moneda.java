package io.github.aguilarjd.model;

public record Moneda(String base_code,
                     String target_code,
                     String time_last_update_utc,
                     double conversion_rate) {
}