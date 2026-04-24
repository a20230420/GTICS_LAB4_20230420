package com.example.lab04.controller;

import com.example.lab04.entity.Api;
import com.example.lab04.entity.Equipo;
import com.example.lab04.repository.ApisRepository;
import com.example.lab04.repository.EndpointsRepository;
import com.example.lab04.repository.EquiposRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

}
