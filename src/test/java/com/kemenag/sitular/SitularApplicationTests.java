package com.kemenag.sitular;

import com.kemenag.sitular.models.Pegawai;
import com.kemenag.sitular.services.PegawaiServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SitularApplicationTests {

	@Autowired
	PegawaiServiceImpl service;

	@Test
	void contextLoads() {
	}

	@Test
	void saveData() {
		Pegawai pegawai = new Pegawai();
		pegawai.setNama("Jhon");
		pegawai.setNip("123456789");
		pegawai.setTanggalLahir("Sat");
		pegawai.setTempatL("Sun");
		pegawai.setJabatan("123456789");
		pegawai.setPendidikan("123456789");
		pegawai.setPangkatGol("123456789");
		pegawai.setUnitKerja("123456789");
		pegawai.setSubUnitKerja("1234567");
		service.save(pegawai);
		System.out.println("Data berhasil disimpan!!!");
	}

	@Test
	void loadData() {

		List<Pegawai> data = service.getAll();

		if(data.size() > 0) {
			System.out.println("DATA ADA BOS!");
			data.forEach(pegawai -> {
				System.out.println(pegawai.getNama());
			});
		} else {
			System.out.println("Data kosong bos!!!");
		}
	}

}
