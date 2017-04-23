package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Carro;

public interface SegurancaCarro {
	
	public Carro inserirCarro(Carro carro);
	
	public Carro buscar(String nome);
	
	public List<Carro> buscarTodos();

}
