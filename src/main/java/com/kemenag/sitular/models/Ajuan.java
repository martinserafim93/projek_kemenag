package com.kemenag.sitular.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ajuanIB")
@Getter
@Setter
public class Ajuan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotEmpty(message = "Pendidikan tidak boleh kosong!")
    @Column(name = "jenjang_pendidikan", nullable = false)
    private String jenjangPendidikan;

    @NotNull
    @NotEmpty(message = "Nama Program Studi tidak boleh kosong!")
    @Column(name = "nama_prodi", nullable = false)
    private String namaProdi;

    @NotNull
    @NotEmpty(message = "Nama Falkutas tidak boleh kosong!")
    @Column(name = "nama_falkutas", nullable = false)
    private String namaFalkutas;

    @NotNull
    @NotEmpty(message = "Nama Universitas tidak boleh kosong!")
    @Column(name = "nama_universitas", nullable = false)
    private String namaUniversitas;

    @NotNull
    @NotEmpty(message = "Studi Konsentrasi tidak boleh kosong!")
    @Column(name = "studi_konsentrasi", nullable = false)
    private String studiKonsentrasi;

    @NotNull 
    @NotEmpty(message = "Link Surat Permohonan tidak boleh kosong!")
    @Column(name = "surat_permohonan", nullable = false)
    private String suratPermohonan;

    @NotNull 
    @NotEmpty(message = "Link Jadwal Kuliah tidak boleh kosong!")
    @Column(name = "jadwal_kuliah", nullable = false)
    private String jadwalKuliah;

    @NotNull 
    @NotEmpty(message = "Link Akreditasi Prodi tidak boleh kosong!")
    @Column(name = "akreditasi_prodi", nullable = false)
    private String akreditasiProdi;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull 
    @NotEmpty(message = "Link Surat Diterima Kampus tidak boleh kosong!")
    @Column(name = "surat_diterima", nullable = false)
    private String suratDiterima;

    @NotNull 
    @NotEmpty(message = "Tanggal diterima tidak boleh kosong!")
    @Column(name = "tgl_diterima", nullable = false)
    private String tglDiterima;

    @NotNull
    @NotEmpty(message = "Nama atasan tidak boleh kosong!")
    @Column(name = "nama_atasan", nullable = false)
    private String namaAtasan;


    // relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pegawai_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Pegawai pegawai;



}
