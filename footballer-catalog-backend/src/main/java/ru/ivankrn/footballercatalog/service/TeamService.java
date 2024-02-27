package ru.ivankrn.footballercatalog.service;

import ru.ivankrn.footballercatalog.dto.TeamCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.TeamDTO;

import java.util.List;

public interface TeamService {

    void create(TeamCreateOrUpdateDTO team);

    TeamDTO findById(long id);

    List<TeamDTO> findAll();

    void update(long id, TeamCreateOrUpdateDTO team);

    void deleteById(long id);

}
