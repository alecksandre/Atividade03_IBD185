package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.FabricanteRepository;
import br.gov.sp.fatec.repository.ModeloRepository;

@Service("segurancaCarro")
public class SegurancaCarroImpl implements SegurancaCarro{
	
	@Autowired
	private CarroRepository carRepo;
	@Autowired 
	private FabricanteRepository fabRepo;
	@Autowired
	private ModeloRepository modRepo;
	
	/**
	 * @param carroRepo the carroRepo to set
	 */
	public void setCarRepo(CarroRepository carRepo) {
		this.carRepo = carRepo;
	}

	/**
	 * @param fabricanteRepo the fabricanteRepo to set
	 */
	public void setFabRepo(FabricanteRepository fabRepo) {
		this.fabRepo = fabRepo;
	}

	/**
	 * @param modeloRepo the modeloRepo to set
	 */
	public void setModRepo(ModeloRepository modRepo) {
		this.modRepo = modRepo;
	}

	@Override
	@Transactional
	public void insereCarro() {
		Carro carro1 = new Carro();
		carro1.setNome("Clio");
		carro1.setPreco(100000);
		carro1.setFabricante(fabRepo.findById((long) 01));
		carro1.setModelo(modRepo.findById((long) 01));
		carRepo.save(carro1);
		
		Carro carro2 = new Carro();
		carro2.setNome("Corsa");
		carro2.setPreco(10000);
		carro2.setFabricante(fabRepo.findById((long) 03));
		carro2.setModelo(modRepo.findById((long) 01));
		carRepo.save(carro2);
	}
	
	@Override
	@Transactional
	public void deleteCarro() {
		// Delete carro
		Carro carro1 = new Carro();
		carro1.setId((long) 01);
		carRepo.delete(carro1);
		
		Carro carro2 = new Carro();
		carro2.setId((long) 02);
		carRepo.delete(carro2);
	}
	
	@Override
	@Transactional	
	public void buscaCarro() {
		//consulta carros 
		System.out.println("Busca simples pelo nome");
		System.out.println("Resultado da busca Carro:" +carRepo.findByNome("Clio").getNome());
		//consulta carros  
		System.out.println("Busca por Referência de nome");
		for(Carro todos: carRepo.buscaCarro("c")){
			System.out.println("Carro:" + todos.getNome() + " Preço: " + todos.getPreco());
		}
	}
}
