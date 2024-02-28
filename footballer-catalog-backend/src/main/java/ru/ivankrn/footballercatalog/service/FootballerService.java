package ru.ivankrn.footballercatalog.service;

import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;

import java.util.List;

public interface FootballerService {

    FootballerDTO create(FootballerCreateOrUpdateDTO footballer);

    FootballerDTO findById(long id);

    List<FootballerDTO> findAll();

    FootballerDTO update(long id, FootballerCreateOrUpdateDTO team);

    void deleteById(long id);

}
