package br.com.fiap.gestao_faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gestao_faculdade.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
