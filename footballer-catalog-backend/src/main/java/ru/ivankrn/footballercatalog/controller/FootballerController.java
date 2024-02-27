package ru.ivankrn.footballercatalog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;
import ru.ivankrn.footballercatalog.service.FootballerService;

import java.util.List;

@RestController
@RequestMapping("/api/footballers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class FootballerController {

    private final FootballerService footballerService;

    @GetMapping
    public List<FootballerDTO> getFootballers() {
        return footballerService.findAll();
    }

    @GetMapping("/{id}")
    public FootballerDTO getFootballer(@PathVariable long id) {
        return footballerService.findById(id);
    }

    @PostMapping
    public void createFootballer(@RequestBody @Valid FootballerCreateOrUpdateDTO footballerDTO) {
        footballerService.create(footballerDTO);
    }

    @PutMapping("/{id}")
    public void updateFootballer(@PathVariable long id, @RequestBody @Valid FootballerCreateOrUpdateDTO footballerDTO) {
        footballerService.update(id, footballerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFootballer(@PathVariable long id) {
        footballerService.deleteById(id);
    }

}
