package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Modelo;
import br.gov.sp.fatec.repository.ModeloRepository;

@Service("segurancaModelo")
public class SegurancaModeloImpl implements SegurancaModelo{
	
	@Autowired
	private ModeloRepository modRepo;
	/**
	 * @param modRepo the modRepo to set
	 */
	public void setModRepo(ModeloRepository modRepo) {
		this.modRepo = modRepo;
	}

	@Override
	@Transactional
	public void insereModelo() {
		
		//Cadastrando Modelos
		Modelo modelo1 = new Modelo();
		modelo1.setTipo("Popular");
		modRepo.save(modelo1);
		
		Modelo modelo2 = new Modelo();
		modelo2.setTipo("esportivo");
		modRepo.save(modelo2);	
	}
	
	@Override
	@Transactional
	public void deleteModelo() {
		
		// Deleta o cadastro Modelo
		Modelo modelo1 = new Modelo();
		modelo1.setId((long) 01);
		modRepo.delete(modelo1);
		
		Modelo modelo2 = new Modelo();
		modelo2.setId((long) 02);
		modRepo.delete(modelo2);
	}
	
	@Override
	@Transactional
	public void buscaModelo() {
		// Busca modelo
		System.out.println("Resultado da busca Modelo: " + modRepo.findByTipo("Popular").getTipo());
	}
}
