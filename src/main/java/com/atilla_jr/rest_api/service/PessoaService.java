package com.atilla_jr.rest_api.service;

import com.atilla_jr.rest_api.DTO.PessoaDTO;
import com.atilla_jr.rest_api.domain.Pessoa;
import com.atilla_jr.rest_api.exception.ObjectNotFoundException;
import com.atilla_jr.rest_api.repository.PessoaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repo;

  public Iterable<Pessoa> findAll() {
    return repo.findAll();
  }

  public Pessoa findById(String id) {
    Optional<Pessoa> obj = repo.findById(id);
    return obj.orElseThrow(() ->
      new ObjectNotFoundException("Objeto não encontrado")
    );
  }

  public Pessoa save(Pessoa obj) {
    return repo.save(obj);
  }

  public void delete(String id) {
    findById(id);
    repo.deleteById(id);
  }

  public Pessoa update(Pessoa obj) {
    Pessoa newObj = repo.findById(obj.getId().toString()).get();

    updateData(newObj, obj);
    return repo.save(obj);
  }

  private void updateData(Pessoa newObj, Pessoa obj) {
    if (!(obj.getName() != null)) {
      obj.setName(newObj.getName());
    }

    if (!(obj.getSobrenome() != null)) {
      obj.setSobrenome(newObj.getSobrenome());
    }

    if (!(obj.getData_nascimento() != null)) {
      obj.setData_nascimento(newObj.getData_nascimento());
    }
    if (!(obj.getGenero() != null)) {
      obj.setGenero(newObj.getGenero());
    }
    if (!(obj.getInscricao() != null)) {
      obj.setInscricao(newObj.getInscricao());
    }
  }

  public Pessoa fromDTO(PessoaDTO objDto) {
    return new Pessoa(
      objDto.getId(),
      objDto.getName(),
      objDto.getSobrenome(),
      objDto.getGenero(),
      objDto.getData_nascimento(),
      objDto.getIncricao()
    );
  }
}
