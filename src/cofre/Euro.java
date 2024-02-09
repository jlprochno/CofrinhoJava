package cofre;

/*Criação da subclasse Euro conforme solicitada no diagrama e filiando-a à classe Moeda (classe mãe)*/
public class Euro extends Moeda{
	
	/*Inserindo o metodo construtor para o Euro, definindo que o valor de Euro será o que o usuário digitar.*/
	public Euro (double valorInserido) {
		this.valor = valorInserido;
	}
	
	/*Declarando metodo info para o Euro herdado da classe Moeda*/
	@Override
	public void info() {
		System.out.println("Euro - " + valor);	
		
	}
	/*Declarando metodo converter para o Euro herdado da classe Moeda - aqui convertemos Euro para Real*/
	@Override
	public double converter() {
		return this.valor * 5.37;
	}
	/*Declarando método equals para remoção de moedas do cofre*/
	@Override
	public boolean equals (Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		/*Cast criado para que todos os valores em Euro sejam considerados em Euro na remoção de moedas do Cofrinho*/
		 Euro objEuro = (Euro) obj;
		
		if (this.valor != objEuro.valor) {
			return false;
		}
		return true;
	}

}