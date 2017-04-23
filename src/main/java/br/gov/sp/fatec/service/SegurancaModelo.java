package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Modelo;

public interface SegurancaModelo {
	
	public Modelo inserir(Modelo modelo);
	
	public Modelo buscaId(Long id);
	
	public Modelo buscaTipo(String nome);
	
}
