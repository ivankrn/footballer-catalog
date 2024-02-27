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
import ru.ivankrn.footballercatalog.dto.TeamCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.TeamDTO;
import ru.ivankrn.footballercatalog.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Team API", description = "API для управления данными о командах")
public class TeamController {

    private final TeamService teamService;

    @Operation(summary = "Получить все команды")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список всех команд",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = TeamDTO.class)))
                    })})
    @GetMapping
    public List<TeamDTO> getTeams() {
        return teamService.findAll();
    }

    @Operation(summary = "Получить команду по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Команда с указанным id",
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = TeamDTO.class))
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
                    description = "Если команда не найдена",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    @GetMapping("/{id}")
    public TeamDTO getTeam(@Parameter(description = "id команды") @PathVariable long id) {
        return teamService.findById(id);
    }

    @Operation(summary = "Создать команду")
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
    public void createTeam(@Parameter(description = "команда") @RequestBody @Valid TeamCreateOrUpdateDTO teamDTO) {
        teamService.create(teamDTO);
    }

    @Operation(summary = "Изменить команду")
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
                    description = "Если команда не найдена",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    @PutMapping("/{id}")
    public void updateTeam(@Parameter(description = "id команды") @PathVariable long id,
                           @Parameter(description = "измененная команда") @RequestBody @Valid
                           TeamCreateOrUpdateDTO teamDTO) {
        teamService.update(id, teamDTO);
    }

    @Operation(summary = "Удалить команду по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@Parameter(description = "id команды") @PathVariable long id) {
        teamService.deleteById(id);
    }

}