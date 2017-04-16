package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		//Carregando os repositorios pelo servi�o
		SegurancaFabricanteService fab = (SegurancaFabricanteService)context.getBean("segurancaFabricanteService");
		SegurancaModelo mod = (SegurancaModelo) context.getBean("segurancaModelo");
		SegurancaCarro car = (SegurancaCarro) context.getBean("segurancaCarro");
		
		//insere no banco pelo servi�o
		//fab.fabricanteTransacao();
		//mod.insereModelo();
		//car.insereCarro();
		
		//Busca no banco pelo servi�o
		fab.buscaFabricante();
		mod.buscaModelo();
		car.buscaCarro();
		
		//deleta do banco pelo servi�o
		//car.deleteCarro();
		//fab.deleteFabricante();
		//mod.deleteModelo();
   }
}