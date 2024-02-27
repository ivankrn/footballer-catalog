package ru.ivankrn.footballercatalog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Каталог футболистов 3.0",
                description = "Документация API для каталога футболистов."
        )
)
public class OpenAPIConfiguration {
}
