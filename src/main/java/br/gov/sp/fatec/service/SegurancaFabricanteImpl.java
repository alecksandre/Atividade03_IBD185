package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.gov.sp.fatec.model.Fabricante;
import br.gov.sp.fatec.repository.FabricanteRepository;

@Service("segurancaFabricanteService")
public class SegurancaFabricanteImpl implements SegurancaFabricanteService{

	@Autowired
	private FabricanteRepository fabRepo;
	
	/**
	 * @return the fabRepo
	 */
	public FabricanteRepository getFabRepo() {
		return fabRepo;
	}

	/**
	 * @param fabRepo the fabRepo to set
	 */
	public void setFabRepo(FabricanteRepository fabRepo) {
		this.fabRepo = fabRepo;
	}

	@Override
	public Fabricante inserir(Fabricante fabricante) {
		System.out.println(fabricante.getNome());
		return fabRepo.save(fabricante);
	}

	@Override
	public Fabricante buscarFabricante(String nome) {
		return fabRepo.findByNome(nome);
	}

	@Override
	public Fabricante buscarId(Long id) {
		return fabRepo.findById(id);
	}

	@Override
	public List<Fabricante> buscarTodos() {
		List<Fabricante> busca = new ArrayList<Fabricante>();
		for(Fabricante fabricante: fabRepo.findAll()){
			busca.add(fabricante);
		}
		
		return busca;
	}
}
