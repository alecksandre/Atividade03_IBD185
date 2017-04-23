package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Fabricante;

public interface SegurancaFabricanteService {
	
	public Fabricante inserir(Fabricante fabricante);
	
	public Fabricante buscarFabricante(String nome);
	
	public Fabricante buscarId(Long id);
	
	public List<Fabricante> buscarTodos();
	
	
}
