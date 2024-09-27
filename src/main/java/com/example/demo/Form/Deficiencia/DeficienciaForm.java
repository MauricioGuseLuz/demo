package com.example.demo.Form.Deficiencia;

import java.util.List;

import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeficienciaForm {

    
    
    @NotBlank(message = "Preencha o campo nome.")
    private String nome;
    
    @NotNull(message = "Qual a categoria da sua deficiencia.")
    private Categoria categoria;
    private List<Categoria> listCategorias;

    public DeficienciaForm(Deficiencia deficiencia){
        this.nome = deficiencia.getNome();
        this.categoria = deficiencia.getCategoria();
        

    }


}
