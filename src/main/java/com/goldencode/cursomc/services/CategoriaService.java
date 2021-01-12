package com.goldencode.cursomc.services;

import com.goldencode.cursomc.domain.Categoria;
import com.goldencode.cursomc.repositories.CategoriaRepository;
import com.goldencode.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
    
    public Categoria insert(Categoria obj) {
    	//Para garantir que o id esteja null
    	obj.setId(null);
    	return repo.save(obj);
    }

}
