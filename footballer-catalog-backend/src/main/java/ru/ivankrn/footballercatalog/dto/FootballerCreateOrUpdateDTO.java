package ru.ivankrn.footballercatalog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.ivankrn.footballercatalog.database.model.Country;
import ru.ivankrn.footballercatalog.database.model.Gender;
import ru.ivankrn.footballercatalog.validator.EnumValue;

import java.time.LocalDate;

public record FootballerCreateOrUpdateDTO(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @EnumValue(enumClass = Gender.class)
        @Schema(implementation = Gender.class)
        String gender,
        @NotNull
        LocalDate birthdate,
        Long teamId,
        @EnumValue(enumClass = Country.class)
        @Schema(implementation = Country.class)
        String country) {
}
