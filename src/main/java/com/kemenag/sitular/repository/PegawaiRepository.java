package com.kemenag.sitular.repository;

import com.kemenag.sitular.models.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {

}
