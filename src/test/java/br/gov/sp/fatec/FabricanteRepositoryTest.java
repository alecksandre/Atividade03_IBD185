package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Fabricante;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.FabricanteRepository;
import br.gov.sp.fatec.repository.ModeloRepository;
import br.gov.sp.fatec.service.SegurancaCarro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Rollback
@Transactional
public class FabricanteRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private FabricanteRepository fabricanteRepo;
	@Autowired
	private ModeloRepository modeloRepo;
	@Autowired
	private CarroRepository carroRepo;
	
	public void setFabricanteRepo(FabricanteRepository fabricanteRepo) {
		this.fabricanteRepo = fabricanteRepo;
	}
	
	public void setModeloRepo(ModeloRepository modeloRepo) {
		this.modeloRepo = modeloRepo;
	}
	
	public void setCarroRepo(CarroRepository carroRepo) {
		this.carroRepo = carroRepo;
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
	
	//teste o serviço
	@Test
	public void testeInsercaoCarroOk(){
		// Carregando o arquivo ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//insere no banco pelo serviço
		SegurancaCarro car = (SegurancaCarro) context.getBean("segurancaCarro");
		car.insereCarro();
		//
		Carro carro = new Carro();
		carro.setNome("Clio");
		assertTrue(carro.getNome() == "Clio");
	}
	
	@Test
	public void testeDelecaoCarroOk(){
		Carro carro = new Carro();
		carro.setId((long) 01);;
		carroRepo.delete(carro);
		assertTrue(carro.getId()!=null);
	}

	
}
