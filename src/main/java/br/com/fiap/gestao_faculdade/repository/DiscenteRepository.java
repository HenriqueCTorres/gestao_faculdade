package br.com.fiap.gestao_faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gestao_faculdade.model.Discente;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente,Long>{

}
