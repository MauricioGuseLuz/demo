package com.example.demo.Form.Deficiencia;

import java.util.List;

import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeficienciaForm {
    @NotBlank(message = "Preencha o campo nome.")
    private String nome;

     @NotNull(message = "Qual sua categoria de deficiencia?")
    private Categoria categoria;
    private List<Categoria> listCategorias;




}
