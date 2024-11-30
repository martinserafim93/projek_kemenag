package com.kemenag.sitular.services;

import com.kemenag.sitular.models.Pegawai;
import com.kemenag.sitular.repository.PegawaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PegawaiServiceImpl implements PegawaiService{
    private final PegawaiRepository pegawaiRepository;

    public PegawaiServiceImpl(PegawaiRepository pegawaiRepository) {
        this.pegawaiRepository = pegawaiRepository;
    }

    @Override
    public void save(Pegawai pegawai) {
        this.pegawaiRepository.save(pegawai);
    }

    @Override
    public Optional<Pegawai> getById(Long id) {
        return this.pegawaiRepository.findById(id);
    }

    @Override
    public List<Pegawai> getAll() {
        return this.pegawaiRepository.findAll();
    }

    @Override 
    public void update(Pegawai pegawai, Long id) {
       Optional<Pegawai> dataPegawai = this.pegawaiRepository.findById(id);

        if(dataPegawai.isPresent()) {
            dataPegawai.get().setId(pegawai.getId());
            dataPegawai.get().setNip(pegawai.getNip());
            dataPegawai.get().setNama(pegawai.getNama());
            dataPegawai.get().setTempatL(pegawai.getTempatL());
            dataPegawai.get().setTanggalLahir(pegawai.getTanggalLahir());
            dataPegawai.get().setPangkatGol(pegawai.getPangkatGol());
            dataPegawai.get().setPendidikan(pegawai.getPendidikan());
            dataPegawai.get().setJabatan(pegawai.getJabatan());
            dataPegawai.get().setUnitKerja(pegawai.getUnitKerja());
            dataPegawai.get().setSubUnitKerja(pegawai.getSubUnitKerja());

            this.pegawaiRepository.save(dataPegawai.get());
        }
    }

    @Override
    public void removeById(Long id) {
        this.pegawaiRepository.deleteById(id);
    }
}
