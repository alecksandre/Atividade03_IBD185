package br.gov.sp.fatec.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "car_id")
	private Long id;
    @Column(name = "car_nome", unique=true, length = 100, nullable = false)
    private String nome;
    @Column(name = "car_preco", unique=true, length = 100, nullable = false)
    private Integer preco;
    
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "fab_id", nullable = true)
	private Fabricante fabricante;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "mod_id", nullable = true)
	private Modelo modelo;
     
        
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
	 * @return the preco
	 */
	public Integer getPreco(){
		return preco;
	}
	
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Integer preco) {
		this.preco = preco;
	}
	
	/**
	 * @return the fabricante
	 */
	public Fabricante getFabricante(){
		return fabricante;
	}
	
	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(Fabricante fabricante){
		this.fabricante = fabricante;
	}

	/**
	 *@return the modelo
	 */
	public Modelo getModelo(){
		return modelo;	
	}
	
	/**
	 *@param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo){
		this.modelo = modelo;
	}

}
