package com.kemenag.sitular.controllers;

import com.kemenag.sitular.models.Pegawai;
import com.kemenag.sitular.services.PegawaiServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pegawai")
public class PegawaiController {
    final private PegawaiServiceImpl service;

    public PegawaiController(PegawaiServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String showFormCreatePegawai(Model model) {
        model.addAttribute("pegawai", new Pegawai());
        model.addAttribute("page", "pegawai");
        model.addAttribute("daftar", true);
        return "form-pegawai";
    }

    @PostMapping("/save")
    public String savePegawai(@Valid Pegawai pegawai, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("page", "pegawai");
            model.addAttribute("daftar", true);
            model.addAttribute("response", "failed");
            return "form-pegawai";
        }

        try {
            model.addAttribute("page", "pegawai");
            model.addAttribute("daftar", true);
            model.addAttribute("response", "success");

            service.save(pegawai);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "form-pegawai";
    }

    @GetMapping("/show")
    public String showPegawai(Model model) {
        try {
            List<Pegawai> dataPegawai = service.getAll();

            model.addAttribute("page", "pegawai");
            model.addAttribute("dataPegawai", true);
            model.addAttribute("data", dataPegawai);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "table-pegawai";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public Pegawai getPegawai(@PathVariable("id") Long id) {
        Pegawai pegawai = service.getById(id).orElseThrow(() -> new IllegalArgumentException(
                "Data pegawai id: " + id + " tidak ditemukan"));

        return pegawai;
    }

    @PostMapping("/update")
    public String updatePegawai(@Valid Pegawai pegawai, BindingResult result, 
    RedirectAttributes redirect) {
        if (result.hasErrors()) {
            redirect.addFlashAttribute("page", "pegawai");
            redirect.addFlashAttribute("dataPegawai", true);
            redirect.addFlashAttribute("response", "failed");

            return "redirect:/pegawai/show";
        }

        try {
            redirect.addFlashAttribute("page", "pegawai");
            redirect.addFlashAttribute("dataPegawai", true);
            redirect.addFlashAttribute("response", "success");

            service.update(pegawai, pegawai.getId());

        } catch (Exception e) {
            redirect.addFlashAttribute("response", "failed");
            redirect.addAttribute("message", e.getMessage());
        }

        return "redirect:/pegawai/show";
    }

    @GetMapping("/delete/{id}")
    public String deletePegawai(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        try {
            redirectAttributes.addFlashAttribute("page", "pegawai");
            redirectAttributes.addFlashAttribute("dataPegawai", true);
            redirectAttributes.addFlashAttribute("response", "success");
            
            service.removeById(id);

        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("response", "failed");
            redirectAttributes.addAttribute("message", e.getMessage());
        }  
       
        return "redirect:/pegawai/show";
    }

}
