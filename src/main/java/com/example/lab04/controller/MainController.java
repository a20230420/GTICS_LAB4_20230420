package com.example.lab04.controller;

import com.example.lab04.dto.ApiForm;
import com.example.lab04.entity.Api;
import com.example.lab04.entity.Equipo;
import com.example.lab04.repository.ApisRepository;
import com.example.lab04.repository.EndpointsRepository;
import com.example.lab04.repository.EquiposRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")

public class MainController {
    private final EquiposRepository equiposRepository;
    private final ApisRepository apisRepository;
    private final EndpointsRepository endpointsRepository;

    public MainController(EquiposRepository equiposRepository, ApisRepository apisRepository, EndpointsRepository endpointsRepository) {
        this.equiposRepository = equiposRepository;
        this.apisRepository = apisRepository;
        this.endpointsRepository = endpointsRepository;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("apis", apisRepository.findAllByOrderByIdDesc());
        return "list";
    }

    @GetMapping("/new")
    public String newForm(Model model){
        model.addAttribute("ApiForm", new ApiForm());
        model.addAttribute("equipos", equiposRepository.findAll());
        model.addAttribute("mode", "create");
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ApiForm form, RedirectAttributes ra, Model model){
        Equipo e=equiposRepository.findById(form.getId()).orElse(null);
        if(e==null){
            model.addAttribute("error","Debe seleccionar un equipo");
            model.addAttribute("equipos", equiposRepository.findAllByOrderByNombre());
            model.addAttribute("mode","create");
            return "form";
        }
        Api a=new Api();
        a.setNombre(form.getNombre());
        a.setVersion(form.getVersion());
        a.setEstado(form.getEstado());
        a.setEquipo(e);
        apisRepository.save(a);
        ra.addFlashAttribute("msg","API registrada correctamente");
        return "redirect:/list";
    }

}
