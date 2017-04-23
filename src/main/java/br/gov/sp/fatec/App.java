package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Carro;
import br.gov.sp.fatec.model.Fabricante;
import br.gov.sp.fatec.model.Modelo;
import br.gov.sp.fatec.service.SegurancaCarro;
import br.gov.sp.fatec.service.SegurancaFabricanteService;
import br.gov.sp.fatec.service.SegurancaModelo;

/**
 *Atividade 02
 */
public class App {
	public static void main(String[] args) {

		// Carregando o arquivo ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Carregando os repositorios pelo serviço
		SegurancaFabricanteService fab = (SegurancaFabricanteService)context.getBean("segurancaFabricanteService");
		SegurancaModelo mod = (SegurancaModelo) context.getBean("segurancaModelo");
		SegurancaCarro car = (SegurancaCarro) context.getBean("segurancaCarro");
		
		//Insere Fabricante
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("Renault");
		
		fab.inserir(fabricante);
		
		//Insere Modelo
		Modelo modelo = new Modelo();
		modelo.setTipo("Popular");
		mod.inserir(modelo);

		//Insere Carro
		Carro carro = new Carro();
		carro.setNome("Clio");
		carro.setPreco(1000000);
		carro.setFabricante(fabricante);
		carro.setModelo(modelo);
		car.inserirCarro(carro);
		
		//Consulta Carros

		for (Carro mostra: car.buscarTodos()){
			System.out.println("Id: " + mostra.getId() + " Nome: "+ carro.getNome() +" Preço: " + carro.getPreco() 
			+" Fabricante: " + carro.getFabricante().getNome() +" Modelo: "+ carro.getModelo().getTipo());
		}
		
   }
}