package cofre;

/*Criação da subclasse Real conforme solicitada no diagrama e filiando-a à classe Moeda (classe mãe)*/
public class Real extends Moeda {
	
	/*Inserindo o metodo construtor para o Real, definindo que o valor de Real será o que o usuário digitar.*/
	public Real(double valorInserido) {
		this.valor = valorInserido;
	}

	/*Declarando metodo info para o Real herdado da classe Moeda*/
	@Override
	public void info() {
		System.out.println("Real - " + valor);
		
	}
	/*Declarando metodo converter para o Real herdado da classe Moeda*/
	@Override
	public double converter() {
		return this.valor;
		
	}
	/*Declarando método equals para remoção de moedas do cofre*/
	@Override
	public boolean equals (Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		/*Cast criado para que todos os valores em Real sejam considerados em Real na remoção de moedas do Cofrinho*/
		 Real objReal = (Real) obj;
		
		if (this.valor != objReal.valor) {
			return false;
		}
		return true;
	}

}
