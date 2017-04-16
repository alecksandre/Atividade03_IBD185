package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Modelo;

public interface ModeloRepository extends CrudRepository<Modelo, Long>{
	
	public Modelo findById(Long id);
	
	public Modelo findByTipo(String tipo);
	
	
	@Query("select u from Modelo u where u.tipo like %?1%")
	public List<Modelo> buscaModelo(String tipo);
	

}
