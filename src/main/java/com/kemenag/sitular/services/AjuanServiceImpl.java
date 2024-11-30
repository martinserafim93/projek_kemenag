package com.kemenag.sitular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kemenag.sitular.models.Ajuan;
import com.kemenag.sitular.repository.AjuanRepository;

@Service
public class AjuanServiceImpl implements AjuanService {
    private final AjuanRepository repo;

    public AjuanServiceImpl(AjuanRepository repository) {
        this.repo = repository;
    }

    @Override
    public void save(Ajuan ajuan) {
        this.repo.save(ajuan);
    }

    @Override
    public Optional<Ajuan> getById(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public List<Ajuan> getByStatusAjuan(String status) {
        return this.repo.findByStatus(status);
    }

    @Override
    public List<Ajuan> getAllAjuan() {
        return this.repo.findAll();
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    
    
}
