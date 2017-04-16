package br.gov.sp.fatec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long>{
	
	public Carro findById(Long id);
	
	public Carro findByNome(String nome);
	
	@Query("select u from Carro u where u.nome like %?1%")
	public List<Carro> buscaCarro(String nome);
	

}
