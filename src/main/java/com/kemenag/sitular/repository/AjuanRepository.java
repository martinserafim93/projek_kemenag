package com.kemenag.sitular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kemenag.sitular.models.Ajuan;

@Repository
public interface AjuanRepository extends JpaRepository<Ajuan, Long> {

    List<Ajuan> findByStatus(String status);
    
} 