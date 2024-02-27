package ru.ivankrn.footballercatalog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ivankrn.footballercatalog.controller.error.ErrorResponse;
import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;
import ru.ivankrn.footballercatalog.service.FootballerService;

import java.util.List;

@RestController
@RequestMapping("/api/footballers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Footballer API", description = "API для управления данными о футболистах")
public class FootballerController {

    private final FootballerService footballerService;

    @Operation(summary = "Получить всех футболистов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список всех футболистов",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = FootballerDTO.class)))
                    })})
    @GetMapping
    public List<FootballerDTO> getFootballers() {
        return footballerService.findAll();
    }

    @Operation(summary = "Получить футболиста по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Футболист с указанным id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = FootballerDTO.class))
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Если некорректно указан id",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    )),
            @ApiResponse(
                    responseCode = "404",
                    description = "Если футболист не найден",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    @GetMapping("/{id}")
    public FootballerDTO getFootballer(@Parameter(description = "id футболиста") @PathVariable long id) {
        return footballerService.findById(id);
    }

    @Operation(summary = "Создать футболиста")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "При успешном создании",
                    content = @Content),
            @ApiResponse(
                    responseCode = "400",
                    description = "При ошибке валидации",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    @PostMapping
    public void createFootballer(@Parameter(description = "футболист") @RequestBody @Valid
                                 FootballerCreateOrUpdateDTO footballerDTO) {
        footballerService.create(footballerDTO);
    }

    @Operation(summary = "Изменить футболиста")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "При успешном изменении",
                    content = @Content),
            @ApiResponse(
                    responseCode = "400",
                    description = "При ошибке валидации",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    )),
            @ApiResponse(
                    responseCode = "404",
                    description = "Если футболист не найден",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    @PutMapping("/{id}")
    public void updateFootballer(@Parameter(description = "id футболиста") @PathVariable long id,
                                 @Parameter(description = "измененный футболист") @RequestBody @Valid
                                 FootballerCreateOrUpdateDTO footballerDTO) {
        footballerService.update(id, footballerDTO);
    }

    @Operation(summary = "Удалить футболиста по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFootballer(@Parameter(description = "id футболиста") @PathVariable long id) {
        footballerService.deleteById(id);
    }

}