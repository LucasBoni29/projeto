package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.beans.Lanches;
import br.com.projeto.dao.LanchesDAO;

@RestController
public class LanchesController {
	
	@Autowired //Cria o objeto sem aquele "= NEW LanchesDAO()"
	private LanchesDAO dao;
	
	//getAll() --> Pegar tudo da tabela. Retorna um List -vetor-, vindo da classe Lanches e seu type é ResponseEntity -na verdade é um objeto- 
	@GetMapping("/lanche")
	public ResponseEntity<List<Lanches>> getAll(){ 
		//Array list = Guardar várias coisas. FindAll() --> Pega tudo e faz uma lista organizada com linhas e colunas, sendo armazenada em List que é um Array List que vem de Lanches e Lanches guarda os dados do BD.
		List<Lanches> list = (List<Lanches>)dao.findAll();
		
		if(list.size()==0) {
			return ResponseEntity.status(404).build(); //Ele constrói o erro 404 -força um erro-
		}
		return ResponseEntity.ok(list); // Vai retornar OK se tiver algo cadastrado no BD.
		
		//O Controller está indo buscar no BD. O Controller está pegando os Dados do DAO e está armazenando em uma list, essa list está levando os dados pro Lanches, o Lanches transita entre as classes, assim deixando os dados no DAO. O DAO é uma interface, então vai mostrar. 
	}
}
