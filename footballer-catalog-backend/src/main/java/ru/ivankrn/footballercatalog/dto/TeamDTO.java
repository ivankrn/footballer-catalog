package ru.ivankrn.footballercatalog.dto;

import jakarta.validation.constraints.NotBlank;

public record TeamDTO(long id, @NotBlank String name) {
}
