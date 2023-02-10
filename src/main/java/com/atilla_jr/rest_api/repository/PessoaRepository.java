package com.atilla_jr.rest_api.repository;

import com.atilla_jr.rest_api.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, String> {
  Pessoa findById(Integer id);
}
