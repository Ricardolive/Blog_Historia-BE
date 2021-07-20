package br.com.blogHistoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blogHistoria.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

}
