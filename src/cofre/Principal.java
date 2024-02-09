package cofre;

public class Principal {
	/*Chamei o metodo main, pois é obrigatório em qualquer programa em java. 
	 * É por aqui que o código começa a ser executado.*/
	public static void main(String[] args) {
		
		/*Aqui eu estou instanciando a classe chamada Cofrinho, 
		que tem o intuito de imprimir na tela o menu de opções*/		
		Opcoes menu = new Opcoes();
		menu.mostrarMenu();		
	}
}
