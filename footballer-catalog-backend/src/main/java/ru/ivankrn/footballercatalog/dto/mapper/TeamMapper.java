package ru.ivankrn.footballercatalog.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.ivankrn.footballercatalog.database.model.Team;
import ru.ivankrn.footballercatalog.dto.TeamCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.TeamDTO;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team convertFromDTO(TeamCreateOrUpdateDTO teamDTO);

    TeamDTO convertToDTO(Team team);

    void updateFromDTO(TeamCreateOrUpdateDTO teamDTO, @MappingTarget Team team);

}
