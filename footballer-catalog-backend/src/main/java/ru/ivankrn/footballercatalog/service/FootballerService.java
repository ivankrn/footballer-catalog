package ru.ivankrn.footballercatalog.service;

import ru.ivankrn.footballercatalog.dto.FootballerCreateOrUpdateDTO;
import ru.ivankrn.footballercatalog.dto.FootballerDTO;

import java.util.List;

public interface FootballerService {

    void create(FootballerCreateOrUpdateDTO footballer);

    FootballerDTO findById(long id);

    List<FootballerDTO> findAll();

    void update(long id, FootballerCreateOrUpdateDTO team);

    void deleteById(long id);

}
