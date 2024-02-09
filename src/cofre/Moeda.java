package cofre;
/*Criação da classe abstrata Moeda conforme solicitada no diagrama, 
 * essa classe será uma classe mãe das classes Real, Dolar e Euro */
public abstract class Moeda {
	
	/*criação da variável protegida para deixar o código mais seguro*/
	protected double valor;
	
	/*criação metodo info*/
	public abstract void info();
	
	/*criação metodo converter*/
	public abstract double converter();

}
