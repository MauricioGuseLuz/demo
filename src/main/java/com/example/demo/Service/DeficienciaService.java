package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Form.Pessoa.PessoaForm;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.DeficienciaRepository;
import com.example.demo.Repository.PessoaRepository;

@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    
    public Deficiencia create(DeficienciaForm deficienciaForm){
        
    Deficiencia deficiencia = new Deficiencia();

    deficiencia.setNome(deficienciaForm.getNome());
    deficiencia.setCategoria(deficienciaForm.getCategoria());

    this.deficienciaRepository.save(deficiencia);

    return deficiencia;
  }
  public Deficiencia update(DeficienciaForm deficienciaForm, Long id){
    
    Deficiencia deficiencia = this.deficienciaRepository.findById(id).orElseThrow();

    deficiencia.setNome(deficienciaForm.getNome());
    deficiencia.setCategoria(deficienciaForm.getCategoria());

    return deficiencia;


}
}