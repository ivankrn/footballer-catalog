package ru.ivankrn.footballercatalog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ivankrn.footballercatalog.dto.TeamCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.TeamDTO;
import ru.ivankrn.footballercatalog.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<TeamDTO> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeam(@PathVariable long id) {
        return teamService.findById(id);
    }

    @PostMapping
    public void createTeam(@RequestBody @Valid TeamCreateOrUpdateDTO teamDTO) {
        teamService.create(teamDTO);
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable long id, @RequestBody @Valid TeamCreateOrUpdateDTO teamDTO) {
        teamService.update(id, teamDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable long id) {
        teamService.deleteById(id);
    }

}
