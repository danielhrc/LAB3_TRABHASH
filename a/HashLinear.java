package Trabalho1.a;

public class HashLinear implements Inserivel{
	/*
* a)  Crie  duas  implementações  de  Tabela  Hash,  sendo  uma  Linear,
* com tratamento  de  Colisões  na  Própria  Estrutura,  
 * com  tamanho  total  de  elementosa  ser  setada  dinamicamente  no  início  da  execução,
 * podendo  ter  no  mínimo tamanho  3  e  máximo  a  capacidade  máximo  da  memória  interna
	 */

	private int M; // tamanho da tabela
	private Celula[] tabela;// tabela propriamente
	
	private class Celula{

		private Integer chave;
		private boolean vazio;
		
		Celula(){
			this.chave = null;
			this.vazio = true;
		}
		
		public Integer getChave() {
			return chave;
		}
		public void setChave(Integer chave) {
			this.chave = chave;
		}
		public boolean isVazio() {
			return vazio;
		}
		public void setVazio(boolean vazio) {
			this.vazio = vazio;
		}
		
	}

	public HashLinear(int M) {
		if(M < 3) M = 3;
		this.M = M;
		tabela = new Celula[M];
		for (int x = 0; x < tabela.length; x++)
			tabela[x] = new Celula();
	}
	
	public int h(int x) {
		return x % M;
	}

	public void insere(int chave) throws Exception {

		int pos = h(chave) , j = 0;
		
		while ( !(tabela[h(chave + j)].isVazio()) && j++ <= M-1);
		
		if( j > M-1) System.out.println("Não foi possível inserir o elemento "+chave+" na tabela pois a mesma está cheia");
		else { 
			tabela[h(chave + j)].setChave(chave);
			tabela[h(chave+j)].setVazio(false);
		}

	}
	
	public void remove(int chave) {
		int pos = h(chave), j = 0;
		while( (tabela[h(chave+j)].isVazio()  ||  tabela[h(chave+j)].getChave() != chave) && j++ <= M-1);
		
		if( j > M-1 ) System.out.println("Não foi possível encontrar a chave "+chave+" na tabela para remove-la");
		else {
			tabela[h(chave + j)].setChave(null);
			tabela[h(chave+j)].setVazio(true);
		}
	}


	public void imprime() {
		for (int x = 0; x < tabela.length; x++) {
			System.out.println(tabela[x].getChave());
		}
		System.out.println();
	}

}
