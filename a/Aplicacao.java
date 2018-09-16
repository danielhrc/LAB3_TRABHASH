package Trabalho1.a;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		HashLinear hash = new HashLinear(11);
		
		hash.insere(10);
		hash.insere(2);
		hash.insere(3);
		hash.insere(15);
		hash.insere(28);
		hash.insere(21);
		hash.insere(25);
		hash.imprime();
		
		hash.remove(10);
		hash.remove(21);
		
		hash.imprime();



	}

}
