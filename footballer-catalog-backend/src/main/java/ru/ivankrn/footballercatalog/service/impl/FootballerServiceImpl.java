package ru.ivankrn.footballercatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivankrn.footballercatalog.controller.error.NotFoundException;
import ru.ivankrn.footballercatalog.database.model.Footballer;
import ru.ivankrn.footballercatalog.database.repository.FootballerRepository;
import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;
import ru.ivankrn.footballercatalog.dto.mapper.FootballerMapper;
import ru.ivankrn.footballercatalog.service.FootballerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerServiceImpl implements FootballerService {

    private final FootballerMapper mapper;
    private final FootballerRepository repository;

    @Override
    public FootballerDTO create(FootballerCreateOrUpdateDTO footballer) {
        return mapper.convertToDTO(repository.save(mapper.convertFromDTO(footballer)));
    }

    @Override
    public FootballerDTO findById(long id) {
        return repository.findById(id).map(mapper::convertToDTO).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<FootballerDTO> findAll() {
        return repository.findAll().stream().map(mapper::convertToDTO).toList();
    }

    @Override
    public FootballerDTO update(long id, FootballerCreateOrUpdateDTO footballerDTO) {
        Footballer footballer = repository.findById(id).orElseThrow(NotFoundException::new);
        mapper.updateFromDTO(footballerDTO, footballer);
        return mapper.convertToDTO(repository.save(footballer));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
