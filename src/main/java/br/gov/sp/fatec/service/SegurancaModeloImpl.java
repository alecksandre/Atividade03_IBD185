package br.gov.sp.fatec.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Modelo;
import br.gov.sp.fatec.repository.ModeloRepository;

@Service("segurancaModelo")
public class SegurancaModeloImpl implements SegurancaModelo{
	
	@Autowired
	ModeloRepository modRepo;
	
	/**
	 * @return the modRepo
	 */
	public ModeloRepository getModRepo() {
		return modRepo;
	}
	/**
	 * @param modRepo the modRepo to set
	 */
	public void setModRepo(ModeloRepository modRepo) {
		this.modRepo = modRepo;
	}

	@Override
	public Modelo inserir(Modelo modelo) {
		return modRepo.save(modelo);
	}

	@Override
	public Modelo buscaId(Long id) {
		return modRepo.findById(id);
	}

	@Override
	public Modelo buscaTipo(String nome) {
		return modRepo.findByTipo(nome);
	}
}
