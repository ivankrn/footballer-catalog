package ru.ivankrn.footballercatalog.dto;

import jakarta.validation.constraints.NotBlank;

public record TeamCreateOrUpdateDTO(@NotBlank String name) {
}
