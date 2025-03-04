package dev.nathan.shortenerUrl.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record LinkRequest(
        @NotBlank(message = "A URL original é obrigatória") @URL(message = "A URL fornecida é inválida") String originalUrl) {
}