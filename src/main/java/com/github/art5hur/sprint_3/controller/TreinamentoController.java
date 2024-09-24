package com.github.art5hur.sprint_3.controller;

import com.github.art5hur.sprint_3.controller.dto.FormTreinamento;
import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;
import com.github.art5hur.sprint_3.lov.ListOfValueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("treinamentos")
public class TreinamentoController {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Autowired
    private ListOfValueBuilder listOfValueBuilder;

    // Exibe a lista de treinamentos
    @GetMapping()
    public String list(Model model) {
        List<Treinamento> treinamentos = treinamentoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        model.addAttribute("treinamentos", treinamentos);
        return "treinamento/list";
    }

    // Salva um novo treinamento
    @PostMapping("save")
    public String save(@ModelAttribute FormTreinamento formTreinamento) {
        Treinamento treinamento = formTreinamento.toModel();
        treinamentoRepository.save(treinamento);
        return "redirect:/treinamentos";
    }

    // Exibe o formulário para adicionar um novo treinamento
    @GetMapping("add")
    public String create(Model model) {
        model.addAttribute("treinamento", new FormTreinamento());
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());  // Para listar as áreas do treinamento
        return "treinamento/form";
    }

    // Exibe o formulário para editar um treinamento existente
    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Treinamento treinamento = treinamentoRepository.findById(id).orElse(new Treinamento());
        model.addAttribute("treinamento", new FormTreinamento().toForm(treinamento));
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());  // Para listar as áreas do treinamento
        return "treinamento/form";
    }

    // Deleta um treinamento pelo ID
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        treinamentoRepository.deleteById(id);
        return "redirect:/treinamentos";
    }
}
