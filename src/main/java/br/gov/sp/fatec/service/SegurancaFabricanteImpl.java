package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Fabricante;
import br.gov.sp.fatec.repository.FabricanteRepository;

@Service("segurancaFabricanteService")
public class SegurancaFabricanteImpl implements SegurancaFabricanteService{
	
	@Autowired
	private FabricanteRepository fabricanteRepo;
	/**
	 * @param fabricanteRepo the fabricanteRepo to set
	 */
	public void setFabricanteRepo(FabricanteRepository fabricanteRepo) {
		this.fabricanteRepo = fabricanteRepo;
	}

	@Override
	@Transactional
	public void fabricanteTransacao() {
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNome("Renault");
		fabricanteRepo.save(fabricante1);
		//
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("Lamborghini");
		fabricanteRepo.save(fabricante2);
		//
		Fabricante fabricante3 = new Fabricante();
		fabricante3.setNome("GM");
		fabricanteRepo.save(fabricante3);
	}
		
	@Override
	@Transactional
	public void deleteFabricante() {
		// Delete fabricante
		
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setId((long) 01);
		fabricanteRepo.delete(fabricante1);
		//
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setId((long) 02);
		fabricanteRepo.delete(fabricante2);
		//
		Fabricante fabricante3 = new Fabricante();
		fabricante3.setId((long) 03);
		fabricanteRepo.delete(fabricante3);
	}
	
	@Override
	@Transactional
	public void buscaFabricante() {
		// busca fabricante
		System.out.println("Resultado da busca Fabricante: " + fabricanteRepo.findByNome("Renault").getNome());
		
	}
}
