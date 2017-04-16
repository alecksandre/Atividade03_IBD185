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
@Table(name = "modelo")
public class Modelo {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "mod_id")
	private Long id;
    @Column(name = "mod_tipo", unique=true, length = 100, nullable = false)
    private String tipo;
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modelo")	
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
