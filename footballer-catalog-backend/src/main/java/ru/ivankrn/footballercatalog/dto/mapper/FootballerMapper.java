package ru.ivankrn.footballercatalog.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ivankrn.footballercatalog.database.model.Country;
import ru.ivankrn.footballercatalog.database.model.Footballer;
import ru.ivankrn.footballercatalog.database.model.Gender;
import ru.ivankrn.footballercatalog.database.repository.TeamRepository;
import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;

@Mapper(componentModel = "spring", uses = TeamRepository.class)
public abstract class FootballerMapper {

    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public abstract FootballerDTO convertToDTO(Footballer footballer);

    public Footballer convertFromDTO(FootballerCreateOrUpdateDTO footballerDTO) {
        if (footballerDTO == null) {
            return null;
        }
        Footballer footballer = new Footballer();
        footballer.setFirstName(footballerDTO.firstName());
        footballer.setLastName(footballerDTO.lastName());
        if (footballerDTO.gender() != null) {
            footballer.setGender(Enum.valueOf(Gender.class, footballerDTO.gender()));
        }
        footballer.setBirthdate(footballerDTO.birthdate());
        if (footballerDTO.teamId() != null) {
            footballer.setTeam(teamRepository.getReferenceById(footballerDTO.teamId()));
        }
        if (footballerDTO.country() != null) {
            footballer.setCountry(Enum.valueOf(Country.class, footballerDTO.country()));
        }
        return footballer;
    }

    public void updateFromDTO(FootballerCreateOrUpdateDTO footballerDTO, Footballer footballer) {
        if (footballerDTO == null) {
            return;
        }
        footballer.setFirstName(footballerDTO.firstName());
        footballer.setLastName(footballerDTO.lastName());
        if (footballerDTO.gender() != null) {
            footballer.setGender(Enum.valueOf(Gender.class, footballerDTO.gender()));
        } else {
            footballer.setGender(null);
        }
        footballer.setBirthdate(footballerDTO.birthdate());
        if (footballerDTO.teamId() != null) {
            footballer.setTeam(teamRepository.getReferenceById(footballerDTO.teamId()));
        } else {
            footballer.setTeam(null);
        }
        if (footballerDTO.country() != null) {
            footballer.setCountry(Enum.valueOf(Country.class, footballerDTO.country()));
        } else {
            footballer.setCountry(null);
        }
    }

}
