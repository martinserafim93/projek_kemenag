package com.kemenag.sitular.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kemenag.sitular.models.Ajuan;
import com.kemenag.sitular.models.Pegawai;
import com.kemenag.sitular.services.AjuanServiceImpl;
import com.kemenag.sitular.services.PegawaiServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ajuan")
public class AjuanController {
    private final AjuanServiceImpl service;
    private final PegawaiServiceImpl pegawaiService;

    public AjuanController(AjuanServiceImpl ajuanService, PegawaiServiceImpl pegawaiService) {
        this.service = ajuanService;
        this.pegawaiService = pegawaiService;
    }

    @GetMapping("/create")
    public String showFormAjuan(Model model) {
        model.addAttribute("ajuan", new Ajuan());
        model.addAttribute("dataPegawai", pegawaiService.getAll());
        model.addAttribute("page", "IB");
        model.addAttribute("form", true);

        return "form-ajuan";
    }

    @PostMapping("/save")
    public String saveAjuan(@Valid Ajuan ajuan, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("page", "IB");
            model.addAttribute("form", true);
            model.addAttribute("response", "failed");
            return "form-ajuan";
        }
        
        try {
            // Pegawai peg = pegawaiService.getById(pegawai.getId()).get();
            // ajuan.setPegawai(peg);
            model.addAttribute("page", "IB");
            model.addAttribute("form", true);
            model.addAttribute("response", "success");

            service.save(ajuan);
        } catch(Exception ex) {
            model.addAttribute("message", ex.getMessage());
        }

        return "form-ajuan";
    }
}
