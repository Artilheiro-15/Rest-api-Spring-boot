package com.atilla_jr.rest_api.resources;

import com.atilla_jr.rest_api.DTO.PessoaDTO;
import com.atilla_jr.rest_api.domain.Pessoa;
import com.atilla_jr.rest_api.service.PessoaService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

  @Autowired
  private PessoaService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<PessoaDTO>> findAll() {
    List<Pessoa> list = (List<Pessoa>) service.findAll();
    List<PessoaDTO> listDto = list
      .stream()
      .map(x -> new PessoaDTO(x))
      .collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<PessoaDTO> findById(@PathVariable String id) {
    Pessoa obj = service.findById(id);
    return ResponseEntity.ok().body(new PessoaDTO(obj));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> save(@RequestBody PessoaDTO objDto) {
    Pessoa obj = service.fromDTO(objDto);
    obj = service.save(obj);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(obj.getId())
      .toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(
    @RequestBody PessoaDTO objDto,
    @PathVariable Integer id
  ) {
    Pessoa obj = service.fromDTO(objDto);
    obj.setId(id);
    obj = service.update(obj);
    return ResponseEntity.noContent().build();
  }
}