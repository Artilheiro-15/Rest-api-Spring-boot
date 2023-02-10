// package com.atilla_jr.rest_api.config;

// import com.atilla_jr.rest_api.domain.Pessoa;
// import com.atilla_jr.rest_api.repository.PessoaRepository;
// import java.util.Arrays;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class Instantiation implements CommandLineRunner {

//   @Autowired
//   private PessoaRepository PessoaRepository;

//   @Override
//   public void run(String... args) throws Exception {
//     //com isso aqui eu Limpo os usuarios do banco de dados
//     PessoaRepository.deleteAll();

//     Pessoa Atilla = new Pessoa(1, "Atilla Brown", "Atilla@gmail.com");
//     Pessoa maria = new Pessoa(2, "maria Brown", "maria@gmail.com");
//     Pessoa alex = new Pessoa(3, "alex Green", "alex@gmail.com");

//     //Com isso aqui eu vo salvar os usuarios automaticamente la no banco de dados
//     PessoaRepository.saveAll(Arrays.asList(Atilla, maria, alex));
//   }
// }
