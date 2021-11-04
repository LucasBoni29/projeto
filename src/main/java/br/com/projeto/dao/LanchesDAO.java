package br.com.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.beans.Lanches;

public interface LanchesDAO extends CrudRepository<Lanches, Integer>{

}
