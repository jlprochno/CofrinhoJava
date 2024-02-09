package cofre;

/*Criação da subclasse Dolar conforme solicitada no diagrama e filiando-a à classe Moeda (classe mãe)*/
public class Dolar extends Moeda{
	
	/*Inserindo o metodo construtor para o Dolar, definindo que o valor de Dolar será o que o usuário digitar.*/
	public Dolar(double valorInserido) {
		this.valor = valorInserido;
	}
	
	/*Declarando metodo info para o Dolar herdado da classe Moeda*/
	@Override
	public void info() {
		System.out.println("Dolar - " + valor);	
		
	}
	/*Declarando metodo converter para o Dolar herdado da classe Moeda - aqui convertemos Dolar para Real*/
	@Override
	public double converter() {
		return this.valor * 4.82;
	}
	/*Declarando método equals para remoção de moedas do cofre*/
	@Override
	public boolean equals (Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		/*Cast criado para que todos os valores em Dolar sejam considerados em Dolar na remoção de moedas do Cofrinho*/
		 Dolar objDolar = (Dolar) obj;
		
		if (this.valor != objDolar.valor) {
			return false;
		}
		return true;
	}

}