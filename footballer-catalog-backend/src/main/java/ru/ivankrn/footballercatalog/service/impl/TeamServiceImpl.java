package ru.ivankrn.footballercatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivankrn.footballercatalog.controller.error.NotFoundException;
import ru.ivankrn.footballercatalog.database.model.Team;
import ru.ivankrn.footballercatalog.database.repository.TeamRepository;
import ru.ivankrn.footballercatalog.dto.TeamCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.TeamDTO;
import ru.ivankrn.footballercatalog.dto.mapper.TeamMapper;
import ru.ivankrn.footballercatalog.service.TeamService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamMapper mapper;
    private final TeamRepository repository;

    @Override
    public void create(TeamCreateOrUpdateDTO team) {
        repository.save(mapper.convertFromDTO(team));
    }

    @Override
    public TeamDTO findById(long id) {
        return repository.findById(id).map(mapper::convertToDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<TeamDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public void update(long id, TeamCreateOrUpdateDTO teamDTO) {
        Team team = repository.findById(id).orElseThrow(NotFoundException::new);
        mapper.updateFromDTO(teamDTO, team);
        repository.save(team);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
