package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    
    public List<Deficiencia> findAll() {
        return deficienciaRepository.findAll();
    }

    
    public Deficiencia create(Deficiencia deficiencia) {
        return deficienciaRepository.save(deficiencia);
    }

    
    public Deficiencia update(Deficiencia deficiencia, Long id) {
        Optional<Deficiencia> deficienciaExistente = deficienciaRepository.findById(id);
        
        if (deficienciaExistente.isPresent()) {
            Deficiencia deficienciaAtualizada = deficienciaExistente.get();
            
            deficienciaAtualizada.setNome(deficiencia.getNome());
            deficienciaAtualizada.setCategoria(deficiencia.getCategoria());
            
            return deficienciaRepository.save(deficienciaAtualizada);
        } else {
            throw new IllegalArgumentException("Deficiência não encontrada.");
        }
    }

}