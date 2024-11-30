package com.kemenag.sitular.services;

import java.util.List;
import java.util.Optional;

import com.kemenag.sitular.models.Ajuan;

public interface AjuanService {
    void save(Ajuan ajuan);
    Optional<Ajuan> getById(Long id);
    List<Ajuan> getByStatusAjuan(String status);
    List<Ajuan> getAllAjuan();
    void delete(Long id);
}
