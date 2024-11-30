package com.kemenag.sitular.services;

import com.kemenag.sitular.models.Pegawai;

import java.util.List;
import java.util.Optional;

public interface PegawaiService {
    void save(Pegawai pegawai);
    Optional<Pegawai> getById(Long id);
    List<Pegawai> getAll();
    void update(Pegawai pegawai, Long id);
    void removeById(Long id);

}
