package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Fabricante;
import br.gov.sp.fatec.model.Modelo;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.FabricanteRepository;
import br.gov.sp.fatec.repository.ModeloRepository;
import br.gov.sp.fatec.service.SegurancaCarro;
import br.gov.sp.fatec.service.SegurancaModelo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Rollback
@Transactional
public class CarroRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	
	@Autowired
	private FabricanteRepository fabricanteRepo;
	
	@Autowired
	private SegurancaModelo modService;
	
	@Autowired
	private SegurancaCarro carService;
	
	public void setFabricanteRepo(FabricanteRepository fabricanteRepo) {
		this.fabricanteRepo = fabricanteRepo;
	}
	
	public void setModService(SegurancaModelo modService){
		this.modService = modService;
	}
	
	public void setCarService(SegurancaCarro carService) {
		this.carService = carService;
	}

	@Test
	public void testeInsercaoFabricanteOk(){
		Fabricante fabricante  = new Fabricante();
		fabricante.setNome("Fiat");
		fabricanteRepo.save(fabricante);
		assertTrue(fabricante.getNome() != null);
	}
	@Test
	public void testeDelecaoFabricanteOK(){
		Fabricante fabricante = new Fabricante();
		fabricanteRepo.delete((long) 01);
		assertTrue(fabricante.getId() == null);
	}
	
	//testa pelo serviço
	
	@Test
	public void testeModeloInsereOK(){
		
		Modelo modelo = new Modelo();
		modelo.setTipo("Popular");
		modService.inserir(modelo);
		assertTrue(modelo.getId() != null);
	}
	
	@Test
	public void testeInsercaoCarroOk(){
		
		Fabricante fabricante  = new Fabricante();
		Modelo modelo = new Modelo();
		fabricante.setId((long) 01);
		modelo.setId((long) 01);
		
		Carro carro = new Carro();
		carro.setNome("Clio");
		carro.setPreco(1000000);
		carro.setFabricante(fabricante);
		carro.setModelo(modelo);
		carService.inserirCarro(carro);
		
		assertTrue(fabricante.getId() != null);
	}
}
