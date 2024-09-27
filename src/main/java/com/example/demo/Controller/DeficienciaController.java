package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Form.Pessoa.DeficienciaForm;
import com.example.demo.Form.Pessoa.PessoaForm;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;
import com.example.demo.Service.DeficienciaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class DeficienciaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private DeficienciaService deficienciaService;


    @GetMapping("/deficiencia")
    public String index(){
       return "deficiencia/listar";
    }

    @GetMapping("/deficiencia/create")
    public String create(Model model){
        DeficienciaForm deficienciaForm = new DeficienciaForm();

        List<Categoria> listCategoria = categoriaRepository.findAll();
        deficienciaForm.setListCategorias(listCategoria);
        
        model.addAttribute("deficienciaForm", deficienciaForm);
        
        return "deficiencia/create";
    }
    @PostMapping("/deficiencia/create")
    public String create(@Valid DeficienciaForm deficienciaForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<Categoria> listCategoria = categoriaRepository.findAll();
        deficienciaForm.setListCategorias(listCategoria);

        model.addAttribute("deficienciaForm", deficienciaForm);
        

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/deficiencia/create";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Salvo com sucesso!");
        deficienciaService.create(deficienciaForm);
        
        return "redirect:/deficiencia";
    }
}
