package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fabricante")
public class Fabricante {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "fab_id")
	private Long id;
    @Column(name = "fab_nome", unique=true, length = 100, nullable = false)
    private String nome;
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fabricante")
	private List<Carro> carros;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the carros
	 */
	public List<Carro> getCarros(){
		return carros;
	}

	/**
	 * @param carros the carros to set
	 */

	public void setCarros(List<Carro> carros){
		this.carros = carros;
	}
}
