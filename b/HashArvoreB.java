package hash;
import arvore.ArvoreB;

public class HashArvoreB {

	private int M; // tamanho da tabela
	private Celula[] tabela;// tabela propriamente
	
	private class Celula{

		private Integer chave;
		private boolean vazio;
		private ArvoreB arvore;
		
		Celula(){
			this.chave = null;
			this.vazio = true;
			this.arvore = null;
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

	public HashArvoreB(int M) {
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
		
		if( j > M-1) {
			tabela[h(chave + j)].arvore = new ArvoreB();
			tabela[h(chave + j)].arvore.insere(chave, chave);
		}
		else { 
			tabela[h(chave + j)].setChave(chave);
			tabela[h(chave+j)].setVazio(false);
		}

	}
	
	public void remove(int chave) {
		int pos = h(chave), j = 0;
		while( (tabela[h(chave+j)].isVazio()  ||  tabela[h(chave+j)].getChave() != chave) && j++ <= M-1);
		
		if( j > M-1 ) {
			if (tabela[h(chave + j)].arvore.get(chave) != null) {
				/** Quando o valor passado para o metodo insere é @code { null }, a chave é removida */
				tabela[h(chave + j)].arvore.insere(chave, null);
			}
		}
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
