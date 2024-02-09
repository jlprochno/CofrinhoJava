package cofre;

/*Importando o metodo ArrayList*/
import java.util.ArrayList;

public class Cofrinho {
	/*Criando uma lista de moedas privada conforme solicitado no diagrama*/
	private ArrayList <Moeda> listaDeMoedas;
	
	/*Inserindo o metodo construtor para a lista de moedas vazia,
	 *  definindo que o valor da Moeda será o que o usuário digitar.*/
	public Cofrinho () {
		this.listaDeMoedas = new ArrayList<>();
	}
	/*Criando o método de adção de moedas, conforme solicitado no diagrama*/
	public void adicionar (Moeda moedaInicial) {
		this.listaDeMoedas.add(moedaInicial);
	}
	
	/*Criando o método de remoção de moedas, conforme solicitado no diagrama*/
	public boolean remover(Moeda moedaInicial) {
		return this.listaDeMoedas.remove(moedaInicial);
	}	
	
	/*Criando o método de listagem das moedas, conforme solicitado no diagrama*/
	public void listagemMoedas() {
		
		/*Caso o Cofrinho esteja vazio ele retornará a mensagem: 
		 * "Seu cofrinho está vazio, por gentileza, insira uma moeda! :)"*/
		
		if (this.listaDeMoedas.isEmpty()) {
			System.out.println("Que pena! Seu cofrinho esta vazio no momento, por gentileza insira uma moeda! :)");
			return;
		}
		/*Criação do loop para inserção e listagem das moedas inseridas*/
		for (Moeda moeda : this.listaDeMoedas) {
			moeda.info();
		}
	}
	/*método de soma e conversão de moedas conforme solicitado no diagrama*/
	public double totalConvertido() {
		if (this.listaDeMoedas.isEmpty()) {
			return 0;
		} 		
		/*criação de uma variável que ira acumular os valores inseridos*/
		double acumuloDeValor = 0;
		
		/*loop criado para somar os valores e chamar o metodo converter 
		 * para realizar a conversão das moedas conforme o tipo de cada uma*/
		for (Moeda moeda : this.listaDeMoedas) {
			acumuloDeValor = acumuloDeValor + moeda.converter();
		}
		return acumuloDeValor;
	}

}
