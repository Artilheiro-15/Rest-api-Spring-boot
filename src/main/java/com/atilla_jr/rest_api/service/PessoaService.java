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
    Pessoa newObj = repo.findById(obj.getId());
    updateData(newObj, obj);
    return repo.save(newObj);
  }

  private void updateData(Pessoa newObj, Pessoa obj) {
    newObj.setName(obj.getName());
    newObj.setSobrenome(obj.getSobrenome());
    newObj.setGenero(obj.getGenero());
    newObj.setData_nascimento(obj.getData_nascimento());
    newObj.setInscricao(obj.getInscricao());
    newObj.setCreated_at(obj.getCreated_at());
    newObj.setUpdated_at(obj.getUpdated_at());
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
