package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Fabricante;

public interface FabricanteRepository extends CrudRepository<Fabricante, Long>{
	
	public Fabricante findById(Long id);
	
	public Fabricante findByNome(String nome);
	
	@Query("select u from Fabricante u where u.nome like %?1%")
	public List<Fabricante> buscaFabricante(String nome);
	
}
