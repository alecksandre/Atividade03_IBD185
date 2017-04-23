package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.repository.CarroRepository;


@Service("segurancaCarro")
public class SegurancaCarroImpl implements SegurancaCarro{
	
	@Autowired
	private CarroRepository carRepo;
	
	/**
	 * @return the carRepo
	 */
	public CarroRepository getCarRepo() {
		return carRepo;
	}

	/**
	 * @param carRepo the carRepo to set
	 */
	public void setCarRepo(CarroRepository carRepo) {
		this.carRepo = carRepo;
	}

	@Override
	public Carro inserirCarro(Carro carro) {
		return carRepo.save(carro);
	}

	@Override
	public Carro buscar(String nome) {
		return carRepo.findByNome(nome);
	}

	@Override
	public List<Carro> buscarTodos() {
		List<Carro> busca = new ArrayList<Carro>();
		for(Carro carro: carRepo.findAll()){
			busca.add(carro);
		}
		return busca;
	}
}
