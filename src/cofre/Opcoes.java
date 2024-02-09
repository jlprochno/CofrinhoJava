package cofre;

import java.util.Scanner;

/*Classe criada com intuito de contruir um menu para o cofrinho.
 * Criei uma classe a parte da classe Principal, pois acredito que assim o código ficará menos confuso*/
public class Opcoes {
	
	/*Inserindo o atributo Scanner para que o usuário possa digitar uma opção e 
	 * nomenado-o de "scan" para facilitar a sua chamada*/
	private Scanner scan;
	
	/*Criação do atributo Cofre que posteriormentes será instanciado no método construtor abaixo, 
	 * com o intuito de inicializar o Cofrinho*/
	private Cofrinho cofre;
	
	/*Inserindo o método construtor para definir que o usuário que vai digitar as Opções no Scanner 
	 * e o programa inicializara o cofrinho*/
	public Opcoes() {
		scan = new Scanner(System.in);
		cofre = new Cofrinho();
	}
	
	
	/*Implementação do método do Menu, para que o usuário consiga visualizar as opções*/
	public void mostrarMenu () {
		System.out.println("------------------------BEM-VINDO AO SEU COFRINHO!------------------------");
		System.out.println("\n***Digite a opcao desejada:***");
		System.out.println("\n1 - Inserir uma nova moeda.");
		System.out.println("2 - Retirar uma moeda.");
		System.out.println("3 - Listar as moedas inseridas.");
		System.out.println("4 - Converter em real e somar o valor de todas as moedas inseridas.");
		System.out.println("0 - Finalizar o Cofrinho.\n" );
		
		/*memorização da escolha do usuário*/
		String escolhaUsuario = scan.next();

		/*switch case para atribuir funcionalidade ao Menu*/
		switch (escolhaUsuario) {
		
		/*Caso o usuário selecione a opção "0" o Cofrinho finalizará*/
		case "0":
			System.out.println("\n--------------------------------------------------------------------------");
			System.out.println("***Cofrinho finalizado, ate a proxima!***");
			break;
		
		/*Caso o usuário selecione a opção "1", o Cofrinho dará as opções de tipo de moeda
		*e solicitará que o usuário digite o valor da moeda que ele deseja inserir, 
		* nesse case eu chamo o método menuMoedas que está abaixo no código*/
		case "1":	
			menuMoedas();
			mostrarMenu();
			break;
		
		/*Caso o usuário selecione a opção "2", o Cofrinho dará as opções de tipo de moeda
		*e solicitará que o usuário digite o valor da moeda que ele deseja remover, 
		* nesse case eu chamo o método menuRemoverMoedas que está abaixo no código*/
		case "2":
			menuRemoverMoedas();
			mostrarMenu();
			break;			
		
		/*Caso o usuário selecione a opção "3", o Cofrinho listará quais e qual o valor 
		 * das moedas inseridas no Cofrinho, nesse case eu chamo o metodo listagemMoedas que está  
		 * na Classe Cofrinho*/
		case "3":
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("***Abaixo temos a lista de moedas que voce tem: ***");
			cofre.listagemMoedas();
			mostrarMenu();			
			break;
		
		/*Caso o usuário selecione a opção "4" o Cofrinho irá converter todos os valores das moedas em Real,
		 * e somará, imprimindo o valor da soma na tela para o usuário.*/
		case "4":
			System.out.println("--------------------------------------------------------------------------");
			double somaConvertida = cofre.totalConvertido();
			System.out.printf("\nO valor total, somado e convertido em Real inserido em seu cofrinho e de: R$ %.2f\n \n",somaConvertida);
			mostrarMenu();
			break;
			
		default: 
			System.out.println("***Opcao invalida, tente novamente!***");
			mostrarMenu();
			break;
		}
	}
	
		/*método criado para tratar a inserção das moedas pelo tipo*/
		private void menuMoedas() {
			
			/*Imprimindo na tela o menu para o usuário escolher um tipo de moeda*/
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Otima escolha! Para inserir uma nova moeda eu preciso que voce escolha o tipo dela.");
			System.out.println("Entao, por gentileza, escolha um dos tres tipos abaixo: ");
			System.out.println("1 - Real;");
			System.out.println("2 - Dolar;");
			System.out.println("3 - Euro;");
		
			/*método para memorizar o tipo moeda escolhido*/
			int tipoMoeda = scan.nextInt();
		
		/*switch case para validar a escolha do tipo de moeda*/
		switch (tipoMoeda) {			
		case 1:			
			System.out.println("***Voce escolheu o tipo: 1 - Real***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		case 2:			
			System.out.println("***Voce escolheu o tipo: 2 - Dolar***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		case 3:			
			System.out.println("***Voce escolheu o tipo: 3 - Euro***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		/*Caso o usuário escolha um tipo errado, o programa retorna ao início, 
		 *do menu de escolha do tipo*/	
		default: 
			System.out.println("***Opcao invalida, tente novamente!***");
			menuMoedas();
			break;
		}	
		
		/*Solicitando o valor para a inserção da moeda*/
		System.out.println("Maravilha! Agora, por gentileza, digite o valor da sua moeda: \n");	
		
		/*memorização da escolha do usuário em uma string para depois substituir a virgula digitada por ponto,
		 *para que o usuário possa inserir moedas com virgulas ou pontos sem dar erros futuros.*/
		String valorDigitadoEmTexto = scan.next();
		valorDigitadoEmTexto = valorDigitadoEmTexto.replace(",", ".");
				
		/*transformando a variável que era String em Double, com o tratamento da vírgula*/
		double valorDigitadoEmDouble = Double.valueOf(valorDigitadoEmTexto);
		
		/*Implementação da variável Moeda vazia para que o if receba o valor 
		 * e adicione nessa variável, memorizando o valor na lista*/
		Moeda moeda = null;
		
		/*if para memorizar o tipo de moeda e o valor digitado*/
		if (tipoMoeda == 1) {
			moeda = new Real(valorDigitadoEmDouble);
		} else if (tipoMoeda == 2) {
			moeda = new Dolar(valorDigitadoEmDouble);
		}else if (tipoMoeda == 3) {
			moeda = new Euro(valorDigitadoEmDouble);
		}
		 /*Aqui eu chamo a função para adicionar à lista as moedas inseridas no cofrinho*/
		cofre.adicionar(moeda);
		
		/*Imprime na tela o valor inserido pelo usuário*/
		System.out.println("***O valor inserido foi: " + valorDigitadoEmDouble + "***");
		}	

		/*Método criado para tratar a remoção das moedas pelo tipo*/
		private void menuRemoverMoedas() {
			
			/*Imprimindo na tela o menu para o usuário escolher um tipo de moeda*/
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Que pena! Para remover uma moeda eu preciso que voce escolha o tipo dela.");
			System.out.println("Entao, por gentileza, escolha um dos tres tipos abaixo: ");
			System.out.println("1 - Real;");
			System.out.println("2 - Dolar;");
			System.out.println("3 - Euro;");
		
			/*método para memorizar o tipo moeda escolhido*/
			int tipoRemoverMoeda = scan.nextInt();
		
		/*switch case para validar a escolha do tipo de moeda*/
		switch (tipoRemoverMoeda) {			
		case 1:			
			System.out.println("***Voce escolheu o tipo: 1 - Real***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		case 2:			
			System.out.println("***Voce escolheu o tipo: 2 - Dolar***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		case 3:			
			System.out.println("***Voce escolheu o tipo: 3 - Euro***");	
			System.out.println("--------------------------------------------------------------------------");
			break;
			
		/*Caso o usuário escolha um tipo errado, o programa retorna ao início, 
		 *do menu de escolha do tipo*/	
		default: 
			System.out.println("***Opcao invalida, tente novamente!***");
			menuRemoverMoedas();
			break;
		}	
		
		/*Solicitando o valor para a remoção da moeda*/
		System.out.println("Agora, por gentileza, digite o valor da sua moeda: \n");	
		
		/*memorização da escolha do usuário em uma string para depois substituir a virgula digitada por ponto,
		 *  para que o usuário possa remover moedas com virgulas ou pontos sem dar erros futuros.*/
		String valorDigitadoEmTexto = scan.next();
		valorDigitadoEmTexto = valorDigitadoEmTexto.replace(",", ".");
				
		/*transformando a variável que era String em Double, com o tratamento da vírgula*/
		double valorDigitadoEmDouble = Double.valueOf(valorDigitadoEmTexto);
		
		/*Implementação da variável Moeda vazia para que o if receba o valor 
		 * e remova nessa variável*/
		Moeda moeda = null;
		
		/*if para memorizar o tipo de moeda e o valor digitado*/
		if (tipoRemoverMoeda == 1) {
			moeda = new Real(valorDigitadoEmDouble);
		} else if (tipoRemoverMoeda == 2) {
			moeda = new Dolar(valorDigitadoEmDouble);
		}else if (tipoRemoverMoeda == 3) {
			moeda = new Euro(valorDigitadoEmDouble);
		}
		
		/*Aqui eu chamo a função para remover as moedas inseridas na lista*/
		boolean remocaoMoeda = cofre.remover(moeda);
		
		if(remocaoMoeda) {
			/*Imprime na tela o valor inserido pelo usuário em Double*/
			System.out.println("***O valor removido foi: " + valorDigitadoEmDouble + "***");
		} else {
			/*Caso o Cofrinho não tenha a moeda solicitada para remoção pelo usuário, 
			 * o Cofrinho imprimirá a seguinte mensagem na tela: "Desculpa! Nao encontrei nenhuma 
			 * moeda com esse valor!"*/
			System.out.println("***Desculpa! Nao encontrei nenhuma moeda com esse valor! ");
		}	

	}
		
}
		
