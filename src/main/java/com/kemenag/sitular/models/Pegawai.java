package com.kemenag.sitular.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pegawai")
@Getter
@Setter
public class Pegawai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Required field!")
    @Column(name = "nip_p", length = 18, nullable = false)
    @Size(max = 18, message ="NIP tidak boleh lebih dari 18 angka!")
    @Min(value = 18, message = "NIP harus 18 angka!")
    private String nip;

    @NotNull
    @NotEmpty(message = "Nama tidak boleh kosong!")
    @Column(name = "nama_l", nullable = false)
    private String nama;

    @NotNull
    @NotEmpty(message = "Tempat lahir tidak boleh kosong!")
    @Column(name = "tempat_tl", nullable = false)
    private String tempatL;

    @NotNull
    @NotEmpty(message = "Tanggal lahir tidak boleh kosong!")
    @Column(name = "tgl_l", nullable = false)
    private String tanggalLahir;

    @NotNull
    @NotEmpty(message = "Pangkat/Golongan tidak boleh kosong!")
    @Column(name = "pangkat_gol", nullable = false)
    private String pangkatGol;

    @NotNull
    @NotEmpty(message = "Pendidikan tidak boleh kosong!")
    @Column(name = "pendidikan_p", nullable = false)
    private String pendidikan;

    @NotNull
    @NotEmpty(message = "Jabatan tidak boleh kosong!")
    @Column(name = "jabatan_p", nullable = false)
    private String jabatan;

    @NotNull
    @NotEmpty(message = "Unit kerja tidak boleh kosong!")
    @Column(name = "unit_kerja_p", nullable = false)
    private String unitKerja;

    @NotNull
    @NotEmpty(message = "Sub unit kerja tidak boleh kosong!")
    @Column(name = "sub_unit_k", nullable = false)
    private String subUnitKerja;
}
